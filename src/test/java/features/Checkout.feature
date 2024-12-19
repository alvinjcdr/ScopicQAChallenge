@RegressionSuite
Feature: Checkout Product

  Background:
    Given user navigate to Swag Labs website

  Scenario: Verify Successful Product Checkout
    When user enter "standard_user" username
    And user enter "secret_sauce" password
    And user clicks the Login
    Then verify that "inventory" page is displayed
    And verify product name sorting
    When add to cart first '2' items
    Then verify '2' is found in shopping cart badge
    When user click shopping cart
    Then verify that "cart" page is displayed
    When user click Checkout button
    Then verify that "checkout-step-one" page is displayed
    When user fills up details with "fName", "lName", and "1234" and continue
    Then verify that "checkout-step-two" page is displayed
    When user click Finish button
    Then verify that "checkout-complete" page is displayed
    And verify that checkout success message is displayed

