Feature: As a user I am able to login to sweetshop web application.

  Background:
    Given the user is on the sweetshop login page.

  @Test1
  Scenario: The user login to the sweetshop web application successfully. - Happy Path
    When the user enter valid username.
    And the user enter valid password.
    And the user click on login button.
    Then the user navigates to the "Products" page successfully.