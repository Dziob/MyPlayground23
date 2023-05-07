Feature: Adding a product to the cart
  Scenario: Adding a product to the cart and checking if it has been added correctly, then removing the product from the cart
    Given The user is on the Home page of mystore.com
    When From 'Popular Products' user chooses a 'Hummingbird Printed T-Shirt'
    And Checking for a discount and chooses the 'L' size and the color black
    And User adds one product to the cart
    And User confirms the action by using the 'Proceed to checkout button
    Then User can see the product with the correct size, color, and price in the cart
    And User deletes the product from the cart
    And User closes the page
