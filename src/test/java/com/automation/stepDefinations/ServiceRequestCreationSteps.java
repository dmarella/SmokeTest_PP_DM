package com.automation.stepDefinations;

import com.automationtest.base.Testbase;
import com.automationtest.pages.HomePage;
import com.automationtest.pages.ServiceRequestPage;
import com.automationtest.pages.WorkOrderPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ServiceRequestCreationSteps extends Testbase {
    HomePage homePage;
    ServiceRequestPage serviceRequestPage;
    WorkOrderPage workOrderPage;


    public ServiceRequestCreationSteps() {
        super();
    }

    @Then("^user clicks on 'GOTO' button$")
    public void user_clicks_on_GOTO_button() throws Throwable {
        homePage = new HomePage();
        homePage.ClickonGOTObutton();
    }

    @Then("^user clicks on 'Service Desk' link$")
    public void user_clicks_on_Service_Desk_link() throws Throwable {
        homePage.ClickonServiceDesklink();

    }

    @Then("^user clicks on 'Service Requests\\(SP\\)' link$")
    public void user_clicks_on_Service_Requests_SP_link() throws Throwable {
        homePage.ClickonServiceRequestsLink();

    }

    @Then("^user navigated to 'Service Requests\\(SP\\)' page$")
    public void user_navigated_to_Service_Requests_SP_page() throws Throwable {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.VerifyServiceRequestPage();
    }

    @Then("^user clicks on plus button to create a new Service Request form$")
    public void user_clicks_on_plus_button_to_create_a_new_Service_Request_form() throws Throwable {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonNewServiceRequestPlusButton();

    }

   /* @Then("^user fill the new Service Request form$")
    public void user_fill_the_new_Service_Request_form(DataTable ServiceRequestData) throws Throwable {
        for (Map<String, String> data : ServiceRequestData.asMaps(String.class, String.class)) {
            serviceRequestPage.EnterCustomer();
            serviceRequestPage.Enterlocation();
            serviceRequestPage.EnterName(data.get("Name"));
            serviceRequestPage.EnterSummary(data.get("summary"));
            serviceRequestPage.EnterClassification(data.get("classification"));
            serviceRequestPage.EnterDetails(data.get("details"));
            serviceRequestPage.EnterPhonenumber(data.get("reportedByPhone"));
            serviceRequestPage.EnterEmail(data.get("reportedByEmail"));
            serviceRequestPage.EnterCustomerReference(data.get("customerReference"));
            serviceRequestPage.EnterCustomerReference2(data.get("customerReference2"));


        }
    }*/

    @Then("^user clicks on 'Save ServiceRequest' button$")
    public void user_clicks_on_Save_ServiceRequest_button() throws Throwable {
        serviceRequestPage.ClickonSaveServiceRequest();

    }

    @Then("^user verifies the status of the newly created ServiceRequest$")
    public void user_verifies_the_status_of_the_newly_created_ServiceRequest() throws Throwable {
        //serviceRequestPage.VerifyServiceStatusasNEW();
        serviceRequestPage.ClickonWorkflowButton();

    }


    @And("^user fill the new Service Request form$")
    public void userFillTheNewServiceRequestFormForQuote(DataTable SData) throws InterruptedException {
        for (Map<String, String> data : SData.asMaps(String.class, String.class)) {
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            serviceRequestPage.EnterPhonenumber(data.get("reportedByPhone"));
            serviceRequestPage.EnterCustomerDetailsforQuote(data.get("Customer"));
            serviceRequestPage.EnterLocationDetailsforQuote(data.get("Location"));
            serviceRequestPage.EnterClassification(data.get("classification"));
            serviceRequestPage.clearReportedByField();
            serviceRequestPage.EnterCustomerReference(data.get("customerReference"));
            serviceRequestPage.EnterDetails(data.get("details"));
            serviceRequestPage.EnterName(data.get("Name"));
            serviceRequestPage.EnterSummary(data.get("summary"));
           // serviceRequestPage.EnterPhonenumber(data.get("reportedByPhone"));
            serviceRequestPage.EnterCustomerReference2(data.get("customerReference2"));
            serviceRequestPage.EnterEmail(data.get("reportedByEmail"));
            //Thread.sleep(1000);
        }
    }



    @And("^user copy the SR Number$")
    public void userCopyTheSRNumber() throws InterruptedException {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.CopySRnumber();
    }

    @When("^user clicks on 'Work' tab$")
    public void userClicksOnWorkTab() throws InterruptedException {
        serviceRequestPage = new ServiceRequestPage();
       // serviceRequestPage.AccepttheAlert();
        serviceRequestPage.ClickonWorkTab();
    }

    @Then("^user verify the 'WorkOrder'Number$")
    public void userVerifyTheWorkOrderNumber() throws IOException {
        workOrderPage = new WorkOrderPage();
        workOrderPage.ClickonExpandWorkOrder();
        workOrderPage.CopyWorkOrderNumber();
    }

    @And("^user clicks on 'Route Workflow' button and accept the alert$")
    public void userClicksOnRouteWorkflowButtonAndAcceptTheAlert() throws InterruptedException {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonWorkflowButton();
        serviceRequestPage.AccepttheAlert();
    }

    @And("^user clicks on 'Workflow' button$")
    public void userClicksOnWorkflowButton() throws InterruptedException {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.workflowbuttonclick();
        serviceRequestPage.AccepttheAlert();
    }
}
