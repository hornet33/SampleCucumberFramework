package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacedSummaryPage {
    WebDriver driver;
    @FindBy(className = "woocommerce-thankyou-order-received")
    private WebElement successMessageDisplay;
    @FindBy(xpath = "//li[@class=\"order\"]/strong")
    private WebElement orderIdDisplay;

    public OrderPlacedSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSuccessMessage() {
        return (successMessageDisplay.getText());
    }

    public String getOrderId() {
        return (orderIdDisplay.getText());
    }
}
