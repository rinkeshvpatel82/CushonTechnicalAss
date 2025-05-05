package stepDefs;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import Tests.LoginPageTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefs {
  LoginPageTest loginPageTest = new LoginPageTest();

  @And("the user click on login button.")
  public void the_user_click_on_login_button() {
    loginPageTest.clickOnLoginBtn();
  }

  @Then("the user navigates to the {string} page successfully.")
  public void the_user_navigates_to_the_page_successfully(String headerText) {
    loginPageTest.userNavigateToAccountPage(headerText);
  }

  @When("the user click on login link.")
  public void theUserClickOnLoginLink() {
    loginPageTest.clickOnLoginLink();
  }

  @And("the user enter the credential, click on login button.")
  public void theUserEnterTheCredentialClickOnLoginButton() {
    loginPageTest.loginSuccessfully();
  }

  @Then("the user should be able to see the error successfully.")
  public void the_user_should_be_able_to_see_the_error_successfully() {
    assertThat(loginPageTest.verifyTheEmptyFieldError(), is(true));
  }
}
