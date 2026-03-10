package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Util {

	static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(getGlobalProperties("base_url")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))    // logs request
                .addFilter(ResponseLoggingFilter.logResponseTo(log))  // logs response
				.setContentType(ContentType.JSON).build();
		
		return req;
		}
		return req;
	}
	
	
	public String getGlobalProperties(String key) throws IOException
	{
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\global.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response response, String key)
	{
		JsonPath js = new JsonPath(response.asString());
		return js.get(key);
	}
	
	
}
