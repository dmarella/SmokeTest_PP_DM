package com.automationtest.pages;

import com.automationtest.base.Testbase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class ForwardMainteananceRegisterPage extends Testbase {

    @FindBy(css = "#titlebar-tb_appname")
    WebElement ForwardMaintenanceRegisterPage;
    @FindBy(css = "#mb64692d3-tb2")
    WebElement DescriptionField;
    @FindBy(css = "#mc62c665c-tb")
    WebElement CustomerField;
    @FindBy(css = "#m2f4fc369-tb")
    WebElement LocationField;
    @FindBy(xpath = "//input[@id='mdedc8151-tb']")
    WebElement OwnerGroupField;
    @FindBy(xpath = "//input[@id='m37bf2464-tb']")
    WebElement EstimatedTotalPriceField;
    @FindBy(css = "#m40b814f2-tb")
    WebElement CustomerReference;
    @FindBy(xpath = "//img[@id='mb64692d3-img2']")
    WebElement LongDescriptionbutton;
    @FindBy(xpath = "//*[@id='ma6499a9c-rte_iframe']")
    WebElement LongDescriptionTextBox;
    @FindBy(xpath = "//button[@id='m74031266-pb']")
    WebElement OKbutton;
    @FindBy(xpath = "//img[@id='toolactions_SAVE-tbb_image']")
    WebElement SaveButton;
    @FindBy(xpath = "//input[@id='m30d2e07d-tb']")
    WebElement StatusField;
    @FindBy(xpath = "//*[contains(text(),'Move to Quotation')]")
    WebElement MoveToQuotationLink;
    @FindBy(xpath = "//button[@id='me1720906-pb']")
    WebElement ProceedtoQuoteSystemmessage;
    @FindBy(xpath = "//button[@id='m88dbf6ce-pb']")
    WebElement OkSystemmessage;
    @FindBy(xpath = "//input[@id='mb64692d3-tb']")
    static
    WebElement FMRnumber;
    @FindBy(xpath = "//*[@id='quicksearchQSImage']")
    static
    WebElement QuickSearchImage;
    @FindBy(xpath = "//input[@id='m27cde50f-tb']")
    static
    WebElement FMRsearch;
    @FindBy(xpath = "//button[@id='m10f985e2-pb']")
    static
    WebElement FindButton;
    @FindBy(xpath = "//*[@id='m6bed2137_tdrow_[C:1]-c[R:0]']")
    static
    WebElement Quote;
    @FindBy(xpath = "//input[@id='m6a7dfd2f_tfrow_[C:1]_txt-tb']")
    static
    WebElement QuoteField;
    private static String QuoteNumber;
    @FindBy(xpath = "//img[@id='m6a7dfd2f-ti2_img']")
    static
    WebElement QuoteSearch;
    @FindBy(xpath = "//*[@id='m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]']")
    static
    WebElement QuoteNumberLink;
    private static String FMR;
    ;


    public ForwardMainteananceRegisterPage() {
        PageFactory.initElements(driver, this);


    }

    public void VeifytheForwardMainteananceRegisterPage() {
        String Pagetext = ForwardMaintenanceRegisterPage.getText().trim();
        Assert.assertEquals(Pagetext, "Forward Maintenance Register");
    }

    public void EnterDescriptionDetails(String Description) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(DescriptionField)).sendKeys(Description);
        sleep(1000);
    }

    public void EnterCustomerDetails(String Customer) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(CustomerField)).sendKeys(Customer);
        sleep(1000);
    }

    public void EnterLocationDetails(String Location) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(LocationField)).sendKeys(Location);
        sleep(1000);
    }

    public void EnterOwenerGroupDetails(String OwenerGroup) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(OwnerGroupField)).sendKeys(OwenerGroup);
        sleep(1000);
    }

    public void EnterEstimatedTotalPriceDetails(String EstimatedTotalPrice) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(EstimatedTotalPriceField)).sendKeys(EstimatedTotalPrice);
        sleep(1000);
    }

    public void EnterCustomerReference(String CustomerReferenceNumber) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(CustomerReference)).sendKeys(CustomerReferenceNumber);
        sleep(1000);
    }

    public void EnterlongDescription() throws InterruptedException {
        LongDescriptionbutton.click();
        OKbutton.click();
    }

    public void SavetheFMR() {
        SaveButton.click();
    }

    public void FMRStatusWAPPR() {
        String status = StatusField.getAttribute("value");
        String actual = "WAPPR";
        Assert.assertEquals(status, actual);
    }

    public void ClickonMovetoQuotationLink() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(MoveToQuotationLink)).click();
        Actions act = new Actions(driver);
        act.moveToElement(ProceedtoQuoteSystemmessage).click().build().perform();
        ProceedtoQuoteSystemmessage.click();
        Actions act1 = new Actions(driver);
        act1.moveToElement(OkSystemmessage).click().build().perform();
        OkSystemmessage.click();
    }

    public static String CopyFMRnumber() throws InterruptedException {
        FMR = FMRnumber.getAttribute("value");
        System.out.println("FMR Number is:" + FMR);
        return FMR;
    }

    public static void SearchFMR(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        QuickSearchImage.click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(FMRsearch));
        FMRsearch.sendKeys(FMR);
        FindButton.click();
    }

    public static String CopyQuoteNumber() {
        QuoteNumber = Quote.getText();
        System.out.println("QuoteNumber is:" + QuoteNumber);
        return QuoteNumber;
    }


    public static void searchquote(String[] args) {

        QuoteField.sendKeys(QuoteNumber);
        QuoteSearch.click();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(QuoteNumberLink)).click();
    }
}