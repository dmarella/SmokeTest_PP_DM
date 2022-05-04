@UAT2-Flow4 @E2E
Feature:UAT_Workflow
#E2E NOT COMPLETED
  Scenario: Creating an new ServiceRequest
    Given user log in to Maximo System
    Then user clicks on 'GOTO' button
    Then user clicks on 'Service Desk' link
    And user clicks on 'Service Requests(SP)' link
    Then user navigated to 'Service Requests(SP)' page
    And user clicks on plus button to create a new Service Request form
    And user fill the new Service Request form
      | Name       | Customer | Location | summary             | classification                                  | details           | reportedByPhone | reportedByEmail   | customerReference | customerReference2 |
      | UAT Tester | C1000011 | L1001455 | UAT session2 -test4 | REACTIVE \ BUILDING FABRIC \ GLAZING \ GLASSEXT | UAT seeion2-test4 | 07776023458     | uattest@email.com | 123               | 654321             |
    And user clicks on 'Save ServiceRequest' button
    And user copy the SR Number

  Scenario: Creating an WorkOrder
    Then user clicks on 'Route Workflow' button
    And user verifies the status of the newly created WorkOrder
    And user close the window

  @FSO
  Scenario: Verify the FSO Batch Run and WorkOrder updates visible in FSO
    Given user log in to FSO
    And user verify the location as set to 'Bristol'
    Then user clicks on 'Jobs' button
    #And user search for  Work Order to assign the job
    And user Assign the Job to the Engineer
    And user close the window

  @Maximo
  Scenario: Move WorkOrder to Completed Status
    Given user log in to Maximo System
    Then user verify the status of the WorkOrder changes to 'Dispatch'
    And user search for WorkOrder
    And user set the Actual Start Date for WorkOrder
    And user set the Actual Finish Date for WorkOrder
    And user applies the 'mobileoverride' option to WorkOrder

  Scenario: Progress the WorkOrder
    And user search for WorkOrder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Travel'
    And user search for WorkOrder
    When user workflow the Workorder
    Then user verified that the workorder status move to 'on site'
    When user workflow the Workorder
    Then user verified that the workorder status move to 'Start'

  Scenario: Add New Task for 2nd Engineer
    And user search for WorkOrder
    And user Add the New Task for WorkOrder

  Scenario: Add New AssignmentLine for 2nd Engineer
    And user search for WorkOrder
    Then user navigate to Assignment page
    And user add the 'Assignment' details to WO for InternalEngg

  Scenario: Progress Second Engineer WorkOrder
    When user navigate to Activity tab
    And user access the Activity WorkOrder
    And user applies the 'mobileoverride' option to Activity WorkOrder
    Then user add the Actual Start and Finish dates
    And user amend the Schedule Start and Finish dates
    When user workflow the Workorder
    Then user verified that the workorder status move to 'WaitingInSchedule
    #When user workflow the Workorder
    #Then user verified that the workorder status move to 'Schedule' status
    When user workflow the Workorder
    And user returnto HomePage
    And user search for WorkOrder
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

  Scenario:Adding Labour and travel time in Actuals for first labor
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

  Scenario:Adding Labour and travel time in Actuals for second labor
    When user clicks on 'Actuals' tab
    #Then user verifies that 'Actuals' session
    And user clicks on 'NewRow' button in labor section
    And user add the Secondlabor and shift details for Travel type
    When user clicks on Save button
    And user clicks on 'NewRow' button in labor section
    And user add the Secondlabor and shift details for Onsite type
    When user clicks on Save button
    And user clicks on 'NewRow' button in labor section
    And user the Secondlabor and workstart and finish time for Work type
    When user clicks on Save button
    And user clicks on 'NewRow' button in labor section
    And user add the Secondlabor and shift details for WOCOMP type
    When user clicks on Save button
