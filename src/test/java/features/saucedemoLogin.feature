Feature: Login Feature Scenario

  Background: 
    Given I have launched the application

  @regression
  Scenario Outline: This scenario is to define the login happy path
    When I enter the correct username as "<UserName>" and password as "<Password>"
    And I click on the Login Button
    Then I should land on the home page

    Examples: 
      | UserName      | Password     |
      | standard_user | secret_sauce |

  @regression
  Scenario: This scenario is to define the login happy path
    When I enter the correct username and password
    And I click on the Login Button
    Then I should land on the home page

  @regression
  Scenario Outline: This scenario is to define the failure path
    When I enter the incorrect username as "<UserName>" and password as "<Password>"
    And I click on the Login Button
    Then I should get the error message "Epic sadface: Sorry, this user has been locked out."

    Examples: 
      | UserName        | Password     |
      | locked_out_user | secret_sauce |
