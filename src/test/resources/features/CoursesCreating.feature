Feature: creating a Course
  @loginTest
  @groupTest
  Scenario:
    Given the user is on Course page
    When the user clicks on Create  button
    And provides name,date, time
    And click on create
    Then verify that the Course has been successfully created