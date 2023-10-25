Feature: creating an event on Schedule page
  @scheduleTest
  @regressionTest

  Scenario:
    Given the user is on Schedule page
    When the user clicks on Create event button
    And provides date, time, name
    And chooses a group
    And clicks on Publish button
    Then verify that the event has been successfully created