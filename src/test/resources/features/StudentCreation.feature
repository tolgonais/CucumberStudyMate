Feature: Creating, editing and deleting a new Student
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


  @studentTest
  @regressionTest
    Scenario:
      When the user clicks on Student options
      And clicks on Edit student's info button
      And edits Student's email
      And clicks on Save button
      Then verify that the Student's email edited successfully

  @studentTest
  @regressionTest
    Scenario:
      When the user clicks on Student options
      And clicks on Delete student button
      And confirms deletion
      Then verify that the Student has been deleted successfully