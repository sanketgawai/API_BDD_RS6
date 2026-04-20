//package stepDefination;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import pojo.AddPlace;
//import pojo.Location;
//import resources.Utils;
//
//import static io.restassured.RestAssured.*;
//import static org.junit.Assert.*;
//
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
//public class StepDefination extends Utils {
//
//
//	RequestSpecification req;
//	RequestSpecification res;
//	Response response;
//	
//	@Given("User add AddPlaceAPI payload")
//	public void user_add_add_place_api_payload() throws FileNotFoundException {
//		
//		AddPlace a = new AddPlace();
//		Location l = new Location();	
//		l.setLat(-38.383494);
//		//l.setLng(33.427362);
//		l.setLag(33.427362);
//		a.setLocation(l);
//		a.setAccuracy(50);
//		a.setName("Frontline house");
//		a.setPhone_number("(+91) 983 893 3937");
//		a.setAddress("29, side layout, cohen 09");
//		List<String> t = new ArrayList<>();
//		t.add("shoe park");
//		t.add("shop");
//		a.setTypes(t);
//		a.setWebsite("http://google.com");
//		a.setLanguage("French-IN");
//		
//		res = given().spec(requestSpecification()).body(a);
//	}
//	
//	@When("User call AddPlaceAPI with http post method")
//	public void user_call_add_place_api_with_http_post_method() {
//		
//		response = res.given().post("/maps/api/place/add/json").then().extract().response();
//		System.out.println(response.asPrettyString());
//	}
//	
//	@Then("{string} in response is equal to {string}")
//	public void in_response_is_equal_to(String key, String value) {
//		JsonPath js = new JsonPath(response.asString());
//		assertEquals(js.get(key), value);
//	}
//	
//	@Then("Response schema is validated")
//	public void response_schema_is_validated() {
//		System.out.println(getClass().getClassLoader().getResource("schema/addPlaceSchema.json"));//to print the path
//		 response.then()
//         .assertThat()
//         .body(matchesJsonSchemaInClasspath("schema/addPlaceSchema.json"));
//         
//	}
//
//
//
//
//
//	
//}
