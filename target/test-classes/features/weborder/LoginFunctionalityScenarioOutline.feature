Feature: Testing the login functionality for WebOrder website Scenario Outline
  @smoke
  Scenario: Happy Path(Correct username-Correct Password)
    When User provides 'guest1@microworks.com','Guest1!' and click Login button
    Then User validates the 'ORDER DETAILS - Weborder'

  Scenario Outline:
    When User provides '<email>','<password>' and click Login button
    Then User validates the error '<message>'
    Examples:
    |  email                   | password    | message       |
    |  guest1@microworks.com   | buket       | Sign in Failed|
    |  wrongusername@gmail.com | Guest1!     | Sign in Failed|
    |                          |             | Sign in Failed|