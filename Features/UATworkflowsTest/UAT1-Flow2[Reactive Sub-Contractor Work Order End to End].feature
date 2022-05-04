@UAT1-Flow2 @E2E
Feature:UAT_Workflow
# Not done check document
  Scenario: Creating an new ServiceRequest
    #Given user log in to Maximo System
    Given user log in to PreProduction Maximo System
    Then user clicks on 'GOTO' button
    Then user clicks on 'Service Desk' link
    And user clicks on 'Service Requests(SP)' link
    Then user navigated to 'Service Requests(SP)' page
    And user clicks on plus button to create a new Service Request form
    And user fill the new Service Request form
      | Name       | Customer | Location | summary             | classification                               | details           | reportedByPhone | reportedByEmail   | customerReference | customerReference2 |
      | UAT Tester | C1000011 | L1001455 | UAT session1 -test2 | REACTIVE \ CLEANING \ CLEAN (HAZ) \ ASBESTOS | UAT seeion1-test2 | 07776023458     | uattest@email.com | 123               | 654321             |
    And user clicks on 'Save ServiceRequest' button
    And user copy the SR Number

  Scenario: Creating an WorkOrder
    Then user clicks on 'Route Workflow' button
    And user verifies the status of the newly created WorkOrder

  Scenario: Creating an PurchaseOrder
    Then user clicks on 'GOTO' button
    And user clicks on 'Purchasing' link
    And user clicks on 'Purchase Orders' link
    Then user clicks on plus button to create a new Purchase Order
    And user fill the new Purchase Order Details

  Scenario: Link WO and PO
    Then user click on 'POLines'Tab
    Then user add the NewRow
    And user fill the PurchaseOrder Lines
    Then user workflow the PurchaseOrder
    And user submit the PurchaseOrder for Approval process
    And user verify the status of the PurchaseOrder submitted

  Scenario: Receipt PO
    Then user navigate to 'Reciving' page
    And user search for PO
    #And user Receipt the PO

  Scenario: Add Vendor to WorkOrder
    And user search for POWorkOrder
    And user add the vendor details
    And user set the Actual Start Date for WorkOrder
    And user workflow the Workorder
    And user set the Actual Finish Date for WorkOrder
    And user workflow the Workorder


  Scenario:   Move the WorkOrder to FINAPP status
    When user workflow the Workorder
    #Then user verified that the workorder status move to 'WOcomplete'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Completed'
    When user workflow the Workorder
    Then user have option to select Documentation checkbox
    When user workflow the Workorder
    Then user verified that the workorder status move to 'FINAPP'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'FINCOMP'
