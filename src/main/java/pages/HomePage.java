package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "noo-search")
    private WebElement searchButton;

    @FindBy(name = "s")
    private WebElement searchTextBox;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void performSearch(String searchText) {
        searchButton.click();
        searchTextBox.sendKeys(searchText + Keys.ENTER);
    }

    public void navigateToHome(String homePageURL) {
        driver.get(homePageURL);
    }
}
