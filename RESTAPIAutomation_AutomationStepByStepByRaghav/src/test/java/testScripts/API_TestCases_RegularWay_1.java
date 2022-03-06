package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_TestCases_RegularWay_1 {

	@Test
	public void test_GET_001() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		int statusCode = response.getStatusCode();
		System.out.println("The Status Code is :"+ statusCode);
		
		long responseTime = response.getTime();
		System.out.println("The Response Time is :"+ responseTime);
		
		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is : "+responseBody);
		
		String statusLine = response.getStatusLine();
		System.out.println("The Status Line is : " + statusLine);
		
		String contentType = response.getHeader("content-type");
		System.out.println("The Content Type is :" + contentType );
		
		
		//Test Assertions / Validations
		
		Assert.assertEquals(statusCode, 200);
	}
	
}
