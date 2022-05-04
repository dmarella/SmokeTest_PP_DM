package com.automation.stepDefinations;

import com.automationtest.base.Testbase;
import com.automationtest.pages.ActualsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ActivitySteps extends Testbase {
    ActualsPage actualsPage;

    public ActivitySteps() {
        super();
    }

    @When("^user navigate to Activity tab$")
    public void user_navigate_to_Activity_tab() throws Throwable {
        actualsPage = new ActualsPage();
        actualsPage.clickonActualsTab();

    }

    @When("^user access the Activity WorkOrder$")
    public void user_access_the_Activity_WorkOrder() throws Throwable {
        actualsPage.ClickonDetailMenuIcon();
        actualsPage.ActivitiesandTasks();

    }

    @Then("^user add the Actual Start and Finish dates$")
    public void user_add_the_Actual_Start_and_Finish_dates() throws Throwable {
        actualsPage.AddActualStartandFinishDates();


    }

    @Then("^user amend the Schedule Start and Finish dates$")
    public void user_amend_the_Schedule_Start_and_Finish_dates() throws Throwable {
        actualsPage.EditScheduleStartandFinishDates();
    }

    @Then("^user applies the 'mobileoverride' option to Activity WorkOrder$")
    public void user_applies_the_mobileoverride_option_to_Activity_WorkOrder() throws Throwable {
        actualsPage.ChooseMobileOverrideoption();
    }


}