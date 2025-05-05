package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class OrderHistoryPage {
  private Page page;

  // page constructor
  public OrderHistoryPage(Page page) {
    this.page = page;
  }

  // page actions/methods

  public boolean orderHistory(String orderNumber, String totalPrice) {
    int orderCount = page.locator("tbody > tr > th").count();
    System.out.println("count :- " + orderCount);
    for (int i = 0; i < orderCount; i++) {
      if (page.locator("tbody > tr > th").nth(i).textContent().equals(orderNumber)) {
        String actualTotalPrice = page.locator("tbody > tr > td").nth(2).textContent();
        Assert.assertEquals(actualTotalPrice, totalPrice);
        return true;
      }
    }
    return true;
  }
}
