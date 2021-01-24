@web
Feature: UI Related Functions

  Scenario Outline: Sign in without filling the credentials

    Given I access the homepage
    And I click on the sign-in link
    When I leave the credentials empty
    And I click on the sign-in button
    Then  I should get an error "<error>"

    Examples:
      | error |
      | An email address required. |

  Scenario Outline: Sign in with empty credentials

    Given I access the homepage
    And I click on the sign-in link
    When I input empty credentials
    And I click on the sign-in button
    Then  I should get an error "<error>"

    Examples:
      | error |
      | An email address required. |

  Scenario Outline: Sign in with empty username only

    Given I access the homepage
    And I click on the sign-in link
    When I input the password "<password>"
    And I click on the sign-in button
    Then  I should get an error "<error>"

    Examples:
      | password | error |
      | test1234 | An email address required. |

  Scenario Outline: Sign in with incorrect credentials

    Given I access the homepage
    And I click on the sign-in link
    When I input the username "<username>"
    And I input the password "<password>"
    And I click on the sign-in button
    Then  I should get an error "<error>"

    Examples:
      | username | password | error |
      | username1@email.com | test1234 | Authentication failed. |

    Scenario: Expedia site

      Given I access the expedia flights page
      And I click on the multi-flight button
      And I add 3 travellers
      And I input the first flight origin airport "Luqa"
      And I input a flight destination airport "Munich" and date "12"
      And I input a flight destination airport "Paris" and date "15"
      When I search for flights
      Then I should get some results
