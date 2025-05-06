package pages;

import com.microsoft.playwright.Page;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePage {
  private static final Logger logger = Logger.getLogger(HomePage.class.getName());
  private final Page page;
  // String Locator - OR
  private final String loginLink_xpath = "a:text('Login')";
  private final String sweetsLink_xpath = "a:text('Sweets')";
  private final String basketLink_xpath = "a:text('basket')";
  private final String pageTitle_css = ".display-3";
  private final String browserSweetBtn_css = ".my-4 a";


  // page constructor
  public HomePage(Page page) {
    this.page = page;
  }

  // page actions/methods
  public String getHomePageTitle() {
    try{
      String title = page.title();
      System.out.println("Page title: " + title);
      return title;
    }catch (Exception e){
      logger.log(Level.SEVERE, "Failed to fetch home page title", e);
      return null;
    }
  }

  public String getHomePageUrl() {
    try{
    String url = page.url();
    System.out.println("Page Url: " + url);
    return url;
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to fetch home page URL", e);
      return null;
    }
  }

  public void doSearch(String productName) {
    try{
    /* Note :- currently search field is disable.*/
    // page.fill(search, productName);
    page.click(browserSweetBtn_css);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to perform search operation", e);
      throw new RuntimeException("Search operation failed", e);
    }
  }

  public String headerText() {
    try{
    String header = page.textContent(pageTitle_css);
    System.out.println("browser sweet Page title :- " + header);
    return header;
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to fetch header text", e);
      return null;
    }
  }

  public LoginPage navigateToLoginPage() {
   try{
     page.click(loginLink_xpath);
     // page channing concept.
     return new LoginPage(page);
    } catch (Exception e) {
     logger.log(Level.SEVERE, "Failed to navigate to login page", e);
     throw new RuntimeException("Navigation to login page failed", e);
    }
  }

  public SweetsPage navigateToSweetPage() {
    try{
    page.click(sweetsLink_xpath);
    // page channing concept.
    return new SweetsPage(page);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to navigate to sweets page", e);
      throw new RuntimeException("Navigation to sweets page failed", e);
    }
  }

  public BasketPage navigateToBasketPage() {
    try{
      page.click(basketLink_xpath);
      // page channing concept.
      return new BasketPage(page);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to navigate to basket page", e);
      throw new RuntimeException("Navigation to basket page failed", e);
    }
  }

  public OrderHistoryPage navigateToOrderHistoryPage() {
   try{
    // page channing concept.
    return new OrderHistoryPage(page);
    } catch (Exception e) {
     logger.log(Level.SEVERE, "Failed to navigate to order history page", e);
     throw new RuntimeException("Navigation to order history page failed", e);
    }
  }
}
