package api.Endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.Payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints 
{
	public static Response create(User payload)
	{
		  Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			
		.when()
			.post(Routes.PostUser_Url);
		  
		  return res;
	}
	
	
	public static Response get(String User_Name)
	{
		Response res = given()
			.pathParam("username", User_Name)
			
		.when()
			.get(Routes.GetUser_Url);
		
		return res;
	}
	
	public static Response update(String User_Name, User payload)
	{
		  Response res = given()
			.pathParam("username", User_Name)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			
			
		.when()
			.put(Routes.UpdateUser_Url);
		  
		  return res;
	}
	
	
	public static Response delete(String User_Name)
	{
		Response res = given()
				.pathParam("username", User_Name)
			
		.when()
			.delete(Routes.GetUser_Url);
		
		return res;
	}
}
