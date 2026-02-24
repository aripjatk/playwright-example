Feature: Add to Cart

  Scenario Outline: Add product to cart
    Given the user opens the home page
    When the user logs in with username "username" and password "password"
    And the user searches for "<Product>"
    And the user selects the search result "<Product>"
    And the user adds "<Product>" to the cart
    Then the cart should contain "<Product>"

    Examples:
    | Product               |
    | Red Dead Redemption 2 |