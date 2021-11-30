package stepDefs;

import helpers.TestContext;
import io.cucumber.java.en.When;
import pages.CheckoutPage;

public class CheckoutPageSteps {
    TestContext testContext;
    CheckoutPage checkoutPage;

    public CheckoutPageSteps(TestContext context){
        testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
    }

    @When("enters valid personal details on checkout page")
    public void enters_valid_personal_details_on_checkout_page() {
        checkoutPage.enterPersonalDetails();
    }

    @When("accepts the t&c checkbox")
    public void accepts_the_t_c_checkbox() {
        checkoutPage.checkTAndCBox();
    }

    @When("clicks on the \"Place order\" button")
    public void clicks_on_the_place_order_button() {
        checkoutPage.placeOrder();
    }
}
