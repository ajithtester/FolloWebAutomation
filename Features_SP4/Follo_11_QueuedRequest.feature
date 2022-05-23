Feature: To verify the queued request

  @QueuedRequest @SP4
  Scenario: To click queued requests button from the menu
    Given User clicks queued requests button from the menu

  @QueuedRequest
  Scenario: Import Queued Request list
    Given User clicks queued request import button
    And User clicks browse files
    And User selects file to upload
    And User clicks the done button
    Then Queued request list from the excel should get added

  @QueuedRequest @SP4
  Scenario: Save a queued request from the list
    Given User save a queued request from the list

  @QueuedRequest @SP4
  Scenario: Delete a queued request from the list
    Given User deletes a queued request from the list

  @QueuedRequest @SP4
  Scenario: Search queued request from the list
    Given User search and view the queued request from the list

  @QueuedRequest @SP4
  Scenario: Filter a queued request from the list
    Given User filter the queued request from the list

  @QueuedRequest @SP4
  Scenario: Edit a queued request from the list
    Given User edit a queued request from the list
