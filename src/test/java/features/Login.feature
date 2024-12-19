@RegressionSuite
Feature: Login page validation

  Background:
    Given user navigate to Swag Labs website

  Scenario: Verify login with empty credentials
    When user clicks the Login
    Then verify error message "username is required" is displayed
    When user reloads page
    And user enter "standard_user" username
    And user clicks the Login
    Then verify error message "password is required" is displayed
    When user reloads page
    And user enter "secret_sauce" password
    And user clicks the Login
    Then verify error message "username is required" is displayed
    And close browser

  Scenario: Verify invalid login credentials
    When user enter "standard_user" username
    And user enter "xxsecret_sauce" password
    And user clicks the Login
    Then verify error message "credentials does not match" is displayed
    When user reloads page
    And user enter "xxstandard_user" username
    And user enter "secret_sauce" password
    And user clicks the Login
    Then verify error message "credentials does not match" is displayed
    When user reloads page
    And user enter "123qwer" username
    And user enter "123qwer" password
    And user clicks the Login
    Then verify error message "credentials does not match" is displayed
    And close browser

  Scenario: Verify Standard User
    When user enter "standard_user" username
    And user enter "secret_sauce" password
    And user clicks the Login
    Then verify that "inventory" page is displayed
    When user clicks the main menu
    And user logout
    Then verify login page
    And close browser

  Scenario: Verify Locked Out User
    When user enter "locked_out_user" username
    And user enter "secret_sauce" password
    And user clicks the Login
    Then verify error message "locked out user" is displayed
    And close browser