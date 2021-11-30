package stepDefs;

import helpers.TestContext;
import io.cucumber.java.en.When;
import pages.CartPage;

public class CartPageSteps {
    TestContext testContext;
    CartPage cartPage;

    public CartPageSteps(TestContext context){
        testContext = context;
        cartPage = testContext.getPageObjectManager().getCartPage();
    }

    @When("clicks on the \"Proceed to checkout\" link")
    public void clicks_on_the_proceed_to_checkout_link() {
        cartPage.proceedToCheckout();
    }
}
