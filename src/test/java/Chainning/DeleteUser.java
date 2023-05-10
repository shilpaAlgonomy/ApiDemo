package Chainning;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {

	@Test
	void deleteUser(ITestContext context)
	{

		int id=(Integer)context.getAttribute("id");
	  String token="b6f2a087c0d7e793560ad1847fa15c36b44174b05b91ca5c667fc2a301e51aa3";
	  
	  given()
			  .headers("Authorization", "Bearer "+token)
			 .pathParam("userId", id)
	   .when()
	   .delete("https://gorest.co.in/public/v2/users/{id}")
	   .then()
	   .statusCode(204);
	   
	}
}
