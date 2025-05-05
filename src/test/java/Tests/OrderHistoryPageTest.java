package Tests;

import base.BaseTest;

public class OrderHistoryPageTest extends BaseTest {

  /*
  set up preconditions.
   */
  public void preconditions(String expectedHeaderText) {
    BasketPageTest basketPageTest = new BasketPageTest();
    basketPageTest.userNavigation(expectedHeaderText);
  }

  /*
  As a user # Assumptions made => order created and oderNumber generated,
      New orderNumber displayed on top of the order history.
   */
  public boolean verifyOrderIsPresentInOrderHistory() {
    orderHistoryPage = homePage.navigateToOrderHistoryPage();
    orderHistoryPage.orderHistory("#1", "1.50");
    return true;
  }
}
