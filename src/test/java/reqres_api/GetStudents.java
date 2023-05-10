package reqres_api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class GetStudents {
	
	@Test(priority=1)
	void createUsers()
	{
  
		   HashMap hm=new HashMap();
		   hm.put("name", "shilpa");
		   hm.put("job", "leader");
		   
	 given()
	   .contentType("application/json")
	   .body(hm)
	.when()
	.post("http://localhost:3000/Student")
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
	.get("http://localhost:3000/Student")
	.then()
	.statusCode(200)
	//.body("name", equalTo("Jhon"))
	.header("Connection", equalTo("keep-alive"))
	.log().cookies();
	
	}
	
	@Test(priority=3)
	void updateUser()
	{
		 HashMap hm=new HashMap();
		   hm.put("name", "shilpa");
		   hm.put("job", "leader");
		
		   given()
		   .contentType("application/json")
		   .body(hm)
	.when()
	.get("http://localhost:3000/Student")
	.then()
	.statusCode(200)
	//.body("name", equalTo("Jhon"))
	.header("Connection", equalTo("keep-alive"))
	.log().cookies();
	
	}

}
