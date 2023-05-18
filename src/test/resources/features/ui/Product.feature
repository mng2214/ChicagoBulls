@product @smoke @regression
Feature: User views multiple products

  Scenario: User should  be able to see products
    When User provides  correct credentials and login
    Then User should see multiple products displayed


  Scenario: Viewing product details
    When User provides  correct credentials and login
    Then User validates  9 of: picture, names, descriptions, prices and Add to Cart

