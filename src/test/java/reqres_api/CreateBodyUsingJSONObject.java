package reqres_api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class CreateBodyUsingJSONObject {
	
	@Test(priority=1)
	void updateUser()
	{
		JSONObject hm=new JSONObject();
		hm.put("name","shilpa");
		hm.put("work","Senior Automation Enggineer");
		hm.put("address","fghj");
		
		given()
		.contentType("application/json")
		.body(hm.toString())
		
		.when()
		.post("http://localhost:3000/Student")
		
		.then()
		.statusCode(201)
		.log().body();
		
	}
	

}
