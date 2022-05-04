package com.automation.stepDefinations;

import com.automationtest.base.Testbase;
import com.automationtest.pages.ActualsPage;
import com.automationtest.pages.HomePage;
import com.automationtest.pages.LaborReportingPage;
import com.automationtest.pages.WorkOrderPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ActualsSteps extends Testbase {
    WorkOrderPage workOrderPage;
    ActualsPage actualsPage;
    HomePage homePage;
    LaborReportingPage laborReportingPage;
    private String[] WorkOrderNumber;

    public ActualsSteps() {
        super();
    }


    @When("^user clicks on 'Actuals' tab$")
    public void userClicksOnActualsTab() {
        actualsPage = new ActualsPage();
        actualsPage.clickonActualsTab();

    }


    @And("^user add the labor and shift details for Travel type$")
    public void userAddTheLaborAndShiftDetailsForTravelType() throws InterruptedException {
        actualsPage.selectTravelType();
        actualsPage.enterLaborNumber();
        actualsPage.enterStartTimeforTravel();
        actualsPage.enterEndTimeforTravel();
        actualsPage.enterStartDate();
        actualsPage.enterFinishDate();


    }
    @And("^user add the Secondlabor and shift details for Travel type$")
    public void userAddTheSecondLaborAndShiftDetailsForTravelType() throws InterruptedException {
        actualsPage.selectTravelType();
        actualsPage.enterSecondLaborNumber();
        actualsPage.enterStartTimeforTravel();
        actualsPage.enterEndTimeforTravel();
        actualsPage.enterStartDate();
        actualsPage.enterFinishDate();


    }

    @And("^user the labor and workstart and finish time for Work type$")
    public void userTheLaborAndWorkstartAndFinishTimeForWorkType() throws InterruptedException {
      actualsPage.selectWorkType();
      actualsPage.enterLaborNumber();
      actualsPage.enterStartTimeforWork();
      actualsPage.enterEndTimeforWork();

    }

    @And("^user the Secondlabor and workstart and finish time for Work type$")
    public void usertheSecondLaborAndWorkstartAndFinishTimeForWorkType() throws InterruptedException {
        actualsPage.selectWorkType();
        actualsPage.enterSecondLaborNumber();
        actualsPage.enterStartTimeforWork();
        actualsPage.enterEndTimeforWork();

    }
    @And("^user add the labor and shift details for Onsite type$")
    public void userAddTheLaborAndShiftDetailsForOnsiteType() throws InterruptedException {
        actualsPage.selectonsiteType();
        actualsPage.enterLaborNumber();
        actualsPage.enterStartTimeforOnsite();
        actualsPage.enterEndTimeforOnsite();
    }

    @And("^user add the Secondlabor and shift details for Onsite type$")
    public void userAddtheSecondLaborAndShiftDetailsForOnsiteType() throws InterruptedException {
        actualsPage.selectonsiteType();
        actualsPage.enterSecondLaborNumber();
        actualsPage.enterStartTimeforOnsite();
        actualsPage.enterEndTimeforOnsite();
    }

    @And("^user add the labor and shift details for WOCOMP type$")
    public void useraddtheLaborAndShiftDetailsForWOCOMPType() throws InterruptedException {
        actualsPage.selectwocompType();
        actualsPage.enterLaborNumber();
        actualsPage.enterStartTimeforWoComp();
        actualsPage.enterEndTimeforWoComp();
    }

    @And("^user add the Secondlabor and shift details for WOCOMP type$")
    public void useraddtheSecondLaborAndShiftDetailsForWOCOMPType() throws InterruptedException {
        actualsPage.selectwocompType();
        actualsPage.enterSecondLaborNumber();
        actualsPage.enterStartTimeforWoComp();
        actualsPage.enterEndTimeforWoComp();
    }

    @When("^user clicks on Save button$")
    public void userClicksOnSaveButton() throws InterruptedException {
        actualsPage.clickonSaveButton();
        Thread.sleep(3000);

    }

    @Then("^user verifies that the Actuals are added$")
    public void userVerifiesThatTheActualsAreAdded() {
    }

    @And("^user veries that labor against the Workorder in Labor Reports$")
    public void userVeriesThatLaborAgainstTheWorkorderInLaborReports() throws InterruptedException {
        homePage = new HomePage();
        homePage.searchforLaborReporting();
        laborReportingPage = new LaborReportingPage();
        laborReportingPage.clickonAdvancedSearchButton();
        laborReportingPage.searchWO(WorkOrderNumber);

    }

    @And("^user clicks on 'NewRow' button in labor section$")
    public void userClicksOnNewRowButtonInLaborSection() {
        actualsPage.clickonNewRow();
    }
}
