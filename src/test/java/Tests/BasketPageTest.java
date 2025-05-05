package Tests;

import base.BaseTest;
import org.testng.Assert;

public class BasketPageTest extends BaseTest {

  public boolean verifyTheHeaderText(String headerText) {
    basketPage = homePage.navigateToBasketPage();
    String actualHeaderText = basketPage.pageHeaderText();
    System.out.println("Actual Your basket header Text :-" + actualHeaderText);
    Assert.assertEquals(actualHeaderText, headerText);
    return true;
  }

  public void clickOnCheckOutBtn() {
    basketPage.checkOutBtnClick();
  }

  public boolean verifyTheErrorMessage() {
    return basketPage.fieldErrorMessage();
  }

  public void enterTheBillingAndPaymentInfo() {
    basketPage.billingFieldsEnterText(
        prop.getProperty("firstName"),
        prop.getProperty("lastName"),
        prop.getProperty("emailAddress"),
        prop.getProperty("Address"),
        prop.getProperty("postCode"));

    basketPage.paymentFieldsEnterText(
        prop.getProperty("nameOnCard"),
        prop.getProperty("cardNumber"),
        prop.getProperty("expiration"),
        prop.getProperty("cvv"));

    basketPage.checkOutBtnClick();
  }

  /* currently, after clicking on checkout button user is not able to
  navigates to "Your Account" page. So, I have to write the blow method for per condition. */
  public void userNavigation(String expectedHeaderText) {
    LoginPageTest loginPageTest = new LoginPageTest();
    loginPageTest.clickOnLoginLink();
    loginPageTest.loginSuccessfully();
    loginPageTest.userNavigateToAccountPage(expectedHeaderText);
  }
}
