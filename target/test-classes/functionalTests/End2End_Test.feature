@OrderEndToEnd
Feature: End to end test from search to order item
  Description: The purpose of this feature is to test the end-to-end flow from home page to successful order

  Scenario:
    Given user is on Home Page
    When user searches for "dress"
    And choose to buy the first item from the search results
    And selects the color as "White"
    And selects the size as "Small"
    And clicks on the "Add To Cart" button
    And clicks on the "View Cart" button
    And clicks on the "Proceed to Checkout" button
    And enters valid personal details on checkout page
    And accepts the t&c checkbox
    And clicks on "Place Order" button
    Then successful order confirmation message "Thank you. Your order has been received." is shown
    And an order number is displayed