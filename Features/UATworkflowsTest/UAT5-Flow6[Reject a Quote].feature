@UAT5-Flow6 @E2E
Feature:UAT_Workflow
#Notes: E2E scenario covered  , Need to write coding for reject checkbox
  Scenario: Creating an new ServiceRequest
    Given user log in to Maximo System
    #Given user log in to PreProduction Maximo System
    Then user clicks on 'GOTO' button
    Then user clicks on 'Service Desk' link
    And user clicks on 'Service Requests(SP)' link
    Then user navigated to 'Service Requests(SP)' page
    And user clicks on plus button to create a new Service Request form
    And user fill the new Service Request form
      | Name       | Customer | Location | summary             | classification          | details | reportedByPhone | reportedByEmail   | customerReference | customerReference2 |
      | UAT Tester | C1000007 | L1000537 | UAT session5 -test5 | QUOTE \ FABRIC \ QUOTE2 | Test6   | 012345852132    | uattest@email.com | 123               | 7345               |
    And user clicks on 'Save ServiceRequest' button
    And user verifies the status of the newly created ServiceRequest
    And user copy the SR Number

  Scenario: Creating an Quote
    Then user Workflow the ServiceRequest to create the Quote
    And user verifies the status of the newly created Quote

  Scenario: QM through Scoping
    Then user complete the QuoteManagment through Scoping
    And user Workflow the scoping section to Pricing section

  Scenario:  Rejecting Quote
    Then user complete the pricing section
    And user workflow the quote
   # And user approve the quote
    And user Reject the quote
    And user verifies the new quote closed status
