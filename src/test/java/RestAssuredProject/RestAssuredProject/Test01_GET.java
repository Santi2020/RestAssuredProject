package RestAssuredProject.RestAssuredProject;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import junit.framework.Assert;
import static org.hamcrest.Matchers.*;

public class Test01_GET {
	
	@Test
	public void test_01() {
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println("Executing Test_01");
		System.out.println("Body =" + response.getBody().asString());
		System.out.println("Status = " + response.getStatusCode());
		System.out.println("String = " + response.asString());
		System.out.println("Content type hrader = " + response.getHeader("Content-type"));
		System.out.println("Time = " + response.getTime());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200) ;
		System.out.println("End Test_01");
	}
	
	@Test
	public void test_02() {
		System.out.println("Executing Test_02");
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]" , equalTo(7) );
		System.out.println("End Test_02");
	}
	
}
