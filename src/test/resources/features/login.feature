Feature: User Login

  Scenario: Successful login and username validation
    Given the user opens the home page
    When the user logs in with username "username" and password "password"
    Then the displayed username should contain "ari_kaczmarek"