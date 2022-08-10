package RestAssuredProject.RestAssuredProject;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Examples {

	//@Test
	public void test_get() {
		baseURI="http://localhost:3000";
		given()
		.header("Content Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		//.param("name" , "Automation")
		//.get("/subjects")
		.param("Id" , "3")
		.get("/users")
		.then()
		.statusCode(200)
		.log()
		.all();
	}
	
	//working
	//@Test
	public void test_post() {
		//baseURI="http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Post_first_test");
		request.put("lastName", "Post_last_test");
		request.put("subjectId", "1");
		//request.put("id", 11);
		
		System.out.println("request = " + request.toJSONString());
		given()
		.header("Content Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()			
			.post("http://localhost:3000/users")
			//.post("http://localhost:3000/users")
		.then()
			//.statusCode(201)
			.log()
			.all()
			;
	}


	//working
	//@Test
	public void test_patch() {
		
		baseURI="http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("lastName", "Updated_last_patch");
		
		//request.put("subjectId", "1");
		//request.put("id", 1);
		
		System.out.println("request = " + request.toJSONString());
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Content-Type", "application/json")			
			.body(request.toJSONString())
		.when()
			.patch("/users/11")
		.then()
			.statusCode(200)
			.log()
			.all()
			;
	}

	
	@Test
	public void test_put() {
		
		//baseURI="http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Put_first_temp");
		request.put("lastName", "Put_last_temp");
		request.put("subjectId", "1");
		//request.put("id", 1);
		
		System.out.println("request = " + request.toJSONString());
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.header("Content-Type", "application/json")			
			.body(request.toJSONString())
		.when()
			.put("http://localhost:3000/users/1")
		.then()
			.statusCode(200)
			.log()
			.all()
			;
	}
	
	//@Test
	public void test_delete() {
		baseURI="http://localhost:3000";
		when()
			.delete("http://localhost:3000/users/1")
		.then()
			.statusCode(200);
	}
}
