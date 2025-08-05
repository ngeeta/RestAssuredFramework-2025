package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Routes.EndpointsMethods;
import io.restassured.response.Response;

public class ReqResTC {
	Response res;
	EndpointsMethods ep=new EndpointsMethods();
	@Test
	public void getListOfUserEndpointTC() {
		res=ep.getListOfUserEndpoint();
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("Status code is "+res.getStatusCode());
	}
}
