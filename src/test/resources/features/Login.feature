Feature: Test the Login functionality

  Background: Browser Setup
    Given I launch the browser
    And I am on the "Test Login Page"

  @Login
  Scenario: Valid Username and Password
    When I enter a "Valid username" in the "username" field
    When I enter a "Valid password" in the "password" field
    When I Click the "Login button"
    Then I should see the "successful message" in the "home page" field

  @Negative_Login
  Scenario: Invalid Username and Password
    When I enter a "invalid username" in the "username" field
    When I enter a "Valid password" in the "password" field
    When I Click the "Login button"
    Then I should see the "username error" in the "error" field

  @Negative_Login
  Scenario: Valid Username and Invalid Password
    When I enter a "Valid username" in the "username" field
    When I enter a "invalid password" in the "password" field
    When I Click the "Login button"
    Then I should see the "password error" in the "error" field

  @Negative_Login
  Scenario: Both Invalid Username and Password
    When I enter a "invalid username" in the "username" field
    When I enter a "invalid password" in the "password" field
    When I Click the "Login button"
    Then I should see the "username error" in the "error" field

  @Negative_Login
  Scenario: Valid Username Name and Blank Password
    When I enter a "Valid username" in the "username" field
    When I Click the "Login button"
    Then I should see the "password error" in the "error" field

  @Negative_Login
  Scenario: Blank Username Name and Valid password
    When I enter a "Valid password" in the "password" field
    When I Click the "Login button"
    Then I should see the "username error" in the "error" field

  @Negative_Login
  Scenario: Blank Username and Blank Password
    When I Click the "Login button"
    Then I should see the "username error" in the "error" field
