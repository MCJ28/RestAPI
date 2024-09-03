package api.Endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.Payloads.PetPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndpoints 
{
	public static Response CreatePet(PetPojo payload)
	{
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			
		.when()
			.post(Routes.PostPet_URL);
		
		return res;
	}
	
	
	public Response Get(String Pet_Id, PetPojo payload)
	{
		Response res = given()
			.pathParam("petId", Pet_Id)
			
		.when()
			.get(Routes.GetPet_URL);
		
		return res;
	}
	
	
	public Response update(PetPojo payload)
	{
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				
			.when()
				.post(Routes.PostPet_URL);
			
			return res;
	}
	
	
	public Response delete(String Pet_Id, PetPojo payload)
	{
		Response res = given()
				.pathParam("petId", Pet_Id)
				
			.when()
				.get(Routes.GetPet_URL);
			
			return res;
	}
	
	
	
	
	
	
	
	
}
