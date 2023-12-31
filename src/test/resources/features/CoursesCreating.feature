Feature: creating a Course
  @coursesTest
  @regressionTest
  Scenario:
    Given the user is on Course page
    When the user clicks on Create  button
    And provides name,date, time
    And click on create
    Then verify that the Course has been successfully created

  @coursesTest
  @regressionTest
    Scenario:
      When the user clicks on Course options
      And clicks on Delete Course button
      And confirms deletion
      Then verify that the Course is successfully deleted