package stepDefs;

import io.cucumber.java.en.*;
import pages.LoginPage;

public class loginStepDefs {
    LoginPage loginPage=new LoginPage();

    @Given("the user is on the sweetshop login page.")
    public void the_user_is_on_the_sweetshop_login_page() {
    System.out.println("the user is on the sweetshop login page.");
    }
    @When("the user enter valid username.")
    public void the_user_enter_valid_username() {
    System.out.println("the user enter valid username.");
    }
    @And("the user enter valid password.")
    public void the_user_enter_valid_password() {
    System.out.println("the user enter valid password.");
    }
    @And("the user click on login button.")
    public void the_user_click_on_login_button() {
    System.out.println("the user click on login button.");
    }
    @Then("the user navigates to the {string} page successfully.")
    public void the_user_navigates_to_the_page_successfully(String string) {
    System.out.println("the user navigates to the {string} page successfully.");
    }
}
