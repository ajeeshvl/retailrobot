Feature: I want to login to the system
  To verify the user logged in successfully

  Scenario: login as valid user
    Given "verify" I am on "HomePage"
    When I "click" on "lnk_login"
      And I "fill" in "txt_username" with "testuser" 
      And I "fill" in "txt_password" with "password"
    Then I should "verify" "LoggedPage"
      And I should "verify" "btn_logout"