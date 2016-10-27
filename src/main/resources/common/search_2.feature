Feature: I want to search 
  To search an item in a retail website

  Scenario: search an item
  	  Given I am at Home Page
  	  When I "click" on "btn_toggle"
  	  And  "type" in "txt_search" as "$searchkeyword"
  	  Then Search Results Page should be loaded