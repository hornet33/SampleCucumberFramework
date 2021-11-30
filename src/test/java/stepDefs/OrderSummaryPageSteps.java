package stepDefs;

import helpers.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import managers.DriverManager;
import pages.OrderPlacedSummaryPage;

public class OrderSummaryPageSteps {
    TestContext testContext;
    OrderPlacedSummaryPage orderPlacedSummaryPage;
    DriverManager driverManager;

    public OrderSummaryPageSteps(TestContext context) {
        testContext = context;
        orderPlacedSummaryPage = testContext.getPageObjectManager().getOrderPlacedSummaryPage();
        driverManager = testContext.getDriverManager();
    }

    @Then("successful order confirmation message {string} is shown")
    public void successful_order_confirmation_message_is_shown(String string) {
        String successTextDisplayed = orderPlacedSummaryPage.getSuccessMessage();
        Assert.assertEquals(successTextDisplayed, string);
    }

    @And("an order number is displayed")
    public void an_order_number_is_displayed() {
        String orderNumber = orderPlacedSummaryPage.getOrderId();
        if (Integer.parseInt(orderNumber) > 0) {
            Assert.assertTrue(true);
        } else Assert.fail();
    }
}
