

package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.Utils;

import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class StepDefination2 extends Utils {

    RequestSpecification req;
    RequestSpecification res;
    Response response;
    static String placeId;
    TestDataBuild data = new TestDataBuild();
    SoftAssert softAssert = new SoftAssert();

    @Given("User add AddPlaceAPI payload with {string} {string} {string}")
    public void user_add_add_place_api_payload_with(String name, String language, String address) throws IOException {

    	//TestDataBuild data = new TestDataBuild();
        res = given().spec(requestSpecification()).body(data.getAddPlacePayload(name, language, address));
    }

    @When("User call {string} with http {string} method")
    public void user_call_with_http_method(String resource, String method) {
        
    	//response = res.when().post("/maps/api/place/add/json").then().extract().response();
        
        APIResources apiResources = APIResources.valueOf(resource); 
        
        if(method.equalsIgnoreCase("post"))
        {
        	response = res.when().post(apiResources.getResource()).then().extract().response();
        }
        else if(method.equalsIgnoreCase("get"))
        {
        	response = res.when().get(apiResources.getResource()).then().extract().response();
        }
        else if(method.equalsIgnoreCase("delete"))
        {
        	response = res.when().delete(apiResources.getResource()).then().extract().response();
        }
        
        System.out.println(response.asPrettyString());
    }




    @Then("{string} in response is equal to {string}")
    public void in_response_is_equal_to(String key, String value) {

        if (response == null || response.asString().isEmpty()) {
            softAssert.fail("Response is NULL or EMPTY");
            return;
        }
        softAssert.assertEquals(getJsonPath(response,key),value);
    }

    @Then("Response schema is validated")
    public void response_schema_is_validated() {

        // REAL schema validation (no SoftAssert wrapping)
        response.then().assertThat().body(matchesJsonSchemaInClasspath("schema/addPlaceSchema.json"));
    }

    @Then("verify user get placeId")
    public void verify_user_get_place_id() {
       
    	placeId = getJsonPath(response,"place_id");
    	System.out.println("placeId : "+placeId);
    }

    @Then("PlaceId map with the {string} with user call {string} with http {string} method")
    public void place_id_map_with_the_with_user_call_with_http_method(String expectedName, String resource, String method) throws IOException {
        
    	res=given().spec(requestSpecification()).queryParam("place_id",placeId);
    	user_call_with_http_method(resource,method);
    	softAssert.assertEquals(getJsonPath(response,"name"),expectedName);
    }

    @Given("User add DeletePlaceAPI payload")
    public void user_add_delete_place_api_payload() throws IOException {
    	
    	 res = given().spec(requestSpecification()).body(data.getDelete(placeId));
    			 
    }







    
    
}