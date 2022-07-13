Feature: Login into Application

  Scenario Outline: Positive test validating login
    Given Initialize the browser with chrome
    And Navigate to Site
    When User enters <username> and <password> and logs in
    Then Verify that user is succesfully logged in
    And close browsers

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Negative test validating login
    Given Initialize the browser with chrome
    And Navigate to Site
    When User enters <username> and <password> and logs in
    Then Verify that user has not logged in
    And close browsers

    Examples: 
      | username       | password      |
      | standard_ruser | secret_rsauce |

  Scenario Outline: Automate dropdown
    Given Initialize the browser with chrome
    And Navigate to Site
    When User enters <username> and <password> and logs in
    Given automate the dropdown and do all actions
    And close browsers

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
