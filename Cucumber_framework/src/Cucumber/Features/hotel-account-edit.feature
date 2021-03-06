@hotel
Feature: Hotel account edit

  @edit
  Scenario: User adds first address to the account
    Given I'm on main page
    When I go to login page
    And I login using "johnd@tescik.com" and "secretpass"
    And I go to my addresses page
    Then I can see there is no addresses
    When I add new address
    And I enter new address "First address", "Street", "62-000", "City", "123456789"
    Then I can see new address
    And I verify created address "First address", "Street", "62-000", "City", "123456789"
    And I remove the address
    And I can see that address was removed
    # close browser