@smoke @regression @removeTest
Feature: Testing remove from shopping cart functionality

  Scenario: User add and then remove product from cart

    Given User add a product to shopping cart
      | product     | Paracetamol |

    When  User deletes the product
    Then  User validates message
      | message | Cart is empty. |
