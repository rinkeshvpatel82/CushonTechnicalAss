package pages;

import com.microsoft.playwright.Page;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SweetsPage {
  private static final Logger logger = Logger.getLogger(SweetsPage.class.getName());
  private final Page page;

  // String Locator - OR
  private final String productsName_css = ".card-body > h4";
  private final String addToBasketBtn_css = ".card-footer > a ";
  private final String basketBadge_css = ".badge.badge-success";
  private final String pageHeaderText_css = ".display-3";


  // page constructor
  public SweetsPage(Page page) {
    this.page = page;
  }

  // page Action

  public String pageHeaderText() {
    try{
    return page.textContent(pageHeaderText_css);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to fetch page header text", e);
      return null;
    }
  }

  public String selectedProduct(String productName) {
    try{
    String selectedProduct = "";
    int count = page.locator(productsName_css).count();
    for (int i = 0; i < count; i++) {
      String actualProductName = page.locator(productsName_css).nth(i).textContent();
      if (productName.equals(actualProductName)) {
        selectedProduct = page.locator(productsName_css).nth(i).textContent();
        System.out.println("selected product :- " + selectedProduct);
      }
    }
    return selectedProduct;
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to select product: " + productName, e);
      return null;
    }
  }

  public String actualProductCount() {
    try{
    return page.textContent(basketBadge_css);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to fetch actual product count", e);
      return null;
    }
  }

  public void productAddToCart(List<String> selectedProduct) {
    try{
    String productName = selectedProduct.toString();
    String firstTrim = productName.split("\\[")[1];
    String expectedProductName = firstTrim.split("]")[0];
    System.out.println("productName:- " + expectedProductName);
    int count = page.locator(productsName_css).count();
    for (int i = 0; i < count; i++) {
      String actualProductName = page.locator(productsName_css).nth(i).textContent();
      if (expectedProductName.equals(actualProductName)) {
        page.locator(addToBasketBtn_css).nth(i).click();
      }
    }
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Failed to add product to cart", e);
      throw new RuntimeException("Product addition to cart failed", e);
    }
  }
}
