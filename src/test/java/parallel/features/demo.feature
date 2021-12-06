Feature: Login into Application

  Scenario Outline: Scenario Bach 1
    Given Initialize the browser with <browserName> in
    And   Navigate to "https://www.phptravels.net/login" Site
    When  User enters <username> and <password> and logs in
    Then Verify that user is succesfully logged in
    Examples:
      |username			|password	| browserName |
      |user@phptravels.com	|demouser		| chrome  |

  Scenario Outline: Scenario Bach 2
    Given Initialize the browser with <browserName> in
    And   Navigate to "https://www.phptravels.net/login" Site
    When  User enters <username> and <password> and logs in
    Then Verify that user is succesfully logged in
    Examples:
      |username			|password	| browserName |
      |user@phptravels.com	|demouser		| chrome  |








