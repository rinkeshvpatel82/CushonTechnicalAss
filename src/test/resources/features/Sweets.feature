@Sweets
Feature: As a user I am able to add the product to basket on sweetshop web application.

  Background:
    Given the user is on the sweetshop home page.
    And the user verify the basket is empty.

  @Test4
  Scenario: The user successfully add the product to cart.
    When the user select the products by clicking on add to cart button from product list.
      | Chocolate Cups  |
      | Sherbert Straws |
    Then the user click on basket icon,navigates to the "Your Basket" page.