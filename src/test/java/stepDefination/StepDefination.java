package stepDefination;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Util;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class StepDefination extends Util {
	
	RequestSpecification req;
	RequestSpecification res;
	Response response;
	static String placeId;
	TestDataBuild data = new TestDataBuild();
	

	@Given("AddPlace add payload with {string} {string} {string}")
	public void add_place_add_payload_with(String name, String language, String address) throws IOException {
		
		res = given().spec(requestSpecification()).body(data.getAddPlaceAPIPayload(name,language,address));
	}
	
	@When("User call the {string} using http {string} method")
	public void user_call_the_using_http_method(String resource, String method) {
		
		APIResources apiResource = APIResources.valueOf(resource);
		if(method.equalsIgnoreCase("post")) {
			response = res.when().post(apiResource.resource())
					.then().extract().response();
		}else if(method.equalsIgnoreCase("get")) {
			response = res.when().get(apiResource.resource())
					.then().extract().response();
		}else if(method.equalsIgnoreCase("delete")) {
			response = res.when().delete(apiResource.resource())
					.then().extract().response();
		}
	}

	@Then("Verify get success with status code {string}")
	public void verify_get_success_with_status_code(String statusCode) {
		int updatedStatusCode = Integer.parseInt(statusCode);
		assertEquals(response.getStatusCode(),updatedStatusCode);
	}
	
	@Then("{string} In Response body equal to {string}")
	public void in_response_body_equal_to(String key, String value) {
	    
		JsonPath js = new JsonPath(response.asString());
		assertEquals(js.get(key),value);
		
	}
	
	@Then("Verify In Response body get placeId")
	public void verify_in_response_body_get_place_id() {
	    
		placeId = getJsonPath(response,"place_id");
	}
	
	@Then("verify place_Id created maps to {string} using {string} using {string} method")
	public void verify_place_id_created_maps_to_using_using_method(String expectedName, String resources, String method) throws IOException {
	    
		res = given().spec(requestSpecification()).queryParam("place_id", placeId);
		user_call_the_using_http_method(resources,method);
		assertEquals(getJsonPath(response,"name"),expectedName);
	}

	
	@Given("DeletePlace add Payload")
	public void delete_place_add_payload() throws IOException {
		
		res = given().spec(requestSpecification()).body(data.getDeletePlacePayload(placeId));
		
	}





}
