package testScripts;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
public class GET_POST_3 {

	@Test
	public void testGET() {
		
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2").then().statusCode(200).
		body("data[1].first_name", equalTo("Lindsay")).body("data.first_name", hasItems("George","Rachel"));
		
	}
	
	@Test
	public void testPOST() {
	
	//We need a body in POST request
	JSONObject request = new JSONObject();
	request.put("name", "Abhishek");
	request.put("Job", "Fitness Teacher");
	
	baseURI="https://reqres.in/api";
		
	
	given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
	body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}
}