package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeDeletePlace() throws IOException
	{
		
		StepDefination2 d = new StepDefination2();
		System.out.println("in hooks-placeId : "+d.placeId);
		if(d.placeId==null) {
			d.user_add_add_place_api_payload_with("itachi","japanese","akatski");
			d.user_call_with_http_method("AddPlaceAPI","post");
			d.verify_user_get_place_id();
		}
	}
	
}
