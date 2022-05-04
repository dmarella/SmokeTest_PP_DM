package com.automation.stepDefinations;

import com.automationtest.base.Testbase;
import com.automationtest.pages.CustomerBillingPage;
import com.automationtest.pages.HomePage;
import com.automationtest.pages.ServiceRequestPage;
import com.automationtest.pages.WorkOrderPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerBillingSteps extends Testbase {
    WorkOrderPage workOrderPage;
    ServiceRequestPage serviceRequestPage;
    HomePage homePage;
    CustomerBillingPage customerBillingPage;
    private String[] WorkOrderNumber;
    private String[] BillBatchNO;

    public CustomerBillingSteps() {
        super();
    }

    @And("^user set the Actual Start Date for WorkOrder$")
    public void userSetTheActualStartDateForWorkOrder() throws InterruptedException {
        workOrderPage = new WorkOrderPage();
        workOrderPage.enterActualStartDate();
    }

    @And("^user set the Actual Finish Date for WorkOrder$")
    public void userSetTheActualFinishDateForWorkOrder() throws InterruptedException {
        workOrderPage = new WorkOrderPage();
        workOrderPage.enterActualFinishDate();
    }

    @Then("^user applies the 'mobileoverride' option to WorkOrder$")
    public void user_applies_the_mobileoverride_option_to_WorkOrder() throws Throwable {
        workOrderPage = new WorkOrderPage();
        workOrderPage.checkMobileOverRideCheckbox();
        workOrderPage.entertheMobileOverrideReason();
        workOrderPage.clickonSavebutton();

    }

    @Then("^user  select Documentation checkbox$")
    public void userselectDocumentationcheckbox() throws InterruptedException {
        workOrderPage = new WorkOrderPage();
        workOrderPage.enterDocumentRequired();

    }

    @And("^user 'save' the Work Order$")
    public void userSaveTheWorkOrder() {
        workOrderPage.clickonSavebutton();
    }

    @Then("^user verified that the workorder status move to 'on site'$")
    public void user_verified_that_the_workorder_status_move_to_on_site() throws Throwable {
        workOrderPage = new WorkOrderPage();
        workOrderPage.clickonOKbutton();

    }

    @Then("^user verified that the workorder status move to 'WOcomplete'$")
    public void user_verified_that_the_workorder_status_move_to_WOcomplete() throws Throwable {
        workOrderPage.clickonOKbutton();
    }

    @Then("^user verified that the workorder status move to 'Completed'$")
    public void user_verified_that_the_workorder_status_move_to_Completed() throws Throwable {
        Thread.sleep(1000);
        workOrderPage = new WorkOrderPage();
        workOrderPage.clickonOKbutton();
    }

    @Then("^user verified that the workorder status move to 'Travel'$")
    public void userVerifiedThatTheWorkorderStatusMoveToTravel() throws InterruptedException {
        workOrderPage = new WorkOrderPage();
        workOrderPage.clickonOKbutton();
    }

    @Then("^user verified that the workorder status move to 'Start'$")
    public void userVerifiedThatTheWorkorderStatusMoveToStart() throws InterruptedException {
        workOrderPage = new WorkOrderPage();
        workOrderPage.clickonOKbutton();
    }
    @Then ("^user return the WorkOrder$")
    public void userreturntheWorkOrder() throws InterruptedException {
        workOrderPage.ClickonReturnWorkOrderRadioButton();
        workOrderPage.clickonOKbutton();
        workOrderPage.clickonCloseButton();
        workOrderPage.SelectReturnStatusField();
    }

    @Then("^user have option to select Documentation checkbox$")
    public void user_have_option_to_select_Documentation_checkbox() throws Throwable {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.AccepttheAlert();
        workOrderPage = new WorkOrderPage();
        workOrderPage.enterDocumentRequired();
    }

    @Then("^user verified that the workorder status move to 'FINAPP'$")
    public void user_verified_that_the_workorder_status_move_to_FINAPP() throws Throwable {
    }

    @Then("^user verified that the workorder status move to 'FINCOMP'$")
    public void user_verified_that_the_workorder_status_move_to_FINCOMP() throws Throwable {
        workOrderPage.clickonOKbutton();
    }

    @When("^user search for Customer Billing page$")
    public void userSearchForCustomerBillingPage() throws InterruptedException {
        homePage = new HomePage();
        homePage.searchforCustomerBilling();

    }

    @Then("^user clicks on \\+ button to create a new Customer Billing$")
    public void userClicksOnButtonToCreateANewCustomerBilling() throws InterruptedException {
        customerBillingPage = new CustomerBillingPage();
        customerBillingPage.clickonPlusButtontoCreateNewBillBatch();

    }

    @And("^user enters all details in Customer Billing page and workflow$")
    public void userEntersAllDetailsInCustomerBillingPageAndWorkflow() throws InterruptedException {
        customerBillingPage.CopyBillBatchNumber();
        customerBillingPage.enterDescription();
        customerBillingPage.enterCustomerField();
        customerBillingPage.enterEndBillDate();
        customerBillingPage.enterAgreement();

    }

    @When("^user select workorder and uncheck 'copy bill lines'$")
    public void userSelectWorkorderAndUncheckCopyBillLines() throws InterruptedException {
        customerBillingPage.clickonSelectWorkOrdersButton();
        workOrderPage = new WorkOrderPage();
        workOrderPage.entertheWorkOrderNumber(WorkOrderNumber);
        customerBillingPage = new CustomerBillingPage();
        customerBillingPage.uncheckCopyBillLines();
        customerBillingPage.clickonOKbutton();

    }

    @When("^user go to 'Bill Review' page and serach for Bill Batch$")
    public void userGoToBillReviewPageAndSerachForBillBatch() throws InterruptedException {
        homePage = new HomePage();
        homePage.searchforBillReview();
        customerBillingPage = new CustomerBillingPage();
        customerBillingPage.enterBillBatchNumber(BillBatchNO);
        customerBillingPage.clickonBillBatchLink();
    }



    }

