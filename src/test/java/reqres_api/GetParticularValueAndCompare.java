package reqres_api;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetParticularValueAndCompare {
	
	@Test(priority=1)
	 void validateUser()
	{
				
		Response res=given()
		.contentType("application/json")
	     .when()
		.get("http://localhost:3000/Student");
		
		JSONObject jo=new JSONObject(res.asString());
		boolean status=false;
		for(int i=0; i<jo.getJSONArray("arrayName").length();i++)
		{
			String name=jo.getJSONArray("arrayname").getJSONObject(i).get("name").toString();
			
			if(name.equals("Jhon44"))
			{
				 status=true;
			  break;
			}
}
		Assert.assertEquals(status, true);
			
}
}
