package reqres_api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResponseBodyValidation {
	
	@Test(priority=1)
	 void validateUser()
	{
				
		Response res=given()
		.contentType("application/json")
	     .when()
		.get("http://localhost:3000/Student");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
		String name=res.jsonPath().get("[3].name").toString();	
		String courses=res.jsonPath().get("[3].Corses[0]").toString();	
		String courses2=res.jsonPath().get("[3].Corses[1]").toString();	
		Assert.assertEquals("Jhon44", name);
		System.out.println(name);
		System.out.println(courses);
		System.out.println(courses2);
		
		
	}

}
