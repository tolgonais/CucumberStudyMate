Feature: Creating a new Student
  @studentTest
  @regressionTest

  Scenario:
    Given the user is on Student page
    When the user clicks on Add Student button
    And the user provides first name, last name, phone number and email
    And selects group
    And selects study format
    And clicks on Add button
    Then verify that new student is created