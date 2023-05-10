package reqres_api;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateBodyUsingExternalFile {
	
	@Test
	void testPostUsingExternalFile() throws FileNotFoundException
	{
		
		File file=new File(".\\body.json");
		FileReader fr=new FileReader(file);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		
	given()
	.contentType("application/json")
	.body(data.toString())
	
	.when()
	.post("http://localhost:3000/Student")
	
	.then()
	.statusCode(201)
	
	.log().body()
	.log().cookies()
	.log().headers();
	
}

}
