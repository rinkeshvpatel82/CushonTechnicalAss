package pages;

import com.microsoft.playwright.Page;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginPage {
  private static final Logger logger = Logger.getLogger(LoginPage.class.getName());
  private final Page page;

  // String Locator - OR
  private final String emailId = "//input[@id='exampleInputEmail']";
  private final String emailFieldError = ".invalid-feedback.invalid-email";
  private final String password = "//input[@id='exampleInputPassword']";
  private final String passwordFieldError = ".invalid-feedback.invalid-password";
  private final String loginBtnLink = "a:text('Login')";
  private final String loginBtn = "[type='submit']";
  private final String headerText = ".display-3";

  // page constructor
  public LoginPage(Page page) {
    this.page = page;
  }
  // page Action
  public String getPageHeaderText() {
    try{
    return page.textContent(headerText);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to fetch page header text", e);
      return null;
    }
  }

  public void loginLinkClick() {
    try{
    page.click(loginBtnLink);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to click on login link", e);
      throw new RuntimeException("Login link click failed", e);
    }
  }

  public void loginButtonClick() {
    try{
    page.click(loginBtn);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to click on login button", e);
      throw new RuntimeException("Login button click failed", e);
    }
  }

  public String emailFieldError() {
    try{
    return page.textContent(emailFieldError).trim();
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to fetch email field error", e);
      return null;
    }
  }

  public String passwordFieldError() {
    try{
    return page.textContent(passwordFieldError);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to fetch password field error", e);
      return null;
    }
  }

  public void enterTheCredentials(String appUserName, String appUserPassword) {
    try{
    System.out.println("App creds: " + appUserName + ":" + appUserPassword);
    page.fill(emailId, appUserName);
    page.fill(password, appUserPassword);
    page.click(loginBtn);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to enter credentials or click login button", e);
      throw new RuntimeException("Login operation failed", e);
    }
  }
}
