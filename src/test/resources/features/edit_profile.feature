Feature: Edit Profile

  Scenario Outline: Edit profile summary
    Given the user opens the home page
    When the user logs in with username "username" and password "password"
    And the user goes to the profile page
    And the user edits the profile summary to "<First Summary>" with 5 attempts
    Then the profile summary should be "<First Summary>"
    When the user edits the profile summary to "<Second Summary>" with 5 attempts
    Then the profile summary should be "<Second Summary>"

    Examples:
    | First Summary   | Second Summary |
    | My test summary | Test           |