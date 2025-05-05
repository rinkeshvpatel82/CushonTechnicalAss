package pages;

import com.microsoft.playwright.Page;

public class HomePage {
  // String Locator - OR
  private final String loginLink_xpath = "a:text('Login')";
  private final String sweetsLink_xpath = "a:text('Sweets')";
  private final String basketLink_xpath = "a:text('basket')";
  private final String pageTitle_css = ".display-3";
  private final String browserSweetBtn_css = ".my-4 a";
  private final Page page;

  // page constructor
  public HomePage(Page page) {
    this.page = page;
  }

  // page actions/methods
  public String getHomePageTitle() {
    String title = page.title();
    System.out.println("Page title: " + title);
    return title;
  }

  public String getHomePageUrl() {
    String url = page.url();
    System.out.println("Page Url: " + url);
    return url;
  }

  public void doSearch(String productName) {
    /* Note :- currently search field is disable.*/
    // page.fill(search, productName);
    page.click(browserSweetBtn_css);
  }

  public String headerText() {
    String header = page.textContent(pageTitle_css);
    System.out.println("browser sweet Page title :- " + header);
    return header;
  }

  public LoginPage navigateToLoginPage() {
    page.click(loginLink_xpath);
    // page channing concept.
    return new LoginPage(page);
  }

  public SweetsPage navigateToSweetPage() {
    page.click(sweetsLink_xpath);
    // page channing concept.
    return new SweetsPage(page);
  }

  public BasketPage navigateToBasketPage() {
    page.click(basketLink_xpath);
    // page channing concept.
    return new BasketPage(page);
  }

  public OrderHistoryPage navigateToOrderHistoryPage() {
    // page channing concept.
    return new OrderHistoryPage(page);
  }
}
