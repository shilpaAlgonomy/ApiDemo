package reqres_api;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class CreateBodyUsingPOJO {

	@Test
	void postPOJO()
	{
	POJO data=new POJO();
	
	data.setName("shilpa");
	data.setPhone("1234567");
	data.setLocation("Mysore");
	String[] coursesArr= {"C","C++"};
	data.setCourses(coursesArr);
	String name=data.getName();
	System.out.println("Name is :"+name);
	
	given()
	.contentType("application/json")
	.body(data)
	
	.when()
	.put("http://localhost:3000/Student")
	
	.then()
	.statusCode(404)
	.log().body();
	

}		
}
