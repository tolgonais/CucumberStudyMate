Feature: creating, editing and deleting an event on Schedule page
  @scheduleTest
  @regressionTest
  Scenario:
    Given the user is on Schedule page
    When the user clicks on Create event button
    And provides date, time, name
    And chooses a group
    And clicks on Publish button
    Then verify that the event has been successfully created



      @scheduleTest
      @regressionTest
    Scenario:
    When the user clicks on created Event
    And clicks on Edit button
    And edits the day of Event
    And clicks on Publish button
    Then verify that the Event is now updated to the new date



  @scheduleTest
  @regressionTest
  Scenario:
    When the user clicks on edited Event
    And clicks on Delete button
    Then verify that the event is deleted

