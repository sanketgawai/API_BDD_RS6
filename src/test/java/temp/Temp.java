package temp;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.javac.util.List;

import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;


public class Temp {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		
		//*****need jackson-databind dependency
		
		String course = "{\r\n"
				+ "    \"instructor\": \"RahulShetty\",\r\n"
				+ "    \"url\": \"rahulshettycademy.com\",\r\n"
				+ "    \"services\": \"projectSupport\",\r\n"
				+ "    \"expertise\": \"Automation\",\r\n"
				+ "    \"courses\": {\r\n"
				+ "        \"webAutomation\": [\r\n"
				+ "            {\r\n"
				+ "                \"courseTitle\": \"Selenium Webdriver Java\",\r\n"
				+ "                \"price\": \"50\"\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"courseTitle\": \"Cypress\",\r\n"
				+ "                \"price\": \"40\"\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"courseTitle\": \"Protractor\",\r\n"
				+ "                \"price\": \"40\"\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"api\": [\r\n"
				+ "            {\r\n"
				+ "                \"courseTitle\": \"Rest Assured Automation using Java\",\r\n"
				+ "                \"price\": \"50\"\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"courseTitle\": \"SoapUI Webservices testing\",\r\n"
				+ "                \"price\": \"40\"\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"mobile\": [\r\n"
				+ "            {\r\n"
				+ "                \"courseTitle\": \"Appium-Mobile Automation using Java\",\r\n"
				+ "                \"price\": \"50\"\r\n"
				+ "            }\r\n"
				+ "        ]\r\n"
				+ "    },\r\n"
				+ "    \"linkedIn\": \"https://www.linkedin.com/in/rahul-shetty-trainer/\"\r\n"
				+ "}";
		
				
		  ObjectMapper mapper = new ObjectMapper();//import from(com.fasterxml.jackson.databind)
	      JsonNode root = mapper.readTree(course);//import from(com.fasterxml.jackson.databind)
	      
	      //get the direct data in {}
	      System.out.println("=======print direct data in {}======");
	      System.out.println("Instructor: " + root.get("instructor").asText());  
		  JsonNode instructorr = root.get("instructor");
		  String instructor = root.get("instructor").asText();
		  System.out.println("Instructor : "+instructor);
		  
		  System.out.println("=======print courses======");
		  // Go to "courses" node
	        JsonNode coursesNode = root.path("courses");

	        // Iterate keys: webAutomation, api, mobile
	        Iterator<String> fieldNames = coursesNode.fieldNames();

	        while (fieldNames.hasNext()) {
	            String courseCategory = fieldNames.next();
	            System.out.println(courseCategory);
	        }
		  
	        System.out.println("=======print courses inside api======");
	        
	     // Go to courses -> api
	        JsonNode apiCourses = root.path("courses").path("api");

	        // loop through array
	        for (JsonNode apicourses : apiCourses) {
	            String title = apicourses.get("courseTitle").asText();
	            String price = apicourses.get("price").asText();

	            System.out.println("Course Title: " + title);
	            System.out.println("Price: " + price);
	            System.out.println("-------------------");
	        }
		
	        System.out.println("======= FIND CYPRESS PRICE IN WEBAUTOMATION=======");

	     // Go to courses -> webAutomation
	     JsonNode webCourses = root.path("courses").path("webAutomation");

	     // loop through array
	     for (JsonNode webcourses : webCourses) {
	         String title = webcourses.get("courseTitle").asText();

	         if (title.equalsIgnoreCase("Cypress")) {
	             String price = webcourses.get("price").asText();
	             System.out.println("Cypress Price: " + price);
	             break; // stop once found
	         }
	     }
	     
	     
	        
	}
}
