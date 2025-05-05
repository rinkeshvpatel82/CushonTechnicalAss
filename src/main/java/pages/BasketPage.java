package pages;

import Constants.AppConstants;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class BasketPage {
    private Page page;
    // String Locator - OR
    private final String pageHeaderText_css=".display-3";
    private final String checkOutBtn_css="button:text('Continue to checkout')";
    // page constructor
    public BasketPage(Page page){
        this.page=page;
    }

    public String pageHeaderText(){
        return page.textContent(pageHeaderText_css);
    }

    public void checkOutBtnClick(){
        page.click(checkOutBtn_css);
    }
}
