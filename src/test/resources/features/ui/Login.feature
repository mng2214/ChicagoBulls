@smoke @regression
Feature: Codefish login functionality

  @positiveLogin
  Scenario: Positive login functionality
    When User provides  correct credentials and login
    Then User validates title 'Ecommerce App'

  @negativeLogin
  Scenario Outline: Negative login functionality
    When User provides  '<username>' and '<password>' and login
    Then User validates message '<message>'
    Examples:
      | username     | password | message               |
      | chicagoBulls | wrong    | Authentication failed |
      | wrong        | 12345    | Authentication failed |
      | chicagoBulls |          | Authentication failed |
      |              | 12345    | Authentication failed |
      |              |          | Authentication failed |
      | admin        |          | Authentication failed |
      |              | admin    | Authentication failed |

