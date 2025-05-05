Feature: As a user I am able to checkout the product on sweetshop web application.

  Background:
    Given the user is on the sweetshop home page.
    And the user verify the basket is empty.
    And the user select the products by clicking on add to cart button from product list.
      | Chocolate Cups |
      | Sherbert Straws   |
    And the user click on basket icon.
    And the user navigates to the "Your Basket" page.

  @Test5
  Scenario: The user can't checkout without providing mandatory information.
    When the user click on checkout button.
    Then the user abe to verify the all error message.