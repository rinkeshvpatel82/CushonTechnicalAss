package stepDefs;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import Tests.BasketPageTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasketPageStepDefs {
  BasketPageTest basketPageTest = new BasketPageTest();

  @Then("the user click on basket icon,navigates to the {string} page.")
  public void theUserClickOnBasketIconNavigatesToThePage(String headerText) {
    basketPageTest.verifyTheHeaderText(headerText);
  }

  @When("the user click on checkout button.")
  public void theUserClickOnCheckoutButton() {
    basketPageTest.clickOnCheckOutBtn();
  }

  @Then("the user abe to verify the visibility of all error message.")
  public void theUserAbeToVerifyTheVisibilityOfAllErrorMessage() {
    assertThat(basketPageTest.verifyTheErrorMessage(), is(true));
  }

  @When("the user enter the value in mandatory fields.")
  public void theUserEnterTheValueInMandatoryFields() {
    basketPageTest.enterTheBillingAndPaymentInfo();
  }

  @Then("the user navigates to the {string} successfully.")
  public void theUserNavigatesToTheSuccessfully(String expectedHeaderText) {
    basketPageTest.userNavigation(expectedHeaderText);
  }
}
