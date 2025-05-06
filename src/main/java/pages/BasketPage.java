package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BasketPage {
  private static final Logger logger = Logger.getLogger(BasketPage.class.getName());
  private final Page page;

  // String Locator - OR
  private final String pageHeaderText_css = ".display-3";
  private final String checkOutBtn_css = "button:text('Continue to checkout')";
  private final String errorMessage_css = "//div[@class='invalid-feedback']";
  private final String billing_PaymentFields_css = ".form-control";
  private final String cityDropdown_Xpath = "//select[@id='city']";



  // page constructor
  public BasketPage(Page page) {
    this.page = page;
  }

  // page actions/methods
  public String pageHeaderText() {
    try{
      return page.textContent(pageHeaderText_css);
    }catch (Exception e){
      logger.log(Level.SEVERE, "Failed to fetch page header text", e);
      return null;
    }
  }

  public void checkOutBtnClick() {
    try{
    page.click(checkOutBtn_css);
    }catch (Exception e){
      logger.log(Level.SEVERE, "Failed to click on checkout button", e);
      throw new RuntimeException("Checkout button click failed", e);
    }
  }

  public boolean fieldErrorMessage() {
    try{
    int count = page.locator(errorMessage_css).count();
    System.out.println("total error message count :-" + count);
    for (int i = 1; i < count; i++) {
      System.out.println(i + "Element is visible");
      page.locator(errorMessage_css).nth(i).isVisible();
      System.out.println(page.locator(errorMessage_css).nth(i).allTextContents());
    }
    return true;
    }catch (Exception e){
      logger.log(Level.SEVERE, "Error while fetching field error messages", e);
      return false;
    }
  }

  public void billingFieldsEnterText(
      String fName, String lName, String email, String address, String zip) {
    try{
    page.locator(billing_PaymentFields_css).nth(1).fill(fName);
    page.locator(billing_PaymentFields_css).nth(2).fill(lName);
    page.locator(billing_PaymentFields_css).nth(3).fill(email);
    page.locator(billing_PaymentFields_css).nth(4).fill(address);
    page.selectOption("select", new SelectOption().setIndex(1));
    page.selectOption(cityDropdown_Xpath, new SelectOption().setIndex(2));
    page.locator(billing_PaymentFields_css).nth(6).fill(zip);
    } catch (Exception e){
      logger.log(Level.SEVERE, "Failed to enter billing fields", e);
      throw new RuntimeException("Billing fields entry failed", e);
    }
  }

  public void paymentFieldsEnterText(String cardName, String cardNumber, String exp, String cvv) {
    try{
    page.locator(billing_PaymentFields_css).nth(7).fill(cardName);
    page.locator(billing_PaymentFields_css).nth(8).fill(cardNumber);
    page.locator(billing_PaymentFields_css).nth(9).fill(exp);
    page.locator(billing_PaymentFields_css).nth(10).fill(cvv);
    }catch (Exception e){
      logger.log(Level.SEVERE, "Failed to enter payment fields", e);
      throw new RuntimeException("Payment fields entry failed", e);
    }
  }
}
