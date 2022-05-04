package com.automation.stepDefinations;

import com.automationtest.base.Testbase;
import com.automationtest.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WorkOrderCreationSteps extends Testbase {
    HomePage homePage;
    ServiceRequestPage serviceRequestPage;
    WorkOrderPage workOrderPage;
    PreventiveMaintenancePage preventiveMaintenancePage;
    AssignmentsPage assignmentsPage;
    PricingPage pricingPage;
    ActualsPage actualsPage;
    PlansPage plansPage;
    private String[] WorkOrderNumber;
    private String[] WorkorderNumber;
    private String[] WONumber;

    public WorkOrderCreationSteps() {
        super();
    }

    @Then("^user clicks on 'Route Workflow' button$")
    public void user_clicks_on_Route_Workflow_button() throws Throwable {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonWorkflowButton();
        //serviceRequestPage.AccepttheAlert();
        serviceRequestPage.ClickonWorkTab();


    }

    @Then("^user verifies the status of the newly created WorkOrder$")
    public void user_verifies_the_status_of_the_newly_created_WorkOrder() throws Throwable {
        //serviceRequestPage.VerifyServiceStatusasQUEUED();
        workOrderPage = new WorkOrderPage();
        workOrderPage.ClickonWorkTab();
        workOrderPage.ClickonExpandWorkOrder();
        workOrderPage.CopyWorkOrderNumber();
        // workOrderPage.searchWO(WorkOrderNumber);
    }

    @And("^user Copy the PPM Work Order number$")
    public void user_Copy_The_PPM_Work_Order_Number() throws Throwable {
        preventiveMaintenancePage = new PreventiveMaintenancePage();
        preventiveMaintenancePage.copyworkOrderNumber();
    }

    @And("^user close the window$")
    public void userCloseTheWindow() throws InterruptedException {
        Testbase.cleanUp();
    }

    @And("^user add the labour details in 'Assignment' section$")
    public void userAddTheLabourDetailsInAssignmentSection() throws InterruptedException {
        preventiveMaintenancePage = new PreventiveMaintenancePage();
        preventiveMaintenancePage.clickonAssignmentTab();
        preventiveMaintenancePage.enterLabourNumber();

    }

    @And("^user 'Save' and 'Workflow' the 'WorkOrder'$")
    public void userSaveAndWorkflowTheWorkOrder() throws InterruptedException {
        preventiveMaintenancePage.workflow();


    }

    @And("^user search for WorkOrder$")
    public void userSearchForWorkOrder() throws InterruptedException {
        homePage = new HomePage();
        homePage.searchforWorkOrder();
        workOrderPage = new WorkOrderPage();
        workOrderPage.searchandClickonWO();
    }

    @And("^user search for QuoteWorkOrder$")
    public void userSearchForQuoteWorkOrder() throws InterruptedException {
        homePage = new HomePage();
        homePage.searchforWorkOrder();
        workOrderPage = new WorkOrderPage();
        workOrderPage.searchandClickonQuoteWO();
    }

    @And("^user search for PPMWorkOrder$")
    public void userSearchForPPMWorkOrder() throws InterruptedException {
        homePage = new HomePage();
        homePage.searchforWorkOrder();
        workOrderPage = new WorkOrderPage();
        workOrderPage.searchandClickonPPMWO();
    }

    @And("^user search for POWorkOrder$")
    public void usersearchforPOWorkOrder() throws InterruptedException {
        homePage = new HomePage();
        homePage.searchforWorkOrder();
        workOrderPage = new WorkOrderPage();
        workOrderPage.searchandClickonPOWO();
    }

    @Then("^user verify the status of the WorkOrder changes to 'Dispatch'$")
    public void userVerifyTheStatusOfTheWorkOrderChangesToDispatch() throws InterruptedException {
        homePage = new HomePage();
        homePage.searchforWorkOrder();
        workOrderPage = new WorkOrderPage();
        workOrderPage.searchandClickonWO();
        //workOrderPage.searchandClickonWO(WorkOrderNumber);
    }

    @Then("^user verify the status of the QuoteWorkOrder changes to 'Dispatch'$")
    public void userVerifyTheStatusOfTheQuoteWorkOrderChangesToDispatch() throws InterruptedException {
        homePage = new HomePage();
        homePage.searchforWorkOrder();
        workOrderPage = new WorkOrderPage();
        workOrderPage.searchandClickonQuoteWO();
        //workOrderPage.searchandClickonWO(WorkOrderNumber);
    }

    @Then("^user verify the status of the PPMWorkOrder changes to 'Dispatch'$")
    public void userVerifyTheStatusOfThePPMWorkOrderChangesToDispatch() throws InterruptedException {
        homePage = new HomePage();
        homePage.searchforWorkOrder();
        workOrderPage = new WorkOrderPage();
        workOrderPage.searchandClickonPPMWO();
        //workOrderPage.searchandClickonWO(WorkOrderNumber);
    }

    @When("^user workflow the Workorder$")
    public void userWorkflowTheWorkorder() throws InterruptedException {
        workOrderPage = new WorkOrderPage();
        workOrderPage.clickonWorkflowButton();

    }

    @And("^user add the vendor details$")
    public void useraddthevendordetails() throws InterruptedException {
        workOrderPage = new WorkOrderPage();
        workOrderPage.AddVendorDetails();
        workOrderPage.clickonWorkflowButton();
        workOrderPage.ClickonCloseButton();


    }
    @And("^user add the vendor details to WorkOrder$")
    public void useraddthevendordetailstoWorkOrder() throws InterruptedException {
        workOrderPage = new WorkOrderPage();
        workOrderPage.WorkOrderTab();
        workOrderPage.AddVendorDetails();
        workOrderPage.clickonWorkflowButton();
        workOrderPage.ClickonCloseButton();


    }


    @And("^user select the MaterialRequiredbutton$")
    public void userselecttheMaterialRequiredbutton() throws InterruptedException {
        workOrderPage.ClickonMaterialRequiredRadioButton();
        workOrderPage.clickonOKbutton();
    }

    @Then ("^user returnto HomePage$")
    public void userreturntoHomePage(){
        workOrderPage = new WorkOrderPage();
        workOrderPage.ClickonReturnTab();
    }

    @And ("^user create Assignmentline for IntegnalEngineer$")
    public void usercreateAssignmentlineforIntegnalEngineer() throws InterruptedException {
        assignmentsPage = new AssignmentsPage();
        assignmentsPage.clickonAssignmentsTab();
        assignmentsPage.ClickonNewRowButton();
        assignmentsPage.EnterCraft();
        assignmentsPage.EnterLabourNumber();

    }
    @And ("^user Add the New Task for WorkOrder$")
    public void userAddtheNewTaskforWorkOrder() throws InterruptedException {
        plansPage = new PlansPage();
        plansPage.clickonPlansTab();
        plansPage.clickonNewRowforPlans();
        plansPage.AddSummary();
        plansPage.AddDuration();
        plansPage.ClickonSaveButton();

    }

    @And ("^user Navigate to the Activity WorkOrder$")
    public void userNavigatetotheActivityWorkOrder() throws InterruptedException{
        actualsPage = new ActualsPage();
        actualsPage.clickonActualsTab();
        actualsPage.ClickonDetailMenuIcon();
        actualsPage.ActivitiesandTasks();

    }

    @Then("^user verified that the workorder status move to 'WaitingInSchedule$")
    public void userVerifiedThatTheWorkorderStatusMoveToWaitingInSchedule() throws InterruptedException {
        workOrderPage = new WorkOrderPage();
        workOrderPage.clickonOKbutton();
    }

    @Then("^user verified that the workorder status move to 'Schedule' status$")
    public void userVerifiedThatTheWorkorderStatusMoveToScheduleStatus() throws InterruptedException {
        workOrderPage = new WorkOrderPage();
        workOrderPage.WorkOrderTab();
        workOrderPage.clickonWorkflowButton();
       workOrderPage.CloseButtonissue();

    }
    @And ("^user clickon Close Button$")
    public void userclickonCloseButton(){
        workOrderPage = new WorkOrderPage();
        workOrderPage.CloseButtonissue();

    }

    @And("^user add the DurationTime in to Workorder$")
    public void userAddTheDurationTimeInToWorkorder() throws InterruptedException {
        workOrderPage.EnterDuration();
    }
}