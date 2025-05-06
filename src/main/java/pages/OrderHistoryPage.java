package pages;

import com.microsoft.playwright.Page;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderHistoryPage {
  private static final Logger logger = Logger.getLogger(OrderHistoryPage.class.getName());
  private final Page page;

  // String Locator - OR
  private final String orderHistoryList_css="tbody > tr > th";
  private final String orderTotalPrice_css="tbody > tr > td";
  // page constructor
  public OrderHistoryPage(Page page) {
    this.page = page;
  }

  // page actions/methods

  public boolean orderHistory(String orderNumber, String totalPrice) {
    try{
    int orderCount = page.locator(orderHistoryList_css).count();
    System.out.println("count :- " + orderCount);
    for (int i = 0; i < orderCount; i++) {
      if (page.locator(orderHistoryList_css).nth(i).textContent().equals(orderNumber)) {
        String actualTotalPrice = page.locator(orderTotalPrice_css).nth(2).textContent();
        Assert.assertEquals(actualTotalPrice, totalPrice);
        return true;
      }
    }
      logger.warning("Order not found: " + orderNumber);
      return false;
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Error occurred while verifying order history", e);
      throw new RuntimeException("Order history verification failed", e);
    }
  }
}
