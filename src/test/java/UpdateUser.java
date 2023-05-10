import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;

import com.github.javafaker.Faker;

public class UpdateUser {

	void updateUser(ITestContext context)
	{
		Faker fak=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("fullName",fak.name().fullName());
		data.put("Gender","Male");
		
	data.put("email",fak.internet().safeEmailAddress());
	
	int id=(Integer)context.getAttribute("userId");
	  String token="b6f2a087c0d7e793560ad1847fa15c36b44174b05b91ca5c667fc2a301e51aa3";
	  
	  given()
			  .headers("Authorization", "Bearer "+token)
			  .contentType("application/json")
			  .pathParam("userId", id)
			  .body(data.toString())
	   .when()
	   .put("https://gorest.co.in/public/v2/users")
	   .then()
	   .statusCode(201);
	  
	}
}
