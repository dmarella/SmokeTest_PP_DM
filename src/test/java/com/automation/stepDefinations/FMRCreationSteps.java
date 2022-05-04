package com.automation.stepDefinations;

import com.automationtest.pages.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

public class FMRCreationSteps extends ForwardMainteananceRegisterPage {
    HomePage homePage;
    ServiceRequestPage serviceRequestPage;
    ForwardMainteananceRegisterPage forwardMainteananceRegisterPage;
    QuotePage quotePage;
    ScopingPage scopingPage;
    PricingPage pricingPage;
    private String[] QuoteNumber;
    private String[] FMR;

    public FMRCreationSteps() {
        super();
    }

    @Then("^user clicks on ' WorkOrder'link$")
    public void user_clicks_on_WorkOrder_link() throws Throwable {
        homePage = new HomePage();
        homePage.ClickonWorkOrderLink();

    }

    @When("^user clicks on ' Forward Maintenance Register' link$")
    public void user_clicks_on_Forward_Maintenance_Register_link() throws Throwable {
        homePage.ClickonForwardMaintananceLink();

    }

    @Then("^Forward Maintenance Register page display$")
    public void forward_Maintenance_Register_page_display() throws Throwable {
        forwardMainteananceRegisterPage = new ForwardMainteananceRegisterPage();
        forwardMainteananceRegisterPage.VeifytheForwardMainteananceRegisterPage();
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonNewServiceRequestPlusButton();
    }

    @Then("^user fill the 'Forward Register Maintenance' page$")
    public void user_fill_the_Forward_Register_Maintenance_page(DataTable FMRdata) throws Throwable {
        for (Map<String, String> data : FMRdata.asMaps(String.class, String.class)) {
            forwardMainteananceRegisterPage = new ForwardMainteananceRegisterPage();
            forwardMainteananceRegisterPage.EnterDescriptionDetails(data.get("Description"));
            forwardMainteananceRegisterPage.EnterCustomerReference(data.get("CustomerReferenceNumber"));
            forwardMainteananceRegisterPage.EnterCustomerDetails(data.get("Customer"));
            forwardMainteananceRegisterPage.EnterOwenerGroupDetails(data.get("OwnerGroup"));
            forwardMainteananceRegisterPage.EnterLocationDetails(data.get("Location"));
            forwardMainteananceRegisterPage.EnterEstimatedTotalPriceDetails(data.get("EstimatedTotalPrice"));
            forwardMainteananceRegisterPage.EnterlongDescription();

        }


    }

    @When("^user clicks on 'Save' button$")
    public void userClicksOnSaveButton() {
        forwardMainteananceRegisterPage.SavetheFMR();
    }

    @Then("^user verifies that a new FMR created$")
    public void user_verifies_that_a_new_FMR_created() throws Throwable {
        forwardMainteananceRegisterPage.FMRStatusWAPPR();

    }

    @When("^user click on ' Move to Quation' button$")
    public void userClickOnMoveToQuationButton() {
        forwardMainteananceRegisterPage = new ForwardMainteananceRegisterPage();
        forwardMainteananceRegisterPage.ClickonMovetoQuotationLink();
    }

    @Then("^the FMR status change to 'Approved' from 'WAPPR'$")
    public void theFMRStatusChangeToApprovedFromWAPPR() throws InterruptedException {
        forwardMainteananceRegisterPage.CopyFMRnumber();
        forwardMainteananceRegisterPage.SearchFMR(FMR);
    }

    @And("^a new Quote created under Associated Quotes section$")
    public void aNewQuoteCreatedUnderAssociatedQuotesSection() {
        forwardMainteananceRegisterPage.CopyQuoteNumber();
    }

    @Then("^user search for the newly created Quote$")
    public void userSearchForTheNewlyCreatedQuote() throws InterruptedException {
        homePage = new HomePage();
        homePage.ClickonGOTObutton();
        homePage.ClickonWorkOrderLink();
        homePage.CLickonQuoteManagementLink();
        forwardMainteananceRegisterPage = new ForwardMainteananceRegisterPage();
        forwardMainteananceRegisterPage.searchquote(QuoteNumber);
    }

    @And("^user verifies the quote details are matching$")
    public void userVerifiesTheQuoteDetailsAreMatching() {
        quotePage = new QuotePage();
        quotePage.VerifytheQuoteStatus();
        //quotePage.AddAttachment();
    }

    @When("^user clicks on ' Scoping' Tab$")
    public void userClicksOnScopingTab() throws InterruptedException {
        scopingPage = new ScopingPage();
        scopingPage.ClickonScopingTab();
    }

    @Then("^user verify that Scoping Page displays$")
    public void userVerifyThatScopingPageDisplays() {
    }

    @And("^user fill the required details in Scoping Page$")
    public void userFillTheRequiredDetailsInScopingPage() throws InterruptedException {
        scopingPage.FilltheTargetStartDate();
        scopingPage.Filltherequiredfields();
        scopingPage.FilltheTargetFinishDate();
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonWorkflowButton();
        scopingPage = new ScopingPage();
        scopingPage.MemoProceedtoPricing();
    }

    @When("^user clicks on ' Pricing' Tab$")
    public void userClicksOnPricingTab() throws InterruptedException {
        pricingPage = new PricingPage();
        pricingPage.ClickonPricingTab();
        scopingPage = new ScopingPage();
        scopingPage.MemoProceedtoPricing();

    }

    @And("^user place the quote on FMR$")
    public void userPlaceTheQuoteOnFMR() throws InterruptedException {
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonWorkflowButton();
        pricingPage = new PricingPage();
        pricingPage.SubmitQuote();
        serviceRequestPage = new ServiceRequestPage();
        serviceRequestPage.ClickonWorkflowButton();
        pricingPage = new PricingPage();
        pricingPage.PlaceonFMR();
    }

    @And("^user verifies the quote status as 'Closed'$")
    public void userVerifiesTheQuoteStatusAsClosed() {
        pricingPage = new PricingPage();
        pricingPage.VerifytheFMRStatusClosed();
    }

    @Then("^user copy the FMR Number$")
    public void userCopyTheFMRNumber() {
    }

    @And("^user veries that the new quote placed on FMR$")
    public void userVeriesThatTheNewQuotePlacedOnFMR() throws InterruptedException {
        homePage = new HomePage();
        homePage.ClickonGOTObutton();
        homePage.ClickonWorkOrderLink();
        homePage.ClickonForwardMaintananceLink();
        forwardMainteananceRegisterPage = new ForwardMainteananceRegisterPage();
        forwardMainteananceRegisterPage.SearchFMR(FMR);
    }


}

