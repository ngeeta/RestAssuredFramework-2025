package Routes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndpointsMethods {

	static RequestSpecification req;
	static Response res;
	
	public Response getListOfUserEndpoint() {
		req=RestAssured.given().header("x-api-key","reqres-free-v1");
		res=req.when().get(Endpoints.getListReq);
		System.out.println(res.asString());
		return res;
	}
}
