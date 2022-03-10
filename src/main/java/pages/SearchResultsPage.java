package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SearchResultsPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='noo-product-thumbnail']")
    private List<WebElement> items;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProductFromSearchResults(int productIndex) {
        items.get(productIndex).click();
    }
}
