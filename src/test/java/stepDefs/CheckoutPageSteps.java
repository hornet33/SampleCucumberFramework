package stepDefs;

import helpers.TestContext;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.CheckoutPage;
import testDataTypes.CustomerType;

public class CheckoutPageSteps {
    TestContext testContext;
    CheckoutPage checkoutPage;

    public CheckoutPageSteps(TestContext context){
        testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
    }

    @When("enters valid personal details of {string} on checkout page")
    public void enters_valid_personal_details_on_checkout_page(String customerName) {
        CustomerType customer = FileReaderManager.getInstance().getJsonDataReader().getCustomerByName(customerName);
        checkoutPage.enterPersonalDetails(customer);
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
