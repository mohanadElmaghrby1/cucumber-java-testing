#Feature: Addition of two numbers
#
#  Scenario Outline: Add two string numbers
#    When I input numbers <a> and <b>
#    Then I should get the result <c>
#    Examples:
#      | a   |  b  | c   |
#      | "1" | "2" | 3   |
#      | "2" | "2" | 4   |
#
#  Scenario Outline: Add invalid two string numbers
#    When I input numbers <a> and <b>
#    Then I should get an error
#    Examples:
#      | a    |  b  |
#      | "sa" | "2" |
#
