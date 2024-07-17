Feature: GitHub Login
 
  Scenario: Login with invalid credentials
    Given User is on the GitHub login page
    When User enters invalid username "invalid_username" and invalid password "invalid_password"
    And User clicks on the login button
    Then Error message "Incorrect username or password" should be displayed
 
      
  Scenario: Login with valid credentials
    Given User is on the GitHub login page
    When User enters valid username "valid_user" and password "valid_password"
    And User clicks on the login button
    Then User should be logged in successfully