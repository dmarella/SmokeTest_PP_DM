package com.automationtest.pages;

import com.automationtest.base.Testbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceRequestPage extends Testbase {
    @FindBy(xpath = "//*[@id='titlebar-tb_appname']")
    WebElement ServiceRquestPageText;
    @FindBy(xpath = "//img[@id='toolactions_INSERT-tbb_image']")
    WebElement NewServiceRequestButton;
    @FindBy(xpath = "//input[@id='m48ad8788-tb']")
    WebElement ReportedByField;
    @FindBy(xpath = "//input[@id='m97aacb59-tb']")
    WebElement nameField;
    @FindBy(xpath = "//img[@id='m91640b1a-img']")
    WebElement customerFieldbutton;
    @FindBy(xpath = "//img[@class='menuimg']")
    WebElement customerFieldSelectValueImage;
    @FindBy(xpath = "//td[@id='lookup_page1_tdrow_[C:0]-c[R:0]' and @tablecell='1']")
    WebElement customerSelection;
    @FindBy(xpath = "//img[@id='ma6a3e6a4-img' and @tabindex='-1']")
    WebElement locationFieldbutton;
    @FindBy(xpath = "//span[@id='LOCATIONS_locations0_a_tnode']")
    WebElement locationFieldSelectValueImage;
    @FindBy(xpath = "//span[@id='lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]']")
    WebElement locationSelection;
    @FindBy(xpath = "//input[@id='ma1ce22bd-tb' and @role='textbox']")
    WebElement summaryField;
    @FindBy(xpath = "//input[@id='m4fc04391-tb']")
    WebElement classificationField;
    @FindBy(xpath = "//img[@id='m4fc04391-img']")
    WebElement classificationFieldbutton;
    @FindBy(xpath = "//span[@id='CLASSIFICATION_classification_1_a_tnode']")
    WebElement classficationFieldSelectedValueImage;
    @FindBy(xpath = "//div[@id='m6b48ba09_62158-trn']")
    WebElement reactiveExpandbutton;
    @FindBy(xpath = "//a[@id='m6b48ba09_62158-trn_nodename_link']")
    WebElement electricalExpandbutton;
    @FindBy(xpath = "//a[@id='m6b48ba09_69442-trn_nodename_link']")
    WebElement light;
    @FindBy(xpath = "//*[@id='md6c9122b-ta']")
    WebElement DetailTextBox;
    @FindBy(xpath = "//input[@id='m9604ace2-tb']")
    WebElement ReportedByPhoneField;
    @FindBy(xpath = "//input[@id='me1039c74-tb']")
    WebElement ReportedByEmailField;
    @FindBy(xpath = "//input[@id='m916968fb-tb']")
    WebElement CustomerReferenceField;
    @FindBy(xpath = "//input[@id='me66e586d-tb']")
    WebElement CustomerReference2Field;
    @FindBy(xpath = "//img[@id='toolactions_SAVE-tbb_image' and @role='button']")
    WebElement SaveServiceRequest;
    @FindBy(xpath = "//input[@id='ma1befcd8-tb']")
    WebElement ServiceStatusField;
   // @FindBy(xpath = "//img[@id='ROUTEWF_MEUSRINI_-tbb_image']")
    //@FindBy(xpath = "//img[@role='button' and @alt='Route Workflow']")
    //@FindBy(css ="#ROUTEWF_MEUSRINI_-tbb_image")
   // WebElement RotueWorkflowButton;
    @FindBy(xpath = "//*[starts-with(@id,'ROUTEWF') and contains(@alt,'Route Workflow')]")
    WebElement RotueWorkflowButton;
    @FindBy(xpath = "//img[@id='ROUTEWF_MEUWO_-tbb_image']")
    WebElement WorkflowButton;
    @FindBy(xpath = "//button[text() ='Close' and @id='m15f1c9f0-pb']")
    WebElement Alert;
    @FindBy(xpath = "//*[@title='Work']")
    WebElement WorkTab;
    @FindBy(xpath = "//input[@id='m91640b1a-tb']" )
    WebElement CustomerNameforQuote;
    @FindBy(xpath = "//input[@id='ma6a3e6a4-tb']")
    WebElement LocationforQuote;
    @FindBy(xpath = "//input[@id='ma3f84281-tb']")
    WebElement ServiceRequestNumberField;
    private Object Date;


    public ServiceRequestPage() {
        PageFactory.initElements(driver, this);
    }

    public void VerifyServiceRequestPage() {
        /*String Actual = ServiceRquestPageText.getText();
        String Expected= "Service Requests (SP)";

       Assert.assertEquals(Expected , Actual);*/
    }

    public void ClickonNewServiceRequestPlusButton() {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(NewServiceRequestButton)).click();
    }

    public void clearReportedByField(){
        ReportedByField.clear();
    }

    public void EnterName(String Name) throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        Date date = new Date();
        String date1 = dateFormat.format(date).trim();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        nameField.click();
        //wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys(Name +date1);
        wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys(Name);
        Thread.sleep(2000);


    }

    public void EnterCustomer() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(customerFieldbutton)).click();
        //customerFieldbutton.click();
       // sleep(1000);
        customerFieldSelectValueImage.click();
        customerSelection.click();

    }

    public void Enterlocation() throws InterruptedException {
        locationFieldbutton.click();
        locationFieldSelectValueImage.click();
        locationSelection.click();
        //sleep(1000);
    }

    public void EnterSummary(String summary) {
        WebElement element = summaryField;
        element.clear();
        for (int i = 0; i < summary.length(); i++){
            char c = summary.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
    }

    public void EnterClassification(String classification) throws InterruptedException {
        WebElement element = classificationField;
        element.clear();
        for (int i = 0; i < classification.length(); i++){
            char c = classification.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }


    }

    public void EnterDetails(String details) throws InterruptedException {
        WebElement element = DetailTextBox;
        //element.clear();
        for (int i = 0; i < details.length(); i++){
            char c = details.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
    }
    public void EnterPhonenumber(String reportedByPhone) throws InterruptedException {
       // sleep(1000);
       /* WebElement element = ReportedByPhoneField;
        element.clear();
        for (int i = 0; i < reportedByPhone.length(); i++){
            char c = reportedByPhone.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);*/
       Thread.sleep(2000);
       ReportedByPhoneField.sendKeys(reportedByPhone);
            //sleep(1000);

    }
    public void EnterEmail(String reportedByEmail) throws InterruptedException {

        ReportedByEmailField.click();
        ReportedByEmailField.sendKeys(reportedByEmail);
        //sleep(1000);

    }
    public void EnterCustomerReference(String customerReference) throws InterruptedException {
        WebElement element = CustomerReferenceField;
        element.clear();
        for (int i = 0; i < customerReference.length(); i++) {
            char c = customerReference.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
            Thread.sleep(1000);
        }

    }
    public void EnterCustomerReference2(String customerReference2) throws InterruptedException {
       /*WebElement element = CustomerReference2Field;
        element.clear();
        for (int i = 0; i < customerReference2.length(); i++){
            char c = customerReference2.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);*/
        CustomerReference2Field.sendKeys(customerReference2);
    }

    public void ClickonSaveServiceRequest() throws InterruptedException {
        SaveServiceRequest.click();

    }

    public void ClickonWorkflowButton() throws InterruptedException {
        Thread.sleep(1000);
        Actions act1 = new Actions(driver);
        act1.moveToElement(RotueWorkflowButton).click().build().perform();
        //Thread.sleep(1000);
        act1.doubleClick(RotueWorkflowButton).perform();
        Thread.sleep(1000);
        act1.doubleClick(RotueWorkflowButton).perform();




    }
    public void DoubleClickonWorkflowButton() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(RotueWorkflowButton).click().build().perform();
        Thread.sleep(1000);
        Actions act1 = new Actions(driver);
        act1.moveToElement(RotueWorkflowButton).click().build().perform();
        Thread.sleep(1000);
        Actions act2 = new Actions(driver);
        act2.moveToElement(RotueWorkflowButton).click().build().perform();
    }
    public void workflowbuttonclick() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", WorkflowButton);
        Thread.sleep(1000);

    }

    public void AccepttheAlert() throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = Alert;
        //if (element.isDisplayed() && element.isEnabled()) {
            Actions act1 = new Actions(driver);
            act1.moveToElement(element).click().build().perform();

        //}

    }
    public void ClickonWorkTab() throws InterruptedException{
       //Thread.sleep(1000);
        /*Actions act1 = new Actions(driver);
        act1.moveToElement(WorkTab).click().build().perform();*/

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", WorkTab);
    }

    public void EnterCustomerDetailsforQuote(String Customer) throws InterruptedException{
        Thread.sleep(3000);
        WebElement element = CustomerNameforQuote;
        element.clear();
        for (int i = 0; i < Customer.length(); i++){
            char c = Customer.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }

    }
        public void EnterLocationDetailsforQuote(String Location) throws InterruptedException{
            WebElement element1 = LocationforQuote;
            element1.clear();
            for (int i = 0; i < Location.length(); i++){
                char c = Location.charAt(i);
                String s = new StringBuilder().append(c).toString();
                element1.sendKeys(s);
            }


    }
    public void CopySRnumber() throws InterruptedException {
        //Thread.sleep(2000);
       String SRNumber= ServiceRequestNumberField.getAttribute("value");
       System.out.println("SRNumber is:"+SRNumber);

    }
}