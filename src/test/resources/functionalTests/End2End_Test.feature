@OrderEndToEnd
Feature: End to end test from search to order item
  Description: The purpose of this feature is to test the end-to-end flow from home page to successful order

  Scenario Outline:
    Given user is on Home Page
    When user searches for "<item>"
    And choose to buy the first item from the search results
    And selects the color as "<colour>"
    And selects the size as "<size>"
    And clicks on the "Add to cart" button
    And clicks on the "View cart" link
    And clicks on the "Proceed to checkout" link
    And enters valid personal details of "<customer>" on checkout page
    And accepts the t&c checkbox
    And clicks on the "Place order" button
    Then successful order confirmation message "Thank you. Your order has been received." is shown
    And an order number is displayed
    Examples:
      | item  | colour  | size   | customer |
      | shirt | Pink    | 38      | Rahul    |
      | dress | White   | Medium | Virender |
