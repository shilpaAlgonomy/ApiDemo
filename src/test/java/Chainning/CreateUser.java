package Chainning;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {
	
	@Test
	void createUser(ITestContext context)
	{
	Faker fak=new Faker();
	JSONObject data=new JSONObject();
	
	data.put("fullName",fak.name().fullName());
	data.put("Gender","Female");
	
data.put("email",fak.internet().safeEmailAddress());

  String token="b6f2a087c0d7e793560ad1847fa15c36b44174b05b91ca5c667fc2a301e51aa3";
  
  int id=given()
		  .headers("Authorization", "Bearer "+token)
		  .contentType("application/json")
		  .body(data.toString())
   .when()
   .post("https://gorest.co.in/public/v2/users")
   .jsonPath().getInt("id");
  System.out.println("Generated id is :"+id);
  context.setAttribute("id", id);
	
	
	}

}
