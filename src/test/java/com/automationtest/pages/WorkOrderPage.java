package com.automationtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import static  com.automationtest.pages.PricingPage.WONumber;

public class WorkOrderPage extends PreventiveMaintenancePage {
   public static String WorkOrderNumber;
    //public static String WONumber;
    @FindBy(xpath = "//*[@id='mbf28cd64-tab_anchor']")
    WebElement WorkTab;
    @FindBy(xpath = "//img[@id='m6dfccb0d_tdrow_[C:0]_tgdet-ti[R:0]_img']")
    WebElement ExpandWorkOrderList;
    @FindBy(xpath = "//input[@id='mf2d9df82-tb']")
    static WebElement WOnumber;
    static String WOFILE = " C:\\Users\\pbonthal\\IdeaProjects\\Phoenix\\WO.txt";
    @FindBy(xpath = "//input[@id='input_39']")
    static
    WebElement WorkOrderField;
    @FindBy(xpath = "//input[@id='quicksearch']")
    static
    WebElement FindWO;
    @FindBy(xpath = "//input[@id='quicksearchQSImage']")
    static
    WebElement Searchbutton;
    @FindBy(xpath = "//input[@id='m6a7dfd2f_tfrow_[C:1]_txt-tb']")
    static
    WebElement WOfield;
    @FindBy(css = "#m9a787af-tb")
    static
    WebElement BillBatchWorkOderField;
    @FindBy(xpath = "//img[@id='m6a7dfd2f-ti2_img']")
    static
    WebElement WOsearchButton;
    @FindBy(xpath = "//span[@id='m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]']")
    static
    WebElement ClickonWOlink;
    @FindBy(xpath = "//input[@id='m6271c2a9-tb']")
    WebElement ActualStartDateField;
    @FindBy(xpath = "//input[@id='mfb789313-tb']")
    WebElement ActualFinishDateField;
    @FindBy(xpath = "//*[@id='m15b88ed6-cb_img']")
    WebElement MobileOverRideCheckbox;
    @FindBy(xpath = "//*[@id='m2d0b78bf-cb_img']")
    WebElement AppointmnetRequiredCheckbox;
    @FindBy(xpath = "//*[@id='mddc79f39-tb']")
    WebElement MobileOverRideReason;
    @FindBy(xpath = "//img[@id='toolactions_SAVE-tbb_image']")
    WebElement Savebutton;
    @FindBy(xpath = "//button[@id='m37917b04-pb']")
    WebElement OKbutton;
   // @FindBy(xpath = "//img[@id='ROUTEWF_MEUWO_-tbb_image']")
    @FindBy(xpath = "//img[@role='button' and @alt='Route Workflow']")
    WebElement WorkflowButton;
    @FindBy(xpath = "//input[@id='mad3161b5-tb2']")
    WebElement LongDescription;
    @FindBy(css = "#m1e2cbe37-tb")
    WebElement DocumentcheckStatus;
    static
    @FindBy(xpath = "//input[@id='input_39']")
    WebElement FsoWorkOrderSearchfield;
    @FindBy(xpath = "//input[@id='m5cd7ac0f-tb']")
    WebElement VendorField;
    @FindBy(xpath = "//button[@id='m15f1c9f0-pb']")
    WebElement CloseButton;
    @FindBy(xpath = "//input[@id='m58406fba-rb' and @tabindex='-1']")
    WebElement ReturnWorkOrderbutton;
    @FindBy(xpath = "//input[@id='m72e38894-tb']")
    WebElement ReturnStatusField;
    @FindBy(xpath = "//input[@id='mc1493e00-rb' and @tabindex='-1']")
    WebElement MaterialRequiredbutton;
    @FindBy(xpath = "//button[@id='mainrec-pg_retBut']")
    WebElement ReturnTab;
    @FindBy(xpath = "//*[@id='msgbox-hb_header_2']")
    WebElement Closeissue;
    @FindBy(xpath = "//*[@id='m8c7fa385-tb']")
    WebElement DurationField;




    public WorkOrderPage() {
        PageFactory.initElements(driver, this);

    }

    public void ClickonWorkTab() {
        //WorkTab.click();
    }
    public void WorkOrderTab() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(WorkTab)).click();
        Thread.sleep(1000);
    }

    public void ClickonExpandWorkOrder() {
        ExpandWorkOrderList.click();
    }

    /*public static String CopyWorkOrderNumber() {
        WorkOrderNumber = WOnumber.getText();
        System.out.println(WorkOrderNumber);

        return WorkOrderNumber;*/
    public static String CopyWorkOrderNumber() throws IOException {
        WorkOrderNumber = WOnumber.getAttribute("value");
        System.out.println("WorkOrderNumber is :" + WorkOrderNumber);
        File FC = new File("C:\\Users\\pbonthal\\IdeaProjects\\Phoenix\\WO.txt");
        FC.createNewFile();
        // Writing in to File
        FileWriter FW = new FileWriter("C:\\Users\\pbonthal\\IdeaProjects\\Phoenix\\WO.txt");
        BufferedWriter BW = new BufferedWriter(FW);
        BW.write(WorkOrderNumber); // Writing In To File.
        BW.close();
        return WorkOrderNumber;

    }

    public void readWorkOrderNumber() throws IOException {
       /* FileReader FR = new FileReader(WOFILE);
        BufferedReader BR = new BufferedReader(FR);
        String Content = "";
       // while ((Content = BR.readLine()) != null);
        System.out.println("wo"+FR);*/
        System.out.println(WorkOrderNumber);
    }

    public static void searchWO(String[] args) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(WorkOrderField)).sendKeys(WorkOrderNumber);


    }
    public static void entertheWorkOrderNumber(String[] args){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(BillBatchWorkOderField)).sendKeys(WorkOrderNumber);
    }

    public static void searchandClickonWO() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(WOfield)).sendKeys(WorkOrderNumber);
        WOsearchButton.click();
        ClickonWOlink.click();

    }
    public static void searchandClickonQuoteWO() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(WOfield)).sendKeys(WONumber);
        WOsearchButton.click();
        ClickonWOlink.click();
    }

    public static void searchandClickonPPMWO() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(WOfield)).sendKeys(WorkorderNumber);
        WOsearchButton.click();
        ClickonWOlink.click();
    }
    public static void searchandClickonPOWO() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(WOfield)).sendKeys(WorkOrderNumber);
        WOsearchButton.click();
        ClickonWOlink.click();
    }


    public static void searchWOinFSO(String[] args) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(FsoWorkOrderSearchfield)).sendKeys(WorkOrderNumber);

    }
    public void enterLongDescription() {
        LongDescription.click();
        LongDescription.sendKeys("TEST");
    }

    public void enterActualStartDate() throws InterruptedException {
        Thread.sleep(1000);
        Calendar cal = Calendar.getInstance();
        //subtracting a day
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat s = new SimpleDateFormat("d/M/yy");
        String YesterdayDate = s.format(new Date(cal.getTimeInMillis()));
        WebElement element = ActualStartDateField;
        element.clear();
        for (int i = 0; i < YesterdayDate.length(); i++) {
            char c = YesterdayDate.charAt(i);
            String SR = new StringBuilder().append(c).toString();
            element.sendKeys(SR);

        }
    }
    public void enterActualFinishDate() throws InterruptedException {
       /* ActualFinishDateField.clear();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.sendKeys(ActualFinishDateField, "6/1/2020").perform();*/
        Thread.sleep(1000);
        Calendar cal1 = Calendar.getInstance();
        //subtracting a day
        cal1.add(Calendar.DATE, -1);
        SimpleDateFormat s = new SimpleDateFormat("d/M/yy");
        String YesterdayDate1 = s.format(new Date(cal1.getTimeInMillis()));
        WebElement element1 = ActualFinishDateField;
        element1.clear();
        for (int i = 0; i < YesterdayDate1.length(); i++) {
            char c = YesterdayDate1.charAt(i);
            String SR = new StringBuilder().append(c).toString();
            element1.sendKeys(SR);


        }
    }
    public void checkMobileOverRideCheckbox() {
        if (!MobileOverRideCheckbox.isSelected())
            MobileOverRideCheckbox.click();
    }

    public void entertheMobileOverrideReason() {
        MobileOverRideReason.click();
        MobileOverRideReason.sendKeys("Testing");
    }

    public void clickonSavebutton() {
        //Savebutton.click();
        WebElement element = Savebutton;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickonOKbutton() throws InterruptedException {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(OKbutton)).click();
    }

    public void clickonWorkflowButton() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(WorkflowButton)).click();
        Thread.sleep(1000);

    }



    public void enterDocumentRequired() throws InterruptedException {
        Thread.sleep(2000);
        String status = "COMPLETE";
        WebElement element = DocumentcheckStatus;
        element.clear();
        for (int i = 0; i < status.length(); i++) {
            char c = status.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
            Thread.sleep(1000);

        }
    }
    public  void AddVendorDetails() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(VendorField)).sendKeys("V1002136");


    }
    public  void ClickonCloseButton() throws InterruptedException {
       driver.navigate().refresh();
       driver.switchTo().alert().accept();
        Thread.sleep(5000);
        /*WebElement element = CloseButton;
        /*JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(1000);
        //CloseButton.click();*/
       /* JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        element.click();*/
        /*Actions actions= new Actions (driver);
        actions.moveToElement(CloseButton).build(). perform ();
        actions.click().build(). perform ();*/

    }
    public void CloseButtonissue(){
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();

        subWindowHandler = iterator.next();

        driver.switchTo().window(subWindowHandler); // switch to popup window

// Now you are in the popup window, perform necessary actions here

        driver.switchTo().window(parentWindowHandler);
        WebElement element = CloseButton;
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        element.click();


    }

    public void ClickonReturnWorkOrderRadioButton(){
        WebElement element = ReturnWorkOrderbutton;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        ReturnWorkOrderbutton.click();
    }
    public void SelectReturnStatusField () throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(ReturnStatusField)).sendKeys("PARTS");

    }
    public void ClickonMaterialRequiredRadioButton(){
        WebElement element = MaterialRequiredbutton;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        MaterialRequiredbutton.click();
    }
    public void ClickonReturnTab(){
        WebElement element = ReturnTab;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

    }
    public void checkAppointmentRequiredCheckbox() {
        if (!AppointmnetRequiredCheckbox.isSelected())
            AppointmnetRequiredCheckbox.click();
    }
    public void Alert() {
        driver.switchTo().alert().dismiss();

    }
    public void EnterDuration() throws InterruptedException {
        Thread.sleep(2000);
        DurationField.clear();
        DurationField.sendKeys("1:00");
    }

    }











