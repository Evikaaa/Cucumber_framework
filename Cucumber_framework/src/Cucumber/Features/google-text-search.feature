Feature: Google search

  Scenario Outline: user can search any keyword

    Given an open browser with google.com
    When a keyword <keyword> is entered in input field
    Then the first one should contain <expectedWord>
    And close browser
    Examples:
    |keyword | expectedWord|
    |John    |Doe          |
    | karol  | karol       |
    | jacek  | jacek       |





#Feature: Google search
#
#  Scenario: user can search any keyword
#
#    Given an open browser with google.com
#    When a keyword selenium is entered in input field
#    Then the first one should contain selenium
#    And close browser
