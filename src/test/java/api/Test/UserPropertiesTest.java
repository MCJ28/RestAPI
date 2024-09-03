package api.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Endpoints.UserPropertiesEndPoints;
import api.Payloads.User;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class UserPropertiesTest 
{
	Faker faker = new Faker();
	User user = new User();
	
	@BeforeMethod
	public void SetData()
	{
		user.setId(faker.idNumber().hashCode());
        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().cellPhone());
	}
	
	
	@Test(priority=1)
	public void Create()
	{
		 Response response = UserPropertiesEndPoints.Create(user);
	        response.then().log().all();

	        Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=2)
	public void Get()
	{
	      Response response = UserPropertiesEndPoints.Get(user.getUsername());
	        response.then().log().all();

	        Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=3)
	public void Update()
	{
		 user.setId(faker.idNumber().hashCode());
	        user.setUsername(faker.name().firstName() + "_" + faker.name().lastName());
	        user.setEmail(faker.internet().emailAddress());
	        user.setPassword(faker.internet().password());
	        user.setPhone(faker.phoneNumber().cellPhone());

	        // Update user
	        Response response = UserPropertiesEndPoints.Update(user, user.getUsername());
	        response.then().log().all();

	        Assert.assertEquals(response.getStatusCode(), 200);

	        // Validate update by fetching the user
	        Response response2 = UserPropertiesEndPoints.Get(user.getUsername());
	        response2.then().log().all();

	        Assert.assertEquals(response2.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=4)
	public void Delete()
	{
        Response response = UserPropertiesEndPoints.Delete(user.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
	}
}
