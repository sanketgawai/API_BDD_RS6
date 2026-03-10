Feature: Validate the PlaceAPI

@AddPlace
Scenario: Validate the AddPlaceAPI

	Given AddPlace add payload with "<name>" "<language>" "<address>"
	When User call the "AddPlaceAPI" using http "post" method
	Then Verify get success with status code '200'
	And "status" In Response body equal to "OK"
	And "scope" In Response body equal to "APP"
	And Verify In Response body get placeId
	And verify place_Id created maps to "<name>" using "GetPlaceAPI" using "get" method
	
Examples:
	|name	  |language	 |address			   |	
	| AAhouse | English  | World cross center  |
	| BBhouse | Spanish  | Sea cross center    |

@DeletePlace	
Scenario: Verify Delete functionality is working

	Given DeletePlace add Payload
	When User call the "DeletePlaceAPI" using http "delete" method
	Then Verify get success with status code '200'
	And "status" In Response body equal to "OK"
	