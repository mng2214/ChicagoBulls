@smoke @regression
Feature: Codefish login functionality

  Scenario: Positive login functionality
    When User provides  correct credentials and login
    Then User validates title 'Ecommerce App'

  Scenario Outline: Negative login functionality
    When User provides  '<username>' and '<password>' and login
    Then User validates message '<message>'
    Examples:
      | username | password | message               |
      | admin    | wrong    | Authentication failed |
      | wrong    | admin    | Authentication failed |
      | admin    |          | Authentication failed |
      |          | wrong    | Authentication failed |
      |          |          | Authentication failed |
