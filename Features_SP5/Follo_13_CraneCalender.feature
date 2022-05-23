Feature: To verify the Crane calendar

  @CraneCalendar   
  Scenario: To click Crane calendar button from the menu
    Given User clicks Crane calendar button from the menu
    Then Crane calendar page should display

  @CraneCalendar  
  Scenario: To add new crane request
    Given User add new crane request

  @CraneCalendar  
  Scenario: User view Crane request information
    Given User view Crane request information

  @CraneCalendar  
  Scenario: Edit a Crane request from the list
    Given User edit a Crane request from the list

      @CraneCalendar 
  Scenario: Filter a Crane request from the list
    Given User filter the Crane request from the list