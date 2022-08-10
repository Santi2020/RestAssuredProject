package RestAssuredProject.RestAssuredProject;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response; 
import static org.hamcrest.Matchers.*;

public class Tests_GET {

	@Test
	public void test_1() {
		given()
			.header("Content-type" , "application/json")
			.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[1]", equalTo(8))
		.body("data.first_name", hasItems("Rachel" ,  "George"))
		.log()
		.all() ;
		
	}
}
