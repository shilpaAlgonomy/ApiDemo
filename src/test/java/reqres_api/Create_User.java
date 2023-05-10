package reqres_api;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;


public class Create_User {
	
	
	@Test(priority=1)
	void createUsers()
	{
  
		   HashMap hm=new HashMap();
		   hm.put("name", "morpheus");
		   hm.put("job", "leader");
		   
	 given()
	   .contentType("application/json")
	   .body(hm)
	.when()
	.post("https://reqres.in/api/users")
	.then()
	.statusCode(201)
	//.body("job", equalTo("leader"))
	.log().all();
  
}
	@Test(priority=2)
	void getUser()
	{
  
	 given()
	.when()
	.get("https://reqres.in/api/users")
	.then()
	.statusCode(200)
	//.body("first_name", equalTo("Janet"))
	.log().all();
	
}
}
