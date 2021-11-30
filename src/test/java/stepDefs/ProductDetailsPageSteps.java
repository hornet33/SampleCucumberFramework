package stepDefs;

import helpers.TestContext;
import io.cucumber.java.en.When;
import pages.ProductDetailsPage;

public class ProductDetailsPageSteps {
    TestContext testContext;
    ProductDetailsPage productDetailsPage;

    public ProductDetailsPageSteps(TestContext context) {
        testContext = context;
        productDetailsPage = testContext.getPageObjectManager().getProductDetailsPage();
    }

    @When("selects the color as {string}")
    public void selects_the_color_as(String string) {
        productDetailsPage.selectColor(string);
    }

    @When("selects the size as {string}")
    public void selects_the_size_as(String string) {
        productDetailsPage.selectSize(string);
    }

    @When("clicks on the \"Add to cart\" button")
    public void clicks_on_the_add_to_cart_button() {
        productDetailsPage.doAddToCart();
    }

    @When("clicks on the \"View cart\" link")
    public void clicks_on_the_view_cart_link() {
        productDetailsPage.clickViewCartLink();
    }
}
