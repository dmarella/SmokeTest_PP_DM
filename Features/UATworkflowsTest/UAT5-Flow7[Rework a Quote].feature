@UAT5-Flow7 @E2E
Feature:UAT_Workflow
#Notes: E2E scenario Not done , refer to document
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
      | UAT Tester | C1000007 | L1000537 | UAT session5 -test7 | QUOTE \ FABRIC \ QUOTE2 | Test7   | 012345852132    | uattest@email.com | 123               | 7345               |
    And user clicks on 'Save ServiceRequest' button
    And user verifies the status of the newly created ServiceRequest
    And user copy the SR Number

  Scenario: Creating an Quote
    Then user Workflow the ServiceRequest to create the Quote
    And user verifies the status of the newly created Quote

  Scenario: QM through Scoping
    Then user complete the QuoteManagment through Scoping
    And user Workflow the scoping section to Pricing section

  Scenario: Pricing Reviewing Quote
    Then user complete the pricing section
    And user workflow the quote
   #And user approve the quote
    #And user Reject the quote
    And user Review the quote

  Scenario:Rework back to price
    Then user workflow the quote
    And user Reject the scope
    Then user Amend scope and price

  Scenario:  Approve Quote
    And user workflow the quote
    And user approve the quote

  Scenario: Create WorkOrder
    And user verifies the new workorder created
    Then user returnto HomePage
    And user search for QuoteWorkOrder
    And user create Assignmentline for IntegnalEngineer
    And user clicks on 'Workflow' button

  Scenario: Move WorkOrder to Completed Status
    //Then user verify the status of the WorkOrder changes to 'Dispatch'
    And user search for QuoteWorkOrder
    And user set the Actual Start Date for WorkOrder
    And user set the Actual Finish Date for WorkOrder
    And user applies the 'mobileoverride' option to WorkOrder
    When user clicks on 'Actuals' tab
    Then user verifies that 'Actuals' session
    And user clicks on 'NewRow' button in labor section
    And user add the labor and shift details for Travel type
    When user clicks on Save button
    And user clicks on 'NewRow' button in labor section
    And user the labor and workstart and finish time for Work type
    When user clicks on Save button
    And user 'save' the Work Order
    And user search for QuoteWorkOrder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Travel'
    And user search for QuoteWorkOrder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'on site'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Start'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'WOcomplete'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Completed'

  Scenario:   Move the WorkOrder to FINCOMP status
    When user workflow the Workorder
    Then user have option to select Documentation checkbox
    When user workflow the Workorder
    Then user verified that the workorder status move to 'FINAPP'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'FINCOMP'

