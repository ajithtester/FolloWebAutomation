Feature: To verify the Delivery request

  @DeliveryRequest   @SP4
  Scenario: To click All requests button from the menu
    Given User clicks All requests button from the menu

  @DeliveryRequest   @SP4
  Scenario: To click Delivery requests button from the menu
    Given User clicks Delivery requests button from the menu

  @DeliveryRequest @SP4
  Scenario: To add new delivery request
    Given User add new delivery request

  @DeliveryRequest @SP4
  Scenario: Search delivery request from the list
    Given User search and view the delivery request from the list

  @DeliveryRequest @SP4
  Scenario: Edit a delivery request from the list
    Given User edit a delivery request from the list

  @DeliveryRequest @SP4
  Scenario: Filter a delivery request from the list
    Given User filter the delivery request from the list

  @DeliveryRequest @SP4
  Scenario: User view and approve or reject the delivery request
    Given User view the request information
    And User add a comment to the request
    And User view the history of the request
    Then User deliver the request

  @DeliveryRequest @SP4
  Scenario: User view and approve or reject the delivery request
    Given User approve or reject the delivery request

  @DeliveryRequest @SP4
  Scenario: Push a delivery request to void
    Given User push a request to void
