@product @smoke @regression
Feature: User views multiple products

  Scenario: User should  be able to see products
    When User provides  correct credentials and login
    Then User should see multiple products displayed


  Scenario: Viewing product details
    When User provides  correct credentials and login
    Then User should see the picture of each product
    And User should see the name of each product
    And User should see the description of each product
    And User should see the price of each product
    And User should see an Add to Cart button for each product
