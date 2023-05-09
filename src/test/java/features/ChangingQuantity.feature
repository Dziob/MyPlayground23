Feature: Changing the quantity of the product
  Scenario: Changing the quantity of the product before and after adding to the cart
    Given The user is on the product page - Hummingbird Printed Sweater
    And Checking for a discount and chooses the 'M' size
    Then Changing the quantity of the product to '5'
    And Proced to checkout
    And Checking if quantity and size are correct
    Then Changing the quantity to '3'
    And Checking if quantity is correct
    And Closing the page

