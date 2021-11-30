package stepDefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;
import managers.PagesManager;

public class Steps {
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OrderPlacedSummaryPage orderPlacedSummaryPage;
    PagesManager pagesManager;

    @Given("user is on Home Page")
    public void user_is_on_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pagesManager = new PagesManager(driver);
        homePage = pagesManager.getHomePage();
        homePage.navigateToHome("https://shop.demoqa.com/");
    }

    @When("user searches for {string}")
    public void user_searches_for(String string) {
        homePage.performSearch(string);
    }

    @When("choose to buy the first item from the search results")
    public void choose_to_buy_the_first_item_from_the_search_results() {
        searchResultsPage = pagesManager.getSearchResultsPage();
        searchResultsPage.selectProductFromSearchResults(0);
    }

    @When("selects the color as {string}")
    public void selects_the_color_as(String string) {
        productDetailsPage = pagesManager.getProductDetailsPage();
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

    @When("clicks on the \"Proceed to checkout\" link")
    public void clicks_on_the_proceed_to_checkout_link() {
        cartPage = pagesManager.getCartPage();
        cartPage.proceedToCheckout();
    }

    @When("enters valid personal details on checkout page")
    public void enters_valid_personal_details_on_checkout_page() {
        checkoutPage = pagesManager.getCheckoutPage();
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

    @Then("successful order confirmation message {string} is shown")
    public void successful_order_confirmation_message_is_shown(String string) {
        orderPlacedSummaryPage = pagesManager.getOrderPlacedSummaryPage();
        String successTextDisplayed = orderPlacedSummaryPage.getSuccessMessage();
        Assert.assertEquals(successTextDisplayed, string);
    }

    @And("an order number is displayed")
    public void an_order_number_is_displayed() {
        String orderNumber = orderPlacedSummaryPage.getOrderId();
        if (Integer.parseInt(orderNumber) > 0) {
            Assert.assertTrue(true);
        } else Assert.assertTrue(false);
    }

    @And("user closes the browser")
    public void user_closes_the_browser() {
        driver.quit();
    }
}
