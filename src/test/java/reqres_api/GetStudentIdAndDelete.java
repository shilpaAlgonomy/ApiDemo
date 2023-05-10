package reqres_api;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class GetStudentIdAndDelete {
	
	@Test(priority=1)
	 void createUser()
	{
		int id;
		HashMap hm=new HashMap();
		hm.put("name","shilpa");
		hm.put("work","QA");
		hm.put("address","XYZ");
		String[] courses= {"C","C++"};
		hm.put("courses",courses);
		
		id=given()
		.contentType("application/json")
		.body(hm)
		
		.when()
		.post("http://localhost:3000/Student")
		.jsonPath().getInt("id");
		
		
	}
	
	@Test(priority=2)
	void updateUser()
	{
		HashMap hm=new HashMap();
		hm.put("name","shilpa");
		hm.put("work","Senior Automation Enggineer");
		hm.put("address","fghj");
		
		given()
		.contentType("application/json")
		.body(hm)
		
		.when()
		.put("http://localhost:3000/Student")
		
		.then()
		.statusCode(201)
		.log().body();
		
	}
	
	@Test(priority=3)
	 void getUser()
	{
		
		
		//given()
		
		when()
		.get("http://localhost:3000/Student/{{id}}")
		
		.then()
		.statusCode(200)
		.log().body();
		
	}
	
	@Test(priority=4)
	public void deleteUser()
	{
		
		when()
		.delete("http://localhost:3000/Student/{{id}}")
		
		.then()
		.statusCode(404)
		.log().body();
		
	}

}
