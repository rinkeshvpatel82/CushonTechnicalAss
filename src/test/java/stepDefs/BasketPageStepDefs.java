package stepDefs;

import Tests.BasketPageTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasketPageStepDefs {
    BasketPageTest basketPageTest=new BasketPageTest();
    @Then("the user navigates to the {string} page.")
    public void theUserNavigatesToThePage(String headerText) {
        basketPageTest.verifyTheHeaderText(headerText);
    }

    @When("the user click on checkout button.")
    public void theUserClickOnCheckoutButton() {
        basketPageTest.clickOnCheckOutBtn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the user abe to verify the all error message.")
    public void theUserAbeToVerifyTheAllErrorMessage() {
    }
}
