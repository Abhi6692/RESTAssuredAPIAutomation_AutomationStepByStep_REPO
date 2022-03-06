package testScripts;
//In order to use REST assured effectively it's recommended to 
//statically import methods from the following classes:

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class API_TestCases_StaticImport_2 {

	@Test
	public void test_001() {
		
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();
		
		
	}
}
