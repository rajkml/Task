@f1 @register1 @feature1 
Feature: Demoqa registration

Scenario: Reistration
Given User is in the demoqa page
When  User enters the first name and last name
Then  User verifies the first name and last name

Scenario: Drop 
When  User selects country as India 
Then  User verifies the selected country
