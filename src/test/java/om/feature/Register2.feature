@f2 @feature2 @register2 @r2
Feature: Demoqa registration2 
@launch @demoqa 
Scenario: Launch 
	Given User is in demoqa page 

@text @textbox	
Scenario: Textbox 
	When  User enters the first name, last name, etc 
		|Raj|Kamal|9888898888|rajkml|rajkml@outlook.com|About your self|raj55555|raj55555| 
	Then  User verifies the first name, last name, etc 
@radio @radiobutton 
Scenario: Radio 
	When  User selects marital status 
	Then  User verifies the selected marital status 
@checkbox 
Scenario: C
	When  User selects hobby 
	Then  User verifies the selected hobby 
@drop @dropdown	
Scenario: Drop 
	When  User selects country and dob 
	Then  User verifies the selected country and dob 
	
	