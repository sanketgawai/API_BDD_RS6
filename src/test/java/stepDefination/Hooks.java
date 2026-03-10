package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void createPlaceidIfNotExist() throws IOException
	{
		StepDefination d = new StepDefination();
		if(StepDefination.placeId==null) {
		d.add_place_add_payload_with("luffy", "janpanese", "one piece");
		d.user_call_the_using_http_method("AddPlaceAPI", "post");
		d.verify_in_response_body_get_place_id();
		}
	}
}
