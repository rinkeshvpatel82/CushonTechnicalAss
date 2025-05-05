package Tests;

import base.BaseTest;
import org.testng.Assert;

public class BasketPageTest extends BaseTest {


    public boolean verifyTheHeaderText(String headerText){
        basketPage=homePage.navigateToBasketPage();
        String actualHeaderText=basketPage.pageHeaderText();
        System.out.println("Actual Your basket header Text :-"+actualHeaderText);
        Assert.assertEquals(actualHeaderText,headerText);
        return true;
    }

    public void clickOnCheckOutBtn(){
        basketPage.checkOutBtnClick();
    }
}
