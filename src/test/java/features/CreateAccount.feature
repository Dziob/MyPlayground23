Feature: Creating a new account
  Scenario: Creating a new account and checking if it has been created
    Given The user is on the Home page of mystore
    When The user clicks on the sign in button
    And From the login page user chooses a create new account option
    And The user filling a registration form and confirms creating an account
    Then The user can confirm the creation of the account by confirming the availability of the logout option
    And The user signs out
    And User close the page