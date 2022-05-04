package com.automation.stepDefinations;

import com.automationtest.base.Testbase;
import com.automationtest.pages.FSOPage;
import com.automationtest.pages.LoginPage;
import com.automationtest.pages.PreventiveMaintenancePage;
import com.automationtest.pages.WorkOrderPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FSOBatchSteps extends Testbase {
    FSOPage fsoPage;
    WorkOrderPage workOrderPage;
    PreventiveMaintenancePage preventiveMaintenancePage;
    LoginPage loginPage;
    private String[] WorkOrderNumber;
    private String[] WorkorderNumber;

    public FSOBatchSteps() {
        super();

    }

    @Given("^user log in to FSO$")
    public void userLogInToFSO() {
        Testbase.FSOintialization();
        fsoPage = new FSOPage();
        fsoPage.EnterFSOUserName(prop.getProperty("FSOUsername"));
        fsoPage.EnterFSOPassword(prop.getProperty("FSOPassword"));
        fsoPage.FSOlogin();
    }
    @Given("^user log in to PreprodFSOinFF$")
    public void userLogInToPreprodFSOinFF() throws InterruptedException {
        Testbase.FSOintialization();
        loginPage = new LoginPage();
        loginPage.PreProdLogin(prop.getProperty("Email"));
        loginPage.PreProdEnterUsernameforFirefox(prop.getProperty("Username"));
        loginPage.PreProdEnterPasswordforFirefox(prop.getProperty("PreprodFFPassword"));
        loginPage.PreProdEnterLoginforFirefox();

    }
    @When("^user Able to view and assign work to an Engineer$")
    public void userAbleToViewAndAssignWorkToAnEngineer() {
    }

    @Then("^user able view Work Order updates are visible in FSO$")
    public void userAbleViewWorkOrderUpdatesAreVisibleInFSO() {
    }

    @And("^user verify the location as set to 'Bristol'$")
    public void userVerifyTheLocationAsSetToBristol() throws InterruptedException {
        fsoPage.ChangethelocationtoBristol();
    }

    @Then("^user clicks on 'Jobs' button$")
    public void userClicksOnJobsButton() throws InterruptedException {
        fsoPage.searchforWorkOrder();
        fsoPage.clickonWorkOrderLink();
    }
    @Then("^user clicks on 'Jobs' button and Enter PPM WorkOrderNumber$")
    public void userClicksOnJobsButtonAndEnterPPMWorkOrderNumber() throws InterruptedException {
        fsoPage.searchforPPMWorkOrder();
        fsoPage.clickonWorkOrderLink();

    }
    @Then("^user clicks on 'Jobs' button and Enter Quote WorkOrderNumber$")
    public void userClicksOnJobsButtonAndEnterQuoteWorkOrderNumber() throws InterruptedException {
        fsoPage.searchforQuoteWorkOrder();
        fsoPage.clickonWorkOrderLink();


    }

    @And("^user search for  Work Order to assign the job$")
    public void userSearchForWorkOrderToAssignTheJob() throws InterruptedException {
        fsoPage.clickonAssignJobLink();
        fsoPage.assignjobandSave();

    }

    @And("^user Assign the Job to the Engineer$")
    public void userAssigntheJobtotheEngineer() throws InterruptedException {
        fsoPage.clickonAssignJobLink();
        fsoPage.EnterEngineerNumber();
        fsoPage.assignjobandSave();

    }

    @And("^user search for  Work Order$")
    public void userVerifiesThatTheJobAsDispatchedCorrectly() {
        workOrderPage = new WorkOrderPage();
        workOrderPage.searchWOinFSO(WorkOrderNumber);


    }


}



