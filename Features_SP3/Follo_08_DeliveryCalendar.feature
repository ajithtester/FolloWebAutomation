Feature: To verify the Delivery feature

  @DeliveryCalendar @Regression @SP4 @Error
  Scenario: To click Delivery calendar button from the menu
    Given User clicks delivery calendar button

  @DeliveryCalendar @Regression  
  Scenario: To add delivery
    Given User adds new delivery

  @DeliveryCalendar @Regression 
  Scenario: Search delivery request
    Given User search and view the delivery request

  @DeliveryCalendar @Regression 
  Scenario: Edit a delivery request
    Given User edit a delivery request
    
    @DeliveryCalendar @Regression @Error
  Scenario: Filter a delivery request
    Given User filter the delivery request based on company name

  @DeliveryCalendar @Regression @Error
  Scenario: User view and delivers the request
    Given User view the request info
    And User add a comment
    And User view history
    Then User delivers the request

  @DeliveryCalendar  @Regression  
  Scenario: User view and approve or reject the request
    Given User approve or reject the request

  @DeliveryCalendar @Regression  
  Scenario: Push a delivery request to void
    Given User push a delivery request to void


