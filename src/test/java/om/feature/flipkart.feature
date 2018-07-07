@flipkart
Feature: Flipkart 

Scenario Outline: phone 

	Given The user is in flipkart page 
	And User searh for the product "<phone>" 
	When The user adds the item "<itemIndex>" to the cart
	And the user adds the item to the cart  
	Then The user verifies the item "<phone>" in the cart 
	
	Examples: 
		|phone|itemIndex|
		|iPhone X|2|
		|OnePlus 6|10|
		|Redmi Note 5|5|
