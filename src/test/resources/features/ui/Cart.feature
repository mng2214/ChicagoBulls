Feature: Shopping Cart Functionality

  Scenario Outline:  Add product to cart and display check mark on the button
    Given the user is on the product page
    When the user clicks the Add to cart button for '<product>'
    Then a check mark should be displayed on the Add to cart button
    Examples:
      | product     |
      | LCD Digital |

@cartFunctionality
  Scenario: User can view selected products with their details

    Given the user is on the product page
    When  User clicks the Add to cart button for multiple product
      | firstItem       | secondItem  |
      | Sputnik Vaccine | Paracetamol |
    And User navigates to the cart page
    Then User validate all products information name,price and removeButton











