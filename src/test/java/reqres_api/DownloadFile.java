package reqres_api;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

public class DownloadFile {
	
	@Test
	void upload()
	{
		
		given()
		
		.when()
		.get("http://localhost:3000/textFile1.txt")
		.then()
		.statusCode(200);
	}
}


