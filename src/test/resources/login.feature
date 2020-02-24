Feature: user Login

  Background:
    Given the following user exist in the system
      | email                  | password   | firstname   | lastname |
      | amisbah.ext@orange.com | 1234567890 | Ahmed       | Misbah   |

  Scenario: Successful login
    When I login with my credentials
      | email            | password |
      | amisbah.ext@orange.com | 1234567890   |

    Then I should login to the application and see a welcome message
      | firstname | lastname |
      | Ahmed     | Misbah   |

  Scenario: Unsuccessful login
    When I login with my invalid credentials
      | email            | password |
      | oob.ext@orange.co | 2112   |

    Then I should get invalid email or password alert message


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
