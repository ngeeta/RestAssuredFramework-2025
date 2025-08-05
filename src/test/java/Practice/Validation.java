package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import Routes.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Validation {
	static RequestSpecification req;
	static Response res;
	Assertion hardAssert = new Assertion();
	Assertion softAssert = new SoftAssert();
	@Test
	public void getList() {
		req=RestAssured.given().header("x-api-key","reqres-free-v1").baseUri("https://reqres.in").basePath("/api/users?page=2");
		res=req.when().get();
		System.out.println(res.asString());
		Headers headerList=res.getHeaders();
		
		for(Header h:headerList) {
			System.out.println("Key : "+h.getName() +" value :: "+h.getValue());
		}
		
		//Validate HTTP Response ie status,content-type,header
		Assert.assertEquals(res.header("Transfer-Encoding"), "chunked");
		
		//validate json Body
		ResponseBody responseBody=res.getBody();
		String respB=responseBody.asString();
		System.out.println("----------------------ResponseBody-----------------");
		System.out.println(respB);
		System.out.println("----------------------Body res.getBody.asString-----------------");
		System.out.println(res.getBody().asString());
		// george in body with any path
		Assert.assertEquals(res.getBody().asString().contains("George"), true,"Check for presence of george");
		
		// george in body in expected path
		JsonPath j=res.jsonPath();
		String fName=j.get("data[0].first_name");
		Assert.assertEquals(fName, "George","Check for presence of george");
		String em=j.get("data[0].email");
		System.out.println(em);
		

	}
}
