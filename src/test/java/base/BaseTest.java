package base;

import com.microsoft.playwright.Page;
import java.util.Properties;
import pages.*;
import utils.PlaywrightDriver;

public class BaseTest {
  protected Properties prop;
  protected HomePage homePage;
  protected LoginPage loginPage;
  protected SweetsPage sweetsPage;
  protected BasketPage basketPage;
  protected OrderHistoryPage orderHistoryPage;
  PlaywrightDriver playwrightDriver;
  Page page;

  public BaseTest() {
    playwrightDriver = new PlaywrightDriver();
    prop = playwrightDriver.init_prop();
    page = PlaywrightDriver.getPage();
    homePage = new HomePage(page);
  }
  /*
    Standard functions will write here.
   */
}
