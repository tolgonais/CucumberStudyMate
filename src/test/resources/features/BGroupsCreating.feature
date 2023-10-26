Feature: creating a Group



  @groupsTest
    @regressionTest

    Scenario:
    Given the user is on Group page
    When the user clicks on Create  button
    And provides name,date,discription
    And click on create Group
    Then verify that the Group has been successfully created

  @groupsTest
  @regressionTest
    Scenario:
      When the user clicks on Group options button
      And clicks on Delete Group button
      And confirms deletion
      Then verify that the group is successfully deleted