Feature: User applying for a position on the website
  Scenario: Application process
    Given User navigates to the website
    Then Under careers selects South Africa
    Then click on the first available job
    Then click on apply
    Then input name, email and phone
    And validate the text