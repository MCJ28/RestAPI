package api.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Endpoints.PetEndpoints;
import api.Payloads.PetPojo;
import io.restassured.response.Response;

public class PetTests 
{
	Faker faker = new Faker();
	
	PetPojo pojo = new PetPojo();
	
	@BeforeClass
	public void SetData()
	{
		pojo.setId(faker.idNumber().hashCode());
		pojo.setName(faker.name().fullName());
		
	}
	
	
	@Test
	public void Post()
	{

		Response response = PetEndpoints.CreatePet(pojo);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
