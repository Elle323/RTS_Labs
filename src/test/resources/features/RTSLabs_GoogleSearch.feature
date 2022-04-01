@rtslabs
Feature: RTS Labs in Google Search

  Scenario: User should be able to find RTS Labs' main website in Google Search
    Given the user is on the google search page
    When the user searches for "RTS Labs"
    And the user clicks on the first result
    Then the user should see the main page of the "RTS Labs" website