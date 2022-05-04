@UAT5-Flow8 @E2E
Feature: SmokeTest
#Notes: E2E scenario covered -Completly Done
  Scenario: Creating an new FMR
    Given user log in to Maximo System
    #Given user log in to PreProduction Maximo System
    Then user clicks on 'GOTO' button
    And  user clicks on ' WorkOrder'link
    When user clicks on ' Forward Maintenance Register' link
    Then Forward Maintenance Register page display
    And user fill the 'Forward Register Maintenance' page
      | Description | Customer | Location | OwnerGroup | EstimatedTotalPrice | CustomerReferenceNumber |
      | FMR Test    | C1000011 | L1001455 | FMRGRP     | 10000               | CUST1234                |
    When user clicks on 'Save' button
    Then user verifies that a new FMR created

  Scenario: Move the FMR to Quotation
    When user click on ' Move to Quation' button
    Then the FMR status change to 'Approved' from 'WAPPR'
    And a new Quote created under Associated Quotes section

  Scenario:Quotation Scoping and Pricing
    Then user search for the newly created Quote
    And user verifies the quote details are matching
    When user clicks on ' Scoping' Tab
    Then user verify that Scoping Page displays
    And user fill the required details in Scoping Page
    When user clicks on ' Pricing' Tab

  Scenario: place the quote on FMR
    Then user complete the pricing section
    And user place the quote on FMR
    And user verifies the quote status as 'Closed'

  Scenario:Verify the Quote placed back on FMR
    Then user copy the FMR Number
    And user veries that the new quote placed on FMR
    And user verifies the status of new FMR as 'WAPPR'


