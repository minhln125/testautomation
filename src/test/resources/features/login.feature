Feature: Test login

  Scenario: test login function with valid credential
    Given on login page
    When Enter user name and password
    And press login page
    Then Navigate to homepage
