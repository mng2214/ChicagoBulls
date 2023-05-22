#User Story: As a user, I want to be able to view a list of available COVID vaccines along with their prices so that I can compare and make an informed decision.
#Acceptance Criteria:
#Given that I am on the vaccines page, when I browse the list of vaccines, then each vaccine should have its price listed next to it.
#it should work for other categories as well
  @ProductCategory @smoke @regression
  Feature: Testing Category Product Functionality
    Scenario Outline: User able to view a list of available category products
      When User provides  correct credentials and login
      Then User choose a '<category>' and validates productName and price belongs to that category
      Examples:
        | category  |
        | vaccines  |
        | drugs     |
        | tools     |
        | machinery |


