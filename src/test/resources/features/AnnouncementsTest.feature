Feature: Announcement creation
  @announcementTest
    @regressionTest
  Scenario:
    Given the user is on the Announcements page
    When the user clicks on Add announcement button
    And provides the description of the Announcement
    And picks a group
    And clicks on Add announcement button
    Then verify that the announcement is successfully created