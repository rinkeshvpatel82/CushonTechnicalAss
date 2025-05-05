package stepDefs;

import Tests.HomePageTest;
import Tests.SweetsPageTest;
import io.cucumber.java.en.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class HomePageStepDefs {
    HomePageTest homePageTest=new HomePageTest();
    SweetsPageTest sweetsPageTest=new SweetsPageTest();
    @Given("the user is on the sweetshop home page.")
    public void the_user_is_on_the_sweetshop_home_page() {
        homePageTest.homePageTitleTest();
        System.out.println("the user is on the sweetshop home page.");
    }
    @When("user search the product with {string}, click on Browser Sweets.")
    public void userSearchTheProductWithClickOnBrowserSweets(String productName) {
        homePageTest.searchTest(productName);
        homePageTest.userVerifyTheProduct();
    }

    @Then("user able to navigate the {string} page, and see the {string} sweet.")
    public void userAbleToNavigateThePageAndSeeTheSweet(String headerText, String productName) {
        sweetsPageTest.verifyTheHeaderText(headerText);
        sweetsPageTest.verifyTheProductName(productName);
    }

}
