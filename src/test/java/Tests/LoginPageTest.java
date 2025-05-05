package Tests;

import Constants.AppConstants;
import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginPageTest extends BaseTest {

  private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);

  public void clickOnLoginLink() {
    loginPage = homePage.navigateToLoginPage();
    loginPage.loginLinkClick();
  }

  public void clickOnLoginBtn() {
    loginPage.loginButtonClick();
  }

  public void loginSuccessfully() {
    loginPage.enterTheCredentials(
        prop.getProperty("emailAddress").trim(), prop.getProperty("password").trim());
  }

  public boolean userNavigateToAccountPage(String expectedHeaderText) {
    String actualHeaderText = loginPage.getPageHeaderText();
    Assert.assertEquals(actualHeaderText, expectedHeaderText);
    System.out.println("user is logged in successfully....!");
    return true;
  }

  public boolean verifyTheEmptyFieldError() {
    String actualEmailError = loginPage.emailFieldError();
    Assert.assertEquals(actualEmailError, AppConstants.EMAIL_ERROR_TEXT);
    String actualPasswordError = loginPage.passwordFieldError().trim();
    Assert.assertEquals(actualPasswordError, AppConstants.PASSWORD_ERROR_TEXT);
    return true;
  }
}
