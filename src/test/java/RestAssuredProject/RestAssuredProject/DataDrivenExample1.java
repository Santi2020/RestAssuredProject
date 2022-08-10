package RestAssuredProject.RestAssuredProject;

//import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.beust.jcommander.Parameter;

import io.restassured.http.ContentType;



//import org.json.simple.JSONObject;

//import org.testng.annotations.Test;

//import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataDrivenExample1 extends DataForTests {
	
	//@Test (dataProvider="TestData")
	public void test_post(String fName, String lName, int subId) {
		baseURI="http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("firstName", fName);
		request.put("lastName", lName);
		request.put("subjectId", subId);
		//request.put("id", 10);
		
		System.out.println("request = " + request.toJSONString());
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()			
			.post("/users")
		.then()
			.statusCode(201)
			.log()
			.all()
			;
	}
	
	
//	@Test(dataProvider ="dataToDelete")
	public void test_delete(int id) {
		baseURI="http://localhost:3000";
		when()
			.delete("/users/"+id)
		.then()
			.statusCode(200);
	}
	
	
	@Parameters({"userid"})
	//@Test//(dataProvider ="dataToDelete")
	public void test_delete2(int userid) {
		baseURI="http://localhost:3000";
		
		System.out.println("Userid = " + userid );
		when()
			.delete("/users/"+userid)
		.then()
			.statusCode(200);
	}

}
