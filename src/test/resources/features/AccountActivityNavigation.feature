
Feature: Navigating to specific accounts in Accounts Activity

  Scenario Outline: Savings account redirect
    Given the user is logged in
    And clicks on "Online Banking" link
    And clicks on "Account Summary" link
    When clicks on "<links>" link
    Then the Account Activity page should be displayed
    And Account drop down should have "<links>" selected
    Examples:
      | links       |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |

