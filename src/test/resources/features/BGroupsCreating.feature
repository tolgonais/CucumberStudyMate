Feature: creating a Group



  @groupsTest
    @regressionTest

    Scenario:
    Given the user is on Group page
    When the user clicks on Create  button
    And provides name,date,discription
    And click on create Group
    Then verify that the Group has been successfully created