Feature: Verify AddPlaceAPI

@AddPlace
Scenario: Verify AddPlaceAPI work successfully
Given User add AddPlaceAPI payload with "<name>" "<language>" "<address>"
When User call "AddPlaceAPI" with http "post" method
Then 'status' in response is equal to 'OK'
Then 'scope' in response is equal to 'APP'
And verify user get placeId
Then Response schema is validated
And PlaceId map with the "<name>" with user call "GetPlaceAPI" with http "get" method

Examples:
	|name		|language			|address			|
	|luffy		|japanese			|east blue			|
	|batman		|english			|gothom				|
	
@DeletePlace	
Scenario: Verify DeletePlaceApi is work
Given User add DeletePlaceAPI payload 
When User call "DeletePlaceAPI" with http "delete" method
Then 'status' in response is equal to 'OK'