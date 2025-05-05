package Tests;

import Constants.AppConstants;
import base.BaseTest;
import org.testng.Assert;

import java.util.List;


public class SweetsPageTest extends BaseTest {


    public void basketCount(){
        sweetsPage=homePage.navigateToSweetPage();
        Assert.assertEquals(sweetsPage.actualProductCount(), AppConstants.EMPTY_BASKET);
    }
    public boolean verifyTheHeaderText(String headerText){
        sweetsPage=homePage.navigateToSweetPage();
        String actualHeaderText=sweetsPage.pageHeaderText();
        System.out.println("Actual browse sweets header Text :-"+actualHeaderText);
        Assert.assertEquals(actualHeaderText,headerText);
        return true;
    }

    public boolean verifyTheProductName(String productName){
        sweetsPage=homePage.navigateToSweetPage();
        String actualProductNameText=sweetsPage.selectedProduct(productName);
        Assert.assertEquals(actualProductNameText,productName);
        return true;
    }

    public void productAddToCart(List<String> selectedProduct){
        sweetsPage.productAddToCart(selectedProduct);
    }



}
