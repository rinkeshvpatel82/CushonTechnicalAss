package Tests;

import Constants.AppConstants;
import base.BaseTest;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import pages.HomePage;


public class HomePageTest extends BaseTest {

    public void homePageTitleTest(){
        String actualTitle=homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle,AppConstants.HOME_PAGE_TITLE);
    }

    public void homePageUrlTest(){
        String actualUrl=homePage.getHomePageUrl();
        Assert.assertEquals(actualUrl, prop.getProperty("testUrl"));
    }
    public void searchTest(String productName){
        homePage.doSearch(productName);
    }
    public void userVerifyTheProduct(){
        String actualHeader=homePage.headerText();
        Assert.assertEquals(actualHeader,AppConstants.BROWSE_SWEETS);
    }


}
