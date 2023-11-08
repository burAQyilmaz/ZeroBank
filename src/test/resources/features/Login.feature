
Feature: Login functionality

  Scenario: User should be able to log in with valid credentials
    Given user is on the login page
    When user types valid credentials
    And user clicks sign in buttons
    Then user should be logged in

  Scenario Outline: negative scenarios with invalid credentials
    Given user is on the login page
    When user types the "<userName>" as username and "<password>" as password
    And user clicks sign in buttons
    Then user sees error message "Login and/or password are wrong."

    Examples:
      | userName      | password      |
      |               | password      |
      | username      |               |
      |               |               |
      | usernameWrong | passwordWrong |
      | usernameWrong |               |
      |               | passwordWrong |