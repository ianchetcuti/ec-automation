@web
Feature: Search functionality

  Scenario Outline: Perform Search

    Given I access the askgamblers website and I input "<searchTerm>"
    When  I click on the Search button
    Then  I should be redirected to the results page
    And I should be able to verify the "<result>"
    Then I go back to the landing page
    Examples:
      | searchTerm | result |
      | Betsson | betsson casino |

  Scenario Outline: Click on Complaints

    Given I access the askgamblers website and I click on button "<buttonName>"
    When  I am redirected to the page
    Then  I should be able to see the complaints
    Examples:
      | buttonName |
      | complaints |
