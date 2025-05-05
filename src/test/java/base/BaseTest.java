package base;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import pages.BasketPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SweetsPage;
import utils.PlaywrightDriver;

import java.util.Properties;

public class BaseTest {
    PlaywrightDriver playwrightDriver;
    Page page;
    protected Properties prop;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SweetsPage sweetsPage;
    protected BasketPage basketPage;

    public BaseTest(){
        playwrightDriver=new PlaywrightDriver();
        prop=playwrightDriver.init_prop();
        page=PlaywrightDriver.getPage();
        homePage=new HomePage(page);
    }

}
