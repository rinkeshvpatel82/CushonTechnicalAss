@OrderHistoryPage
Feature: As a user I am able to checkout the product on sweetshop web application.

  Background:
    Given the user is on the sweetshop home page.
# Assumptions made => user added few product to cart and process the payment,
# Order number generated and visible on order history page .
    And the user navigated to "Your Account" page.

  @Test7
  Scenario: Order displayed on order history page.
    Then the user able to verify the order in order history.
