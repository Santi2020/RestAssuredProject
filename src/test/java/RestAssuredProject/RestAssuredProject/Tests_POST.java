package RestAssuredProject.RestAssuredProject;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class Tests_POST {
	
	//@Test
	public void test_01_post() {
		//Using Map
		Map <String, Object> map = new HashMap<String, Object>();
		map.put("name", "Raghav");
		map.put("job", "Teacher");
		map.put("name", "Pavan");
		map.put("job", "Trainer");
		System.out.println("Map = " + map);
		JSONObject request = new JSONObject(map);
		System.out.println("JSON Map    = " + request);
		System.out.println("JSon String = " + request.toJSONString());
		
		System.out.println("========================");
		//Without using Map
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		System.out.println("Request JSON Map    = " + request);
		System.out.println("Request JSon String = " + request.toJSONString());
		
		given()
		.header("Content Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201);
	}
	
	
	//@Test
	public void test_02_put() {

		JSONObject request = new JSONObject();
		System.out.println("========================");
		//Without using Map
		request.put("name", "RaghavTest02");
		request.put("job", "TeacherTest02");
		System.out.println("Request JSON Map    = " + request);
		System.out.println("Request JSon String = " + request.toJSONString());
		
		given()
		.header("Content Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log()
		.all();		
		
	}
	

	//@Test
	public void test_03_patch() {

		JSONObject request = new JSONObject();
		System.out.println("========================");
		//Without using Map
		request.put("name", "RaghavTest03");
		request.put("job", "TeacherTest03");
		System.out.println("Request JSON Map    = " + request);
		System.out.println("Request JSon String = " + request.toJSONString());
		
		given()
		.header("Content Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.patch("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log()
		.all();				
	}
	
	
	@Test
	public void test_04_delete() {
		when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204)
		.log()
		.all();		
		
	}


}
