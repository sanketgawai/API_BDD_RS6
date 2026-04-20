package stepDefination;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.DeletePlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace getAddPlacePayload(String name, String language, String address)
	{
		 AddPlace a = new AddPlace();
	        Location l = new Location();

	        l.setLat(-38.383494);
	        l.setLng(33.427362);

	        a.setLocation(l);
	        a.setAccuracy(50);
	        a.setName(name);
	        a.setPhone_number("(+91) 983 893 3937");
	        a.setAddress(address);

	        List<String> t = new ArrayList<>();
	        t.add("shoe park");
	        t.add("shop");

	        a.setTypes(t);
	        a.setWebsite("http://google.com");
	        a.setLanguage(language);
	        
	        return a;
	}
	
//	public String getDelete(String placeId)
//	{
//		DeletePlace d = new DeletePlace();
//		d.setPlace_id(placeId);
//		return placeId;
//	}
	
	public String getDelete(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
}
