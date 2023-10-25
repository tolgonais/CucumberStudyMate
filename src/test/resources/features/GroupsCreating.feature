Feature: creating a Group



  @groupsTest

    Scenario:
    Given the user is on Group page
    When the user clicks on Create  button
    And provides name,date,discription
    And click on create
    Then verify that the Group has been successfully created