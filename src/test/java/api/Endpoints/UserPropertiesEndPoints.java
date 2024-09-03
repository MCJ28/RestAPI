package api.Endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.Payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserPropertiesEndPoints {

	public static ResourceBundle getURL() {
		return ResourceBundle.getBundle("Routes");
	}

	public static Response Create(User payload) {
		String postUrl = getURL().getString("post_url");

		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(postUrl);

		return res;
	}

	public static Response Get(String username) {
		String getUrl = getURL().getString("get_url");

		Response res = given().pathParam("username", username).when().get(getUrl);

		return res;
	}

	public static Response Update(User payload, String username) {
        String updateUrl = getURL().getString("update_url");

        Response res = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .pathParam("username", username)
            .body(payload)
        .when()
            .put(updateUrl);

        return res;
    }

public static Response Delete(String username) {
        String deleteUrl = getURL().getString("delete_url");

        Response res = given()
            .pathParam("username", username)
        .when()
            .delete(deleteUrl);

        return res;
	}
}
