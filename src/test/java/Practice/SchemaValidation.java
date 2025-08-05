package Practice;

import java.io.File;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import Routes.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SchemaValidation {
	static RequestSpecification req;
	static Response res;
	
	@Test
	public void getList() {
		String path=System.getProperty("user.dir")+"//Schema//one.json";
		req=RestAssured.given().header("x-api-key","reqres-free-v1").baseUri("https://reqres.in").basePath("/api/users?page=2");
		res=req.when().get();
		System.out.println(res.asString());
		res.then()
		.body("total", Matchers.notNullValue())
		.body(JsonSchemaValidator.matchesJsonSchema(new File(path)));
		

	}
}
