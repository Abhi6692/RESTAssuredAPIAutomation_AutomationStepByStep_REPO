package testScripts;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PUT_PATCH_DELETE_4 {

	@Test
	public void test_PUT() {
	
		//We need a body in POST request
		JSONObject request = new JSONObject();
		request.put("name", "Abhishek");
		request.put("Job", "Fitness Teacher - Updated");
		
		baseURI="https://reqres.in/api";
			
		
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();
		}
		
	
	@Test
	public void test_PATCH() {
	
		//We need a body in POST request
		JSONObject request = new JSONObject();
		request.put("name", "Abhishek");
		request.put("Job", "Fitness Teacher - Updated via PATCH");
		
		baseURI="https://reqres.in/api";
			
		
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().patch("/users/2").then().statusCode(200).log().all();
		}
	
	@Test
	public void test_DELETE() {
	
		
		baseURI="https://reqres.in/api";
			
		given().delete("/users/2").then().statusCode(204).log().all();
		}
	
	}
	

