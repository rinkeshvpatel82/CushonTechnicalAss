package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
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
    return page.textContent(headerText);
  }

  public void loginLinkClick() {
    page.click(loginBtnLink);
  }

  public void loginButtonClick() {
    page.click(loginBtn);
  }

  public String emailFieldError() {
    return page.textContent(emailFieldError).trim();
  }

  public String passwordFieldError() {
    return page.textContent(passwordFieldError);
  }

  public void enterTheCredentials(String appUserName, String appUserPassword) {
    System.out.println("App creds: " + appUserName + ":" + appUserPassword);
    page.fill(emailId, appUserName);
    page.fill(password, appUserPassword);
    page.click(loginBtn);
  }
}
