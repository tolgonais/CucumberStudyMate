Feature: successfully login to StudyMate
  @regressionTest
    @loginTest

  Scenario:
    Given the user is on login page
    When the user enters correct <admin@codewise.com> email
    And the user enters correct <codewise123> password
    And the user clicks on Login button
    Then verify the user logs in successfully