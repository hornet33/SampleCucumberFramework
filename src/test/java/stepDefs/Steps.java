package stepDefs;

import java.util.concurrent.TimeUnit;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

public class Steps {
    WebDriver driver;

    @Given("user is on Home Page")
    public void user_is_on_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shop.demoqa.com/");
    }

    @When("user searches for {string}")
    public void user_searches_for(String string) {
        driver.findElement(By.className("noo-search")).click();
        driver.findElement(By.name("s")).sendKeys(string + Keys.ENTER);
    }

    @When("choose to buy the first item from the search results")
    public void choose_to_buy_the_first_item_from_the_search_results() {
        List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
        items.get(0).click();
    }

    @When("selects the color as {string}")
    public void selects_the_color_as(String string) {
        Select colorDropdown = new Select(driver.findElement(By.id("pa_color")));
        colorDropdown.selectByValue(string.toLowerCase());
    }

    @When("selects the size as {string}")
    public void selects_the_size_as(String string) {
        Select sizeDropdown = new Select(driver.findElement(By.id("pa_size")));
        sizeDropdown.selectByValue(string.toLowerCase());
    }

    @When("clicks on the {string} button")
    public void clicks_on_the_button(String string) {
        driver.findElement(By.xpath("//button[contains(text(),'" + string + "')]")).click();
    }

    @When("clicks on the {string} link")
    public void clicks_on_the_link(String string) {
        driver.findElement(By.xpath("//a[contains(text(),'" + string + "')]")).click();
    }

    @When("enters valid personal details on checkout page")
    public void enters_valid_personal_details_on_checkout_page() {
        driver.findElement(By.id("billing_first_name")).sendKeys("Rahul");
        driver.findElement(By.id("billing_last_name")).sendKeys("Selenium");
        driver.findElement(By.id("billing_address_1")).sendKeys("Address Line 1");
        driver.findElement(By.id("billing_address_2")).sendKeys("Address Line 2");
        driver.findElement(By.id("billing_city")).sendKeys("City");
        driver.findElement(By.id("billing_postcode")).sendKeys("560098");
        driver.findElement(By.id("billing_phone")).sendKeys("1234567890");
        driver.findElement(By.id("billing_email")).sendKeys("a@b.com");
        driver.findElement(By.id("order_comments")).sendKeys("Test Comment" + Keys.TAB);
    }

    @When("accepts the t&c checkbox")
    public void accepts_the_t_c_checkbox() {
        WebElement tAndCBox = driver.findElement(By.cssSelector("#terms.input-checkbox"));
        if (!tAndCBox.isSelected()) {
            tAndCBox.click();
        }
    }

    @Then("successful order confirmation message {string} is shown")
    public void successful_order_confirmation_message_is_shown(String string) {
        String successTextDisplayed = driver.findElement(By.className("woocommerce-thankyou-order-received")).getText();
        Assert.assertEquals(successTextDisplayed, string);
    }

    @And("an order number is displayed")
    public void an_order_number_is_displayed() {
        String orderNumber = driver.findElement(By.xpath("//li[@class=\"order\"]/strong")).getText();
        if (Integer.parseInt(orderNumber) > 0) {
            Assert.assertTrue(true);
        } else Assert.assertTrue(false);
    }

    @And("user closes the browser")
    public void user_closes_the_browser() {
        driver.quit();
    }
}
