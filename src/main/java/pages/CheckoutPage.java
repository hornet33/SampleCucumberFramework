package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;
    @FindBy(id = "billing_first_name")
    private WebElement firstName;
    @FindBy(id = "billing_last_name")
    private WebElement lastName;
    @FindBy(id = "billing_address_1")
    private WebElement address1;
    @FindBy(id = "billing_address_2")
    private WebElement address2;
    @FindBy(id = "billing_city")
    private WebElement city;
    @FindBy(id = "billing_postcode")
    private WebElement postcode;
    @FindBy(id = "billing_phone")
    private WebElement phone;
    @FindBy(id = "billing_email")
    private WebElement email;
    @FindBy(id = "order_comments")
    private WebElement comments;
    @FindBy(css = "#terms.input-checkbox")
    private WebElement tAndCBox;
    @FindBy(xpath = "//button[contains(text(),'Place order')]")
    private WebElement orderButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String fName) {
        firstName.sendKeys(fName);
    }

    public void enterLastName(String lName) {
        lastName.sendKeys(lName);
    }

    public void enterAddress1(String add1) {
        address1.sendKeys(add1);
    }

    public void enterAddress2(String add2) {
        address2.sendKeys(add2);
    }

    public void enterCity(String cty) {
        city.sendKeys(cty);
    }

    public void enterPostCode(String pCode) {
        postcode.sendKeys(pCode);
    }

    public void enterPhone(String ph) {
        phone.sendKeys(ph);
    }

    public void enterEmail(String eml) {
        email.sendKeys(eml);
    }

    public void enterComments(String txt) {
        comments.sendKeys(txt);
    }

    public void enterPersonalDetails() {
        enterFirstName("Rahul");
        enterLastName("Selenium");
        enterAddress1("Address Line 1");
        enterAddress2("Address Line 2");
        enterCity("City");
        enterPostCode("560098");
        enterPhone("1234567890");
        enterEmail("a@b.com");
        enterComments("Test Comment" + Keys.TAB);
    }

    public void checkTAndCBox(){
        tAndCBox.click();
    }

    public void placeOrder(){
        orderButton.click();
    }
}
