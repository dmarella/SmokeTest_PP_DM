@UAT3-Flow2 @E2E
Feature:UAT_Workflow

  Scenario: Creating an new ServiceRequest
    Given user log in to Maximo System
    Then user clicks on 'GOTO' button
    Then user clicks on 'Service Desk' link
    And user clicks on 'Service Requests(SP)' link
    Then user navigated to 'Service Requests(SP)' page
    And user clicks on plus button to create a new Service Request form
    And user fill the new Service Request form
      | Name       | Customer | Location | summary             | classification                               | details            | reportedByPhone | reportedByEmail   | customerReference | customerReference2 |
      | UAT Tester | C1000011 | L1001455 | UAT session3 -test2 | REACTIVE \ CLEANING \ CLEAN (HAZ) \ ASBESTOS | UAT session3-test2 | 07776023458     | uattest@email.com | 123               | 654321             |
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

  Scenario: Add new plan for WorkOrder
    And user search for POWorkOrder
    And user Add the New Task for WorkOrder

  Scenario: New assignment line for Internal Engineer
    And user navigate to Assignment page
    And user add the 'Assignment' details to WO for InternalEngg
    #Then user amend the Start and Finish Schedule Date in Assignment scetion
    #And user add New assignmentline for Integrnal Engineer
  Scenario: Add vendor to work order
    And user add the vendor details to WorkOrder
    And user set the Actual Start Date for WorkOrder
    And user set the Actual Finish Date for WorkOrder
    And user applies the 'mobileoverride' option to WorkOrder
    Then user  select Documentation checkbox
    #And user clicks on 'NewRow' button in labor section
    #And user the labor and workstart and finish time for Work type
    #When user clicks on Save button
    #And user 'save' the Work Order
    #And user search for WorkOrder
    When user workflow the Workorder
    When user workflow the Workorder
    When user workflow the Workorder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Completed'

  Scenario: Progress the Subcontractor WorkOrder
    When user navigate to Activity tab
    And user access the Activity WorkOrder
    Then user add the Actual Start and Finish dates
    And user amend the Schedule Start and Finish dates
    And user applies the 'mobileoverride' option to Activity WorkOrder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'WaitingInSchedule
    #When user workflow the Workorder
    Then user verified that the workorder status move to 'Schedule' status
    When user workflow the Workorder
    And user returnto HomePage
    And user search for POWorkOrder
    When user navigate to Activity tab
    And user access the Activity WorkOrder
    And user returnto HomePage
    And user search for POWorkOrder
    When user navigate to Activity tab
    And user access the Activity WorkOrder
    When user workflow the Workorder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'on site'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Start'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'WOcomplete'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Completed'
    And user clickon Close Button
    And user returnto HomePage
    And user search for POWorkOrder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'FINAPP'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'FINCOMP'

  Scenario:Adding Labour and travel time in Actuals
    When user clicks on 'Actuals' tab
    #Then user verifies that 'Actuals' session
    And user clicks on 'NewRow' button in labor section
    And user add the labor and shift details for Travel type
    When user clicks on Save button
    And user clicks on 'NewRow' button in labor section
    And user add the labor and shift details for Onsite type
    When user clicks on Save button
    And user clicks on 'NewRow' button in labor section
    And user the labor and workstart and finish time for Work type
    When user clicks on Save button
    And user clicks on 'NewRow' button in labor section
    And user add the labor and shift details for WOCOMP type
    When user clicks on Save button











   # And user Navigate to the Activity WorkOrder