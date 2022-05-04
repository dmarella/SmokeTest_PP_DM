package com.automationtest.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;

import static java.lang.Thread.sleep;

public class PurchaseOrderLinesPage extends WorkOrderPage {
    public static String PO;
    @FindBy(xpath = "//*[@id='m185c951-tab_anchor' and @title='PO Lines']")
    WebElement POLinesTab;
    @FindBy(xpath = "//button[@id='mdcaa79e9_bg_button_addrow-pb' and @type='button']")
    WebElement NewRowButton;
    @FindBy(xpath = "//*[@id='m2584a113-tb']")
    WebElement LineTypeDropDownImage;
    @FindBy(xpath = "//*[contains(text(),'Material')]")
    WebElement Material;
    @FindBy(xpath = "//*[contains(text(),'Service')]")
    WebElement Service;
    @FindBy(xpath = "//input[@id='m52839185-tb2']")
    WebElement ItemDescription;
    @FindBy(xpath = "//input[@id='mdcaa79e9_tdrow_[C:3]_txt-tb[R:0]']")
    WebElement LineDescription;
    @FindBy(xpath = "//input[@id='mbf6d4802-tb']")
    WebElement UnitCost;
    @FindBy(xpath = "//input[@id='m266419b8-tb']")
    WebElement LineCost;
    @FindBy(xpath = "//*[@id='mba463242-tb']")
    WebElement WorkOrderNumberField;
    @FindBy(xpath = "//img[@id='ROUTEWF_MEUP2P_-tbb_image' and @role='button']")
    WebElement WorkFlowButton;
    @FindBy(xpath = "//input[@id='m1eb61c58-tb']")
    WebElement Memo;
    @FindBy(xpath = "//button[@id='m37917b04-pb' and @type='button']")
    WebElement OKbutton;
    @FindBy(xpath = "//input[@id='m4b932a98-tb']")
    static
    WebElement PurchaseOrderStatusField;
    @FindBy(xpath = "//input[@id='m3bf9de17-tb']")
    static
    WebElement PurchaseOrderNumber;
    @FindBy(xpath = "//img[@id='m5163292e-img']")
    WebElement TaxCodeSearchButton;
    @FindBy(xpath = "//span[@id='lookup_page1_tdrow_[C:0]_ttxt-lb[R:3]']")
    WebElement TaxCode;
    @FindBy(xpath = "//input[@id='m6a7dfd2f_tfrow_[C:1]_txt-tb']")
    static
    WebElement POseachField;
    @FindBy(xpath = "//img[@id='m6a7dfd2f-ti2_img']")
    WebElement FilterTableImage;
    @FindBy(xpath = "//span[@id='m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]']")
    WebElement POlink;
    WorkOrderPage workOrderPage;
    @FindBy(xpath = "//*[@id='m5448536e-tb']")
    WebElement LocationField;
    @FindBy(xpath = "//*[@id='m1bdc0459-tb']")
    WebElement FinancialWorkTypeField;
    @FindBy(xpath = "//img[@id='m1bdc0459-img']")
    WebElement FinanceWorkFieldSearchField;
    @FindBy(xpath = "//*[@id='lookup_page1_tdrow_[C:0]_ttxt-lb[R:3]']")
    WebElement RE;
    @FindBy(xpath = "//*[@id='m52852ffc_bg_button_selorditem-pb']")
    WebElement SelectOrderItems;
    @FindBy(xpath = "//*[@id='m73e505d6_bg_button_selordserv-pb']")
    WebElement SelcetOrderService;
    @FindBy(xpath = "//*[@id='mf87604cb_tdrow_[C:0]_tbselrow-ti[R:0]_img']")
    WebElement POcheckbox;
    @FindBy(xpath = "//*[@id='mab730c77-pb']")
    WebElement OK;
    @FindBy(xpath = "//*[@id='toolactions_SAVE-tbb_image']")
    WebElement SaveButton;
    @FindBy(xpath = "//*[contains(text(),'Service Receipts') and @tabindex='-1']")
    WebElement ServiceReceiptTab;

    public PurchaseOrderLinesPage() {
        PageFactory.initElements(driver, this);

    }

    public void ClickonPOLinesTAB() {
        POLinesTab.click();
    }

    public void AddNewRow() {
        NewRowButton.click();
    }

    public void SelectItemTypeasMaterial() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(LineTypeDropDownImage));
        LineTypeDropDownImage.click();
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.elementToBeClickable(Material));
        Material.click();

    }

    public void SelectItemTypeasSelect() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(LineTypeDropDownImage));
        LineTypeDropDownImage.click();
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.elementToBeClickable(Service));
        Thread.sleep(1000);
        Service.click();

    }

    public void AddItemDescription() throws InterruptedException {
        Thread.sleep(2000);
       /* //ItemDescription.sendKeys("Light Fitting");
        WebElement name=ItemDescription;
        ((JavascriptExecutor)driver).executeAsyncScript("arguments[0].value='Light Fitting'",name);
        Thread.sleep(2000);
        //ItemDescription.sendKeys(Keys.SPACE);
        //ItemDescription.sendKeys("Light Fitting");
        //WebElement name1=LineDescription;
        //((JavascriptExecutor)driver).executeAsyncScript("arguments[0].value='Light Fitting'",name1);*/
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(ItemDescription)).sendKeys("PO ");
        // nameField.sendKeys(Name);
        sleep(1000);
    }

    public void AddLineDescription() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(LineDescription)).sendKeys(" Training");
        // nameField.sendKeys(Name);
        sleep(1000);


    }

    public void AddUnitandLineCost() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(UnitCost));
        UnitCost.clear();
        //UnitCost.sendKeys("50");
        //UnitCost.sendKeys("350");
        UnitCost.sendKeys("50");
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.elementToBeClickable(LineCost));
        LineCost.clear();
        Thread.sleep(1000);
        //LineCost.sendKeys("50");
        //LineCost.sendKeys("350");
        LineCost.sendKeys("50");
        WebDriverWait wait2 = new WebDriverWait(driver, 60);
        wait2.until(ExpectedConditions.elementToBeClickable(TaxCodeSearchButton));
        TaxCodeSearchButton.click();
        WebDriverWait wait3 = new WebDriverWait(driver, 60);
        wait3.until(ExpectedConditions.elementToBeClickable(TaxCode));
        TaxCode.click();


    }

    public void EnterLocationandFinanceDetails() throws InterruptedException {
        LocationField.sendKeys("L1001455");
        Thread.sleep(2000);
        // FinancialWorkTypeField.sendKeys("RE");
        /*String Value = "RE";
        WebElement element = FinancialWorkTypeField;
        for (int i = 0; i < Value.length(); i++){
            char c = Value.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
            Thread.sleep(1000);*/
        FinanceWorkFieldSearchField.click();
        Thread.sleep(1000);
        RE.click();


    }

    public void LinkWorkOrderNumber() throws InterruptedException, IOException {
        Thread.sleep(2000);
        FileReader FR = new FileReader("C:\\Users\\pbonthal\\IdeaProjects\\Phoenix\\WO.txt");
        BufferedReader BR = new BufferedReader(FR);
        String Content = "";
        while ((Content = BR.readLine()) != null) {
            WorkOrderNumberField.sendKeys(Content);

        }
    }

    public void ClickonWokFlowButtont() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(WorkFlowButton));
        WorkFlowButton.click();
    }

    public void PurchaseOrderApprovalMemo() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(Memo)).sendKeys(" Approve");
        OKbutton.click();
    }

    public static String verifythestatusofPO() throws IOException {
        String Actual = PurchaseOrderStatusField.getAttribute("value");
        System.out.println("PO Status :" + Actual);
        //String Expected = "WAPPR";
        //Assert.assertEquals(Expected, Actual);
        PO = PurchaseOrderNumber.getAttribute("Value");
        System.out.println("PO Number is :" + PO);
        return PO;


    }

    public static void searchPO() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(POseachField)).sendKeys(PurchaseOrderLinesPage.PO);
    }

    public void ClickonFilterTableImage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(FilterTableImage)).click();

    }

    public void clickonPOlink() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(POlink)).click();
    }

    public void addPO() {
        SelectOrderItems.click();
        POcheckbox.click();
        OK.click();
        SaveButton.click();


    }

    public void addPOforService() throws InterruptedException {
       /* Actions act = new Actions(driver);
        act.moveToElement(ServiceReceiptTab).click().build().perform();*/
        Thread.sleep(1000);
        WebElement element = ServiceReceiptTab;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        SelcetOrderService.click();
        POcheckbox.click();
        OK.click();
        SaveButton.click();

    }

}