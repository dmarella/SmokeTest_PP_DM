package com.automation.stepDefinations;

import com.automationtest.base.Testbase;
import com.automationtest.pages.PricingPage;
import com.automationtest.pages.QuotePage;
import com.automationtest.pages.ScopingPage;
import com.automationtest.pages.ServiceRequestPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.io.IOException;

public class QuoteCreationSteps extends Testbase {
    ServiceRequestPage serviceRequestPage;
    QuotePage quotePage;
    ScopingPage scopingPage;
    PricingPage pricingPage;

    public QuoteCreationSteps() {
        super();
    }

    @Then("^user Workflow the ServiceRequest to create the Quote$")
    public void user_Workflow_the_ServiceRequest_to_create_the_Quote() throws Throwable {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.DoubleClickonWorkflowButton();
        serviceRequestPage.AccepttheAlert();
        serviceRequestPage.ClickonWorkTab();


    }

    @Then("^user verifies the status of the newly created Quote$")
    public void user_verifies_the_status_of_the_newly_created_Quote() throws Throwable {
        quotePage = new QuotePage();
        quotePage.ClicktoExpandQuote();
        quotePage.ClickonGnerateQuoteManagerLink();

    }

    @Then("^user complete the QuoteManagment through Scoping$")
    public void userCompleteTheQuoteManagmentThroughScoping() throws InterruptedException {
        scopingPage = new ScopingPage();
        scopingPage.ClickonScopingTab();
        scopingPage.CopyQuoteNumber();
        scopingPage.Filltherequiredfields();
        serviceRequestPage = new ServiceRequestPage();
        //serviceRequestPage.ClickonSaveServiceRequest();
        serviceRequestPage.ClickonWorkflowButton();

    }

    @And("^user Workflow the scoping section to Pricing section$")
    public void userWorkflowTheScopingSectionToPricingSection() throws InterruptedException {
        scopingPage = new ScopingPage();
        scopingPage.MemoProceedtoPricing();
        pricingPage = new PricingPage();
        pricingPage.ClickonPricingTab();


    }

    @Then("^user complete the pricing section$")
    public void userCompleteThePricingSection() throws InterruptedException {
        pricingPage = new PricingPage();
        pricingPage.FillthePricingSection();
        pricingPage.EnterCalculationPercentageDetails();
        pricingPage.PropsedFinishDate();
        pricingPage.EnterPricingDetials();
        pricingPage.FilltheDates();
        pricingPage.ApprovalRequiredDate();
    }

    @And("^user approve the quote$")
    public void userApproveTheQuote() throws InterruptedException {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonWorkflowButton();
        pricingPage = new PricingPage();
        pricingPage.SubmitQuote();
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonWorkflowButton();
        pricingPage = new PricingPage();
        pricingPage.ApproveQuote();
    }

    @And("^user Reject the quote$")
    public void userRejectTheQuote() throws InterruptedException {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonWorkflowButton();
        pricingPage.SubmitQuote();
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonWorkflowButton();
        pricingPage = new PricingPage();
        pricingPage.RejectQuote();
    }

    @And("^user Review the quote$")
    public void userReviewTheQuote() throws InterruptedException {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonWorkflowButton();
        pricingPage.SubmitQuote();
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonWorkflowButton();
        pricingPage = new PricingPage();
        pricingPage.ReviewQuote();
    }

    @And("^user Reject the scope$")
    public void userRejectthescope() throws InterruptedException {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonWorkflowButton();
        pricingPage = new PricingPage();
        pricingPage.RejectScope();
    }

    @And("^user Amend scope and price$")
    public void userAmendscopeandprice() throws InterruptedException {
        scopingPage = new ScopingPage();
        scopingPage.ChangetheDescription();
        scopingPage.DescrptionfieldRewrite();
        scopingPage = new ScopingPage();
        scopingPage.ClickonScopingTab();
        scopingPage.Filltherequiredfields();
        serviceRequestPage = new ServiceRequestPage();
        //serviceRequestPage.ClickonSaveServiceRequest();
        serviceRequestPage.ClickonWorkflowButton();
        scopingPage = new ScopingPage();
        scopingPage.MemoProceedtoPricing();
        pricingPage = new PricingPage();
        pricingPage.ClickonPricingTab();
        pricingPage.ReEnterPricingDetials();


    }

    @And("^user verifies the new workorder created$")
    public void userVerifiesTheNewWorkorderCreated() throws InterruptedException, IOException {
        pricingPage = new PricingPage();
        pricingPage.CopyQuoteWorkOrderNumber();
        //pricingPage.clickonOK();
    }

    @And("^user workflow the quote$")
    public void userWorkflowTheQuote() throws InterruptedException {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonWorkflowButton();
    }

    @And("^user Save the Quote$")
    public void userSaveTheQuote() {
        pricingPage = new PricingPage();
        pricingPage.ClickonSave();
    }
}
