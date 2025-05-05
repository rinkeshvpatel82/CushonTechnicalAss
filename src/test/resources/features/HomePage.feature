@HomePage
Feature: As a user I am able to search the product on sweetshop web application.

  Background:
    Given the user is on the sweetshop home page.

  @Test1
  Scenario: The user is on home page.
    When user search the product with "Chocolate Cups", click on Browser Sweets.
    Then user able to navigate the "Browse sweets" page, and see the "Chocolate Cups" sweet.