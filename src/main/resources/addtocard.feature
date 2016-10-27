Feature: I want to add an item in to the shopping cart
  To add an item in to the shopping cart

  Scenario: add an item in to the cart
  	   Given I am at Home Page
   	   Then "type" in "txt_search" as "$searchkeyword"
   	   And "click" on "btn_search" 
   	   And "click" on the "$searchkeyword"
	   And "click" on "btn_addcart"
   	   Then item should be added to the cart