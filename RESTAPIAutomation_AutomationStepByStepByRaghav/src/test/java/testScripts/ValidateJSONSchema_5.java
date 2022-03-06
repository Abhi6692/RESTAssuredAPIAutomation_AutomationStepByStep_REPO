package testScripts;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import org.testng.annotations.Test;

//1. Create JSON Schema - Mostly we will get the JSON Schema form the Devs
//2. Add JSON Schema File in Class path / Add the File in the src/test/resources folder
//3. Add Maven dependency for JSON Schema Validator



public class ValidateJSONSchema_5 {
	
	@Test
	public void testGET() {
		
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2").then().assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
		
	}
}
