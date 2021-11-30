package stepDefs;

import helpers.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.HomePage;

public class HomePageSteps {
    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("user is on Home Page")
    public void user_is_on_home_page() {
        homePage.navigateToHome(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    @When("user searches for {string}")
    public void user_searches_for(String string) {
        homePage.performSearch(string);
    }
}
