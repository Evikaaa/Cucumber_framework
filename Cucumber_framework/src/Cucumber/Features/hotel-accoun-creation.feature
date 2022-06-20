@hotel
Feature: Hotel account creation

  @create
  Scenario Outline: User can create an account
    Given I'm on hotel main page
    When I'm sign in
    And I enter unique email address on authentication page
    And I enter name <name> surname <surname> and password <password>
    Then I can see success message with text "Your account has been created."
    And I close hotel browser
    Examples:
    |name|surname|password|
    |Joanna|Doe|passsss|
    |Jan|Kowalski|dup@aaa|
    |John|Doe    |secretpass|



