@BasketPage
Feature: As a user I am able to checkout the product on sweetshop web application.

  Background:
    Given the user is on the sweetshop home page.
    And the user verify the basket is empty.
    And the user select the products by clicking on add to cart button from product list.
      | Chocolate Cups  |
      | Sherbert Straws |
    Then the user click on basket icon,navigates to the "Your Basket" page.

  @Test5
  Scenario: The user can't checkout without providing mandatory information.
    When the user click on checkout button.
    Then the user abe to verify the visibility of all error message.

  @Test6
  Scenario: The user checkout successfully.
    When the user enter the value in mandatory fields.
    And the user click on checkout button.
    Then the user navigates to the "Your Account" successfully.