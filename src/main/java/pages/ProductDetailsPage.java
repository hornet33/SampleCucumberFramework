package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {
    WebDriver driver;

    @FindBy(id = "pa_color")
    private WebElement sColor;

    @FindBy(id = "pa_size")
    private WebElement sSize;

    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    private WebElement cartButton;

    @FindBy(xpath = "//a[contains(text(),'View cart')]")
    private WebElement viewCartLink;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectColor(String color) {
        Select colorDropdown = new Select(sColor);
        colorDropdown.selectByVisibleText(color);
    }

    public void selectSize(String size) {
        Select sizeDropdown = new Select(sSize);
        sizeDropdown.selectByVisibleText(size);
    }

    public void doAddToCart() {
        cartButton.click();
    }

    public void clickViewCartLink() {
        viewCartLink.click();
    }
}
