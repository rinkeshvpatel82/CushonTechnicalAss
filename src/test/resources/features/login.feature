Feature: As a user I am able to login to sweetshop web application.

  Background:
    Given the user is on the sweetshop home page.

  @Test2
  Scenario: The user login to the sweetshop web application successfully. - Happy Path
    # Assumptions made => user registration done.
    When the user click on login link.
    And the user enter the credential, click on login button.
    Then the user navigates to the "Your Account" page successfully.

  @Test3
  Scenario: The user can't login with blank userName and password. - UnHappy Path
    # Assumptions made => user registration done.
    When the user click on login link.
    And the user click on login button.
    Then the user should be able to see the error successfully.

