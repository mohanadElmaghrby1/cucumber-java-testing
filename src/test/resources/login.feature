Feature: user Login

  Background:
    Given the following user exist in the system
      | email            | password | firstname | lastname |
      | hammad@gmail.com | abcd12   | mohamed     | hammad   |
      | mai@gmail.com    | abcd     | mai         | sabry    |

  Scenario: Successful login
    When I login with my credentials
      | email            | password |
      | hammad@gmail.com | abcd12   |

    Then I should login to the application and see a welcome message
      | firstname | lastname |
      | ahmed     | hammad   |



#  Scenario Outline: Invalid credentials
#    When I input  <email> and <password>
#    Then I should get <invalidmessage>
#    And I should not be logged in
#    Examples:
#      | email      | password | invalidmessage              |
#      | "mohannad" | "oli"    | "invalid email or password" |
#      | "mai"      | "abcd12" | "invalid email or password" |
#      | "hammad"   | "glo"    | "invalid email or password" |
#
#
#  Scenario: acess wwelcome screen with anonymous user
#    When a user attempts to access the application without login
#    Then I should be redirected to login
#    And  I should get "please login first"
