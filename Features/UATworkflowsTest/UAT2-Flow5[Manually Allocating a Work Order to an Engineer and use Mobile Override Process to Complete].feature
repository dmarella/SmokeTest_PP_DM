@UAT2-Flow5 @E2E
Feature:UAT_Workflow
#Notes: E2E scenario covered
  Scenario: Creating an new ServiceRequest
    #Given user log in to Maximo System
    Given user log in to PreProduction Maximo System
    Then user clicks on 'GOTO' button
    Then user clicks on 'Service Desk' link
    And user clicks on 'Service Requests(SP)' link
    Then user navigated to 'Service Requests(SP)' page
    And user clicks on plus button to create a new Service Request form
    And user fill the new Service Request form
      | Name       | Customer | Location | summary             | classification                                  | details           | reportedByPhone | reportedByEmail   | customerReference | customerReference2 |
      | UAT Tester | C1000011 | L1001455 | UAT session1 -test5 | REACTIVE \ BUILDING FABRIC \ GLAZING \ GLASSEXT | UAT seeion1-test5 | 07776023458     | uattest@email.com | 123               | 654321             |
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
    #And user search for  Work Order
    And user search for  Work Order to assign the job
    #And user Assign the Job to the Engineer
    And user close the window

  @Maximo
  Scenario: Move WorkOrder to Completed Status
    Given user log in to Maximo System
    #Given user log in to PreProduction Maximo System
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


  Scenario: Create Customer Billing
    When user search for Customer Billing page
    Then user clicks on + button to create a new Customer Billing
    And user enters all details in Customer Billing page and workflow
    When user select workorder and uncheck 'copy bill lines'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'FINCOMP'

  Scenario: Bill Review and Bill Batch Posted
    When user go to 'Bill Review' page and serach for Bill Batch
    Then user verifies that the status changed to Reviewed
    And user opens the Batch and Workflow
    And user verifies that the Bill batch status changes to Posted
