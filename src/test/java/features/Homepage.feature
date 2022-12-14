Feature: Homepage Feature Scenario

  Background: 
    Given I have successfully login

  @sanity
  Scenario Outline: This scenario is to define the view product path
    When I select the product as "<ProductName>"
    Then I should land on the product detail page

    Examples: 
      | ProductName              |
      | Sauce Labs Fleece Jacket |

  @sanity
  Scenario Outline: This scenario is to define the add product path
    When I select the ADD_TO_CART button for the "<ProductName>"
    Then Cart item number should be increased by one

    Examples: 
      | ProductName              |
      | Sauce Labs Fleece Jacket |
