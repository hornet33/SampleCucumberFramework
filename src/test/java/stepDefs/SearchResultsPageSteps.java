package stepDefs;

import helpers.TestContext;
import io.cucumber.java.en.When;
import pages.SearchResultsPage;

public class SearchResultsPageSteps {
    TestContext testContext;
    SearchResultsPage searchResultsPage;

    public SearchResultsPageSteps(TestContext context){
        testContext = context;
        searchResultsPage = testContext.getPageObjectManager().getSearchResultsPage();
    }

    @When("choose to buy the first item from the search results")
    public void choose_to_buy_the_first_item_from_the_search_results() {
        searchResultsPage.selectProductFromSearchResults(0);
    }
}
