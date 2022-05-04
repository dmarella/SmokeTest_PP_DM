@UAT2-Flow1 @E2E
Feature:UAT_Workflow
#E2E NOT COMPLETED
  Scenario: Creating an new ServiceRequest
    Given user log in to Maximo System
    #Given user log in to PreProduction Maximo System
    Then user clicks on 'GOTO' button
    Then user clicks on 'Service Desk' link
    And user clicks on 'Service Requests(SP)' link
    Then user navigated to 'Service Requests(SP)' page
    And user clicks on plus button to create a new Service Request form
    And user fill the new Service Request form
      | Name       | Customer | Location | summary             | classification                               | details           | reportedByPhone | reportedByEmail   | customerReference | customerReference2 |
      | UAT Tester | C1000011 | L1001455 | UAT session2 -test1 | REACTIVE \ BUILDING FABRIC \ PAINTDEC \ DAMP | UAT seeion2-test1 | 07776023458     | uattest@email.com | 123               | 654321             |
    And user clicks on 'Save ServiceRequest' button
    And user copy the SR Number

  Scenario: Creating an WorkOrder
    Then user clicks on 'Route Workflow' button
    And user verifies the status of the newly created WorkOrder
    And user close the window

  @FSO
  Scenario: Verify the FSO Batch Run and WorkOrder updates visible in FSO
    Given user log in to FSO
    #Given user log in to PreprodFSOinFF
    And user verify the location as set to 'Bristol'
    Then user clicks on 'Jobs' button
    And user search for  Work Order to assign the job
    And user close the window

  @Maximo
  Scenario: Move WorkOrder to Completed Status
    Given user log in to Maximo System
    Then user verify the status of the WorkOrder changes to 'Dispatch'
    And user search for WorkOrder
    And user set the Actual Start Date for WorkOrder
    And user set the Actual Finish Date for WorkOrder
    And user applies the 'mobileoverride' option to WorkOrder
    When user clicks on 'Actuals' tab
    Then user verifies that 'Actuals' session
    And user clicks on 'NewRow' button in labor section
    And user add the labor and shift details for Travel type
    When user clicks on Save button
    #And user clicks on 'NewRow' button in labor section
    #And user the labor and workstart and finish time for Work type
    #When user clicks on Save button
    And user 'save' the Work Order
    And user search for WorkOrder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Travel'
    And user search for WorkOrder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'on site'
    And user search for WorkOrder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Start'
    And user search for WorkOrder
    When user workflow the Workorder
    Then user return the WorkOrder
    When user workflow the Workorder
    And user search for WorkOrder
    When user workflow the Workorder
    And user select the MaterialRequiredbutton

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

  #Scenario: Receipt PO
   # Then user navigate to 'Reciving' page
   # And user search for PO
    #And user Receipt the PO

  Scenario: Add Vendor to WorkOrder
    And user search for POWorkOrder
    And user add the vendor details
    And user set the Actual Start Date for WorkOrder
    And user workflow the Workorder
    And user set the Actual Finish Date for WorkOrder
   # And user workflow the Workorder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Travel'
    And user search for WorkOrder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'on site'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Start'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'WOcomplete'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Completed'
