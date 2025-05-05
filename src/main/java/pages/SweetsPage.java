package pages;

import com.microsoft.playwright.Page;

import java.util.List;

public class SweetsPage {
    private Page page;

    // String Locator - OR
    private final String productsName_css=".card-body > h4";
    private final String addToBasketBtn_css=".card-footer > a ";
    private final String basketBadge_css=".badge.badge-success";
    private final String pageHeaderText_css=".display-3";

    // page constructor
    public SweetsPage(Page page){
        this.page=page;
    }

    // page Action

    public String pageHeaderText(){
        return page.textContent(pageHeaderText_css);
    }
    public String selectedProduct(String productName){
        String selectedProduct="";
        int count=page.locator(productsName_css).count();
        for(int i=0;i<count;i++){
            String actualProductName=page.locator(productsName_css).nth(i).textContent();
            if(productName.equals(actualProductName)){
                selectedProduct=page.locator(productsName_css).nth(i).textContent();
                System.out.println("selected product :- "+selectedProduct);
            }
        }
        return selectedProduct;
    }

    public String actualProductCount(){
        return page.textContent(basketBadge_css);
    }

    public void productAddToCart(List<String> selectedProduct) {
        String productName = selectedProduct.toString();
        String firstTrim = productName.split("\\[")[1];
        String expectedProductName = firstTrim.split("]")[0];
        System.out.println("productName:- " +expectedProductName);
        int count=page.locator(productsName_css).count();
        for(int i=0;i<count;i++){
            String actualProductName=page.locator(productsName_css).nth(i).textContent();
            if(expectedProductName.equals(actualProductName)){
                page.locator(addToBasketBtn_css).nth(i).click();
            }
        }
    }

}
