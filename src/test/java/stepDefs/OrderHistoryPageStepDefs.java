package stepDefs;

import Tests.OrderHistoryPageTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OrderHistoryPageStepDefs {
  OrderHistoryPageTest orderHistoryPageTest = new OrderHistoryPageTest();

  @And("the user navigated to {string} page.")
  public void theUserNavigatedToPage(String expectedHeaderText) {
    orderHistoryPageTest.preconditions(expectedHeaderText);
  }

  @Then("the user able to verify the order in order history.")
  public void theUserAbleToVerifyTheOrderInOrderHistory() {
    orderHistoryPageTest.verifyOrderIsPresentInOrderHistory();
  }
}
