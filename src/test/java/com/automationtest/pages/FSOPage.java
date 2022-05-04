package com.automationtest.pages;

import com.automationtest.base.Testbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.automationtest.pages.PreventiveMaintenancePage.WorkorderNumber;
import static com.automationtest.pages.PricingPage.WONumber;
import static com.automationtest.pages.WorkOrderPage.WorkOrderNumber;

public class FSOPage extends Testbase {
    @FindBy(name = "username")
    WebElement FSOUsernameField;
    @FindBy(name = "password")
    WebElement FSOPasswordField;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement FSOLoginButton;
    @FindBy(xpath = "//*[@id='toolbar-div']/md-toolbar/div/button/ng-md-icon")
    WebElement Menu;
    @FindBy(xpath = "//*[@id='select_value_label_16']/span[2]")
    WebElement Expandbutton;
    @FindBy(xpath = "//*[@id='select_option_23]/div[1]")
    WebElement Bristol;
    @FindBy(css = "#toolbar-div > md-toolbar > div > fso-toolbar-tabs > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item:nth-child(2)")
    WebElement Jobs;
    @FindBy(xpath = "//input[@id='input_39']")
    WebElement WorkOrderField;
    @FindBy(xpath = "//*[@id='jobs-md-table-container']/table/tbody/tr/td[1]/md-checkbox/div[1]")
    WebElement WorkOrderLink;
    @FindBy(xpath = "//*[@id='job-details-assign-button']/span")
    WebElement AssignJobLink;
    @FindBy(css = "#save-assignment-btn > span")
    WebElement SaveButton;
    @FindBy(css = ".ng-pristine > .md-ink-ripple")
    WebElement Checkbox;
    @FindBy(css = "body > div.md-dialog-container > md-dialog > form > md-dialog-actions > button:nth-child(2)")
    WebElement Save;
    @FindBy(xpath = "/html/body/div[1]/div/md-content/div/fso-job-assignment/div/div[6]/div/div/md-card[1]/md-dialog-content/fso-job-assignment-scheduler/div/div/div[1]/div[1]/db-search-box/div/form/md-input-container/input")
    WebElement EngineerSearchfield;
    @FindBy(xpath = "//*[contains(text(),'Cancel')]")
    WebElement CancelButton;
    public FSOPage() {
        PageFactory.initElements(driver, this);
    }

    public void EnterFSOUserName(String FSOUsername) {
        FSOUsernameField.sendKeys(FSOUsername);

    }

    public void EnterFSOPassword(String FSOPassword) {
        FSOPasswordField.sendKeys(FSOPassword);

    }

    public HomePage FSOlogin() {
        FSOLoginButton.click();
        return new HomePage();

    }

    public void ChangethelocationtoBristol() throws InterruptedException {
        /*Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(Menu)).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.elementToBeClickable(Expandbutton)).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 60);
        wait2.until(ExpectedConditions.elementToBeClickable(Bristol)).click();*/
        Thread.sleep(4000);
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.elementToBeClickable(Jobs)).click();


    }

    public void searchforWorkOrder() throws InterruptedException {
        Thread.sleep(10000);
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.elementToBeClickable(WorkOrderField)).sendKeys(WorkOrderNumber);
        // WorkOrderField.sendKeys(WorkOrderNumber);
    }

    public void searchforPPMWorkOrder() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.elementToBeClickable(WorkOrderField)).sendKeys(WorkorderNumber);

    }

    public void searchforQuoteWorkOrder() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.elementToBeClickable(WorkOrderField)).sendKeys(WONumber);

    }

    public void clickonWorkOrderLink() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.elementToBeClickable(WorkOrderLink)).click();

    }

    public void clickonAssignJobLink() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.elementToBeClickable(AssignJobLink)).click();
        Thread.sleep(1000);

    }

    public void assignjobandSave() throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = SaveButton;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        //SaveButton.click();
        WebElement element1 = Checkbox;
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", element1);
        Thread.sleep(2000);
        WebElement element2 = Save;
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", element2);
        if(!CancelButton.isEnabled()){

        }else{
            CancelButton.click();
            SaveButton.click();
            Thread.sleep(1000);
            Checkbox.click();
            Save.click();
            Thread.sleep(1000);
        }
    }

    public void EnterEngineerNumber() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.elementToBeClickable(EngineerSearchfield)).sendKeys("404320");
        Thread.sleep(1000);
        /*WebElement webl = EngineerSearchfield;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='404320';", webl);*/

    }

}
