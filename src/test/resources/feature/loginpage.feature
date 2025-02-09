Feature: Login Functionality for giva.co  Website.
  As a user of the giva.co  website
  I want to be able to log in with my account
  So that I can access my account-related features and manage my orders

  Background:
    Given I am on the giva.co login page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>

    Examples:

      | username             | password        | error_message                |
      | invalid@email.com    | invalidPassword | Incorrect email or password. |
      | valid@email.com      | invalidPassword | Incorrect email or password. |
      | kajalg2597@gmail.com | Kajal@2001      |                              |

