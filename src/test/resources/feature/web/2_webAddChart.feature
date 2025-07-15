Feature: Test Automation Web AddCart

  Background:
    Given open web login page
    And input valid username "standard_user" and password "secret_sauce"
    When click button login
    Then user will direct to homepage

  @addChart
  Scenario: Add Item To Cart
    Given user is on homepage
    When user clicks "Add to cart" button for Item
    Then the button should change to "Remove"
    And cart count should increase by 1