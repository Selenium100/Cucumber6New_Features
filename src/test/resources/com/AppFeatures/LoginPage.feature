Feature: Login Page Feature

  Scenario: Login Page Title
    Given user is on login page
    Then user gets the title of the page
    Then Page title should be "Login - My Store"

  Scenario: Forgot Password Link
    Given user is on login page
    Then Forgot password link should be displayed

  Scenario: Login with correct Credentils
    Given user is on login page
    When user enters username "nityaranjan190592@gmail.com"
    And user enters password "Selenium@100"
    And user clicks on Login button
    Then user gets the title of the page
    And Page title should be "My account - My Store"
