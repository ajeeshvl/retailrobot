Feature: I want to add an item in to the shopping cart
  To add an item in to the shopping cart

  Scenario: add an item in to the cart
  	  Given I am at Home Page
   	  When I "search" an item
   	  And "addtocart"
   	  Then item should be added to the cart