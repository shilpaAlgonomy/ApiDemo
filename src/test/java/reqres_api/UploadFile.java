package reqres_api;

import java.io.File;
import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class UploadFile {

	@Test
	void upload()
	{
		File file1=new File("C:\\Users\\pshilpa\\Desktop\\My_Folder\\textFile1.txt");
		
		given()
		.multiPart("file", file1)
		.contentType("multipart/form-data")
		
		.when()
		.post("http://localhost:3000/Student")
		.then()
		.statusCode(201);
	}
}
