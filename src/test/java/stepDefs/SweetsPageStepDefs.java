package stepDefs;

import Tests.SweetsPageTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class SweetsPageStepDefs {
    SweetsPageTest sweetsPageTest=new SweetsPageTest();
    @And("the user verify the basket is empty.")
    public void theUserVerifyTheBasketIsEmpty() {
        sweetsPageTest.basketCount();
    }

    @When("the user select the products by clicking on add to cart button from product list.")
    public void theUserSelectTheProductsByClickingOnAddToCartButtonFromProductList(DataTable dataTable) {
        List<List<String>> userList = dataTable.asLists(String.class);
        for (List<String> product : userList){
            sweetsPageTest.productAddToCart(product);
        }
    }

    @And("the user click on basket icon.")
    public void theUserClickOnBasketIcon() {
    }
}
