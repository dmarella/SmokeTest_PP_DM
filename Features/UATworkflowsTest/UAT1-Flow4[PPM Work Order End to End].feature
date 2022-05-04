@UAT1-Flow4 @E2E
Feature: SmokeTest
#E2E Scenario completed
  Scenario: Creat PPM
    #Given user log in to Maximo System
    Given  user log in to PreProduction Maximo System
    #Then user clicks on 'GOTO' button
    When Clicks on 'Preventive Maintenance'link
    Then user presents with Preventive Maintenance search page
    And user search for PM
    And user clickS on PM
    When user 'Set PM Count' to 0
    And user change the Estimated date in Frequency Tab
    Then user able to save the PM
    And user able to Generate the Work Orders
    And user Copy the PPM Work Order number
   #And user verifies the status of the newly created WorkOrder
    And user close the window
  @FSO
  Scenario: Verify the FSO Batch Run and WorkOrder updates visible in FSO
    Given user log in to FSO
    #Given  user log in to PreprodFSOinFF
    And user verify the location as set to 'Bristol'
    Then user clicks on 'Jobs' button and Enter PPM WorkOrderNumber
    #And user search for  Work Order
    And user search for  Work Order to assign the job
    #And user Assign the Job to the Engineer
    And user close the window

  @Maximo
  Scenario: Move WorkOrder to Completed Status
    #Given user log in to Maximo System
    Given  user log in to PreProduction Maximo System
    Then user verify the status of the PPMWorkOrder changes to 'Dispatch'
    And user search for PPMWorkOrder
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
    And user search for PPMWorkOrder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Travel'
    And user search for PPMWorkOrder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'on site'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Start'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'WOcomplete'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Completed'

  Scenario:   Move the WorkOrder to FINAPP status
    When user workflow the Workorder
    Then user have option to select Documentation checkbox
    When user workflow the Workorder
    Then user verified that the workorder status move to 'FINAPP'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'FINCOMP'
