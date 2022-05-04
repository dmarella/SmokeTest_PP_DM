package com.automation.stepDefinations;

import com.automationtest.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.io.IOException;

public class PurchaseOrderCreationSteps extends WorkOrderPage {
    HomePage homePage;
    ServiceRequestPage serviceRequestPage;
    WorkOrderPage workOrderPage;
    PurchaseOrderPage purchaseOrderPage;
    PurchaseOrderLinesPage purchaseOrderLinesPage;
    private String[] PO;

    public PurchaseOrderCreationSteps() {
        super();
    }

    @Then("^user clicks on 'Purchasing' link$")
    public void user_clicks_on_Purchasing_link() throws Throwable {
        purchaseOrderPage = new PurchaseOrderPage();
        purchaseOrderPage.ClickonPuchaseOrderLink();

    }

    @Then("^user clicks on 'Purchase Orders' link$")
    public void user_clicks_on_Purchase_Orders_link() throws Throwable {

    }

    @Then("^user clicks on plus button to create a new Purchase Order$")
    public void user_clicks_on_plus_button_to_create_a_new_Purchase_Order() throws Throwable {
        purchaseOrderPage.ClickonPlusButtontocreateaNewPO();

    }


    @And("^user fill the new Purchase Order Details$")
    public void userFillTheNewPurchaseOrderForm() throws InterruptedException {
        purchaseOrderPage.CustomerDetailsFilling();
        purchaseOrderPage.AgreementDetailsFilling();
        purchaseOrderPage.DescriptionFilling();
        purchaseOrderPage.VendorDetailsFilling();
        purchaseOrderPage.SavePurchaseOrder();
    }



    @Then("^user click on 'POLines'Tab$")
    public void user_click_on_POLines_Tab() throws Throwable {
        purchaseOrderLinesPage = new PurchaseOrderLinesPage();
        purchaseOrderLinesPage.ClickonPOLinesTAB();


    }

    @Then("^user add the NewRow$")
    public void user_add_the_NewRow() throws Throwable {
        purchaseOrderLinesPage.AddNewRow();

    }

    @Then("^user fill the PurchaseOrder Lines$")
    public void user_fill_the_PurchaseOrder_Lines() throws Throwable {
        //purchaseOrderLinesPage.SelectItemTypeasMaterial();
        purchaseOrderLinesPage.SelectItemTypeasSelect();
        purchaseOrderLinesPage.AddUnitandLineCost();
        purchaseOrderLinesPage.LinkWorkOrderNumber();
        purchaseOrderLinesPage.AddLineDescription();
        purchaseOrderLinesPage.AddItemDescription();


    }
    @Then("^user fill the PO Lines$")
    public void user_fill_the_PO_Lines() throws Throwable {
       purchaseOrderLinesPage.SelectItemTypeasSelect();
        //purchaseOrderLinesPage.SelectItemTypeasMaterial();
        purchaseOrderLinesPage.AddUnitandLineCost();
        purchaseOrderLinesPage.AddLineDescription();
        purchaseOrderLinesPage.AddItemDescription();
        purchaseOrderLinesPage.EnterLocationandFinanceDetails();


    }


        @And("^user workflow the PurchaseOrder$")
    public void userWorkflowThePurchaseOrder() {
        purchaseOrderLinesPage.ClickonWokFlowButtont();
    }

    @And("^user submit the PurchaseOrder for Approval process$")
    public void userSubmitThePurchaseOrderForApprovalProcess() {
        purchaseOrderLinesPage.PurchaseOrderApprovalMemo();
    }

    @And("^user verify the status of the PurchaseOrder submitted$")
    public void userVerifyTheStatusOfThePurchaseOrderSubmitted() throws IOException {
        purchaseOrderLinesPage = new PurchaseOrderLinesPage();
        purchaseOrderLinesPage.verifythestatusofPO();
    }
}