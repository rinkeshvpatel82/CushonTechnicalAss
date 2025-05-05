# Below test written as a assumptions application feature working as expected, and there are no bug.

#@E2E
Feature: As a user I am able to search the product and buy that product on sweetshop web application.

  Background:
    Given the user is on the sweetshop home page.
    And the user verify the basket is empty.

  #@E2ETest1
  Scenario: The user buy the product successfully.
    When the user select the products by clicking on add to cart button from product list.
      | Chocolate Cups  |
      | Sherbert Straws |
    Then the user click on basket icon,navigates to the "Your Basket" page.
    When the user enter the value in mandatory fields.
    And the user click on checkout button.
    And the user navigates to the "Your Account" successfully.
    Then the user able to verify the order in order history.