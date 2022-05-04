package com.automationtest.pages;

import com.automationtest.base.Testbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Testbase {
    @FindBy(xpath = "//*[@id='titlebar-tb_gotoButton']")
    WebElement GOTOButton;
    @FindBy(xpath = "//*[@id='menu0_SD_MODULE_a']")
    WebElement ServiceDesklink;
    @FindBy(xpath = "//span[@id='menu0_SD_MODULE_sub_changeapp_PLUSPSR_a_tnode']")
    WebElement ServiceRequestsLink;
    @FindBy(xpath = " //*[@id='menu0_WO_MODULE_a']")
    WebElement WorkOrder;
    @FindBy(xpath = "//span[@id='menu0_WO_MODULE_a_tnode']")
    WebElement WorkOrderLink;
    @FindBy(css = "#menu0_WO_MODULE_sub_changeapp_MEUFMR_a_tnode")
    WebElement ForwardMaintenanceRegisterLink;
    @FindBy(css = "#menu0_WO_MODULE_sub_changeapp_MEUQM_a_tnode")
    WebElement QuotationManagerLink;
    @FindBy(xpath = "//input[@id='nav_search_fld']")
    WebElement SearchField;
    @FindBy(xpath = "//*[@id='nav_search_fld_menu_navSearchItemm7f8f3e49_ns_menu_PM_MODULE_sub_changeapp_PM_a_a']/span")
    WebElement PMlink;
    @FindBy(xpath = "//span[@class='tamatch']")
    WebElement WOlink;
    @FindBy(xpath = "//input[@id='quicksearch']")
    WebElement FindWO;

    public HomePage() {
        PageFactory.initElements(driver, this);


    }

    public void ClickonGOTObutton() throws InterruptedException {
        /*Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(GOTOButton)).click();*/
        WebElement element = GOTOButton;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void ClickonServiceDesklink() throws InterruptedException {
        Thread.sleep(1000);
        /*WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(ServiceDesklink)).click();*/
        WebElement element = ServiceDesklink;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void ClickonServiceRequestsLink() throws InterruptedException {
        WebElement element = ServiceRequestsLink;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(2000);
    }

    public void ClickonWorkOrderLink() throws InterruptedException {
        WorkOrderLink.click();
        Thread.sleep(1000);

    }

    public void ClickonForwardMaintananceLink() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.elementToBeClickable(ForwardMaintenanceRegisterLink));
        ForwardMaintenanceRegisterLink.click();
        Thread.sleep(1000);
    }

    public void CLickonQuoteManagementLink() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.elementToBeClickable(QuotationManagerLink));
        QuotationManagerLink.click();
        Thread.sleep(1000);

    }

    public void ClickonPreventiveMaintenenceLink() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(SearchField)).sendKeys("Preventive maintenance");
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.elementToBeClickable(PMlink)).click();


    }

    public void searchforWorkOrder() throws InterruptedException {
        Thread.sleep(2000);
        SearchField.sendKeys("Work Order Tracking (SP)");
        WOlink.click();
        Thread.sleep(2000);


    }

    public void searchforLaborReporting() throws InterruptedException {
        Thread.sleep(2000);
        SearchField.sendKeys("Labor Reporting");
        WOlink.click();
        Thread.sleep(2000);

    }

    public void searchforCustomerBilling() throws InterruptedException {
        Thread.sleep(2000);
        SearchField.sendKeys("Customer Billing (SP)");
        WOlink.click();
        Thread.sleep(2000);
    }

    public void searchforBillReview() throws InterruptedException {
        Thread.sleep(2000);
        SearchField.sendKeys("Bill Review (SP)");
        WOlink.click();
        Thread.sleep(2000);

    }
    public void searchforReceiving() throws InterruptedException{
        Thread.sleep(2000);
        SearchField.sendKeys("Receiving");
        WOlink.click();
        Thread.sleep(2000);

    }


}






