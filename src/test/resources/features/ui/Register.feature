@smoke @regression @registerTest
Feature: Testing Register User Functionality

  Scenario: User navigates to Codefish and Register New User
   # When User on Login page click on Register
   # And User provides username and password
    Then User login as a new created user and validates profile same as username

  Scenario: User navigates to Codefish and Register Existing User
    When User on Login page click on Register
    And User provides username and password
    Then User validates error message 'Username already taken'