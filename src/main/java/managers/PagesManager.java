package managers;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PagesManager {
    WebDriver driver;
    private OrderPlacedSummaryPage orderPlacedSummaryPage;
    private CartPage cartPage;
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private SearchResultsPage searchResultsPage;
    private ProductDetailsPage productDetailsPage;

    public PagesManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public SearchResultsPage getSearchResultsPage() {
        return (searchResultsPage == null) ? searchResultsPage = new SearchResultsPage(driver) : searchResultsPage;
    }

    public ProductDetailsPage getProductDetailsPage() {
        return (productDetailsPage == null) ? productDetailsPage = new ProductDetailsPage(driver) : productDetailsPage;
    }

    public CartPage getCartPage() {
        return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;
    }

    public OrderPlacedSummaryPage getOrderPlacedSummaryPage() {
        return (orderPlacedSummaryPage == null) ? orderPlacedSummaryPage = new OrderPlacedSummaryPage(driver) : orderPlacedSummaryPage;
    }
}
