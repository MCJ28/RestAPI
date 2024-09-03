package api.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Endpoints.UserEndpoints;
import api.Payloads.User;
import io.restassured.response.Response;

public class UserTests 
{
	Faker faker = new Faker();
	User userPayLoad = new User();
	
	@BeforeClass
	public void SetData()
	{
		userPayLoad.setId(faker.idNumber().hashCode());
		userPayLoad.setUsername(faker.name().username());
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().emailAddress());
		userPayLoad.setPassword(faker.internet().password());
		userPayLoad.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority=1)
	public void Post()
	{
		Response response = UserEndpoints.create(userPayLoad);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=2)
	public void Get()
	{
		Response response = UserEndpoints.get(this.userPayLoad.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=3)
	public void Update()
	{
		userPayLoad.setId(faker.idNumber().hashCode());
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setFirstName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().emailAddress());
		userPayLoad.setPassword(faker.internet().password());
		userPayLoad.setPhone(faker.phoneNumber().cellPhone());
		
		Response response = UserEndpoints.update(this.userPayLoad.getUsername(), userPayLoad);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		// checking data after update
		
		Response responseData = UserEndpoints.get(this.userPayLoad.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(responseData.getStatusCode(), 200);
	}
	
	
	@Test(priority=4, dependsOnMethods = {"Update"})
	public void Delete()
	{
		Response res = UserEndpoints.delete(this.userPayLoad.getUsername());
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
