@web
Feature: User Related API Functions

  Scenario Outline: Register User Happy Path

    Given I create a "POST" request on "https://reqres.in/api/register"
    When I input an e-mail address "<emailAddress>"
    And I input a password "<password>"
    And I send the request
    Then  I should be able to register a user successfully

    Examples:
      | emailAddress | password |
      | janet.weaver@reqres.in | weakPassword |

  Scenario Outline: Register User Sad Path

    Given I create a "POST" request on "https://reqres.in/api/register"
    When I input an e-mail address "<emailAddress>"
    And I send the request
    Then  I should get a missing password error

    Examples:
      | emailAddress | password |
      | janet.weaver@reqres.in |  |

  Scenario: Get List of Users

    Given I create a "GET" request on "https://reqres.in/api/users"
    And I send the request
    Then  I should get a list of users
