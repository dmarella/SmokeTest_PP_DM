package com.automationtest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentsPage extends PreventiveMaintenancePage {
    @FindBy(xpath = " //*[@id='m308a50dd-tab_anchor' and @title='Assignments']")
    WebElement AssigmentsTab;
    @FindBy(xpath = "//button[@id='m6798a95d_bg_button_addrow-pb']")
    WebElement NewRow;
    @FindBy(xpath = "//*[@id='m6798a95d_tdrow_[C:4]_txt-tb[R:0]']")
    WebElement Craft;
    @FindBy(xpath = "//*[@id='m6798a95d_tdrow_[C:5]_txt-tb[R:0]']")
    WebElement Skill;
    @FindBy(xpath = "//*[@id='m6798a95d_tdrow_[C:6]_txt-tb[R:0]']")
    WebElement LabourField;
    @FindBy(xpath = "//img[@id='m6798a95d_tdrow_[C:14]_toggleimage-ti[R:0]_img']")
    WebElement AssignmentDeleteButton;
    @FindBy(xpath = "//button[@id='m6798a95d_bg_button_addrow-pb']")
    WebElement AssignmentNewRowButton;
    @FindBy(xpath = "//input[@id='m6798a95d_tdrow_[C:6]_txt-tb[R:1]']")
    WebElement NewAssignmentLabour;
    @FindBy(xpath = "//*[@id='m6798a95d_tdrow_[C:1]_txt-img[R:1]']")
    WebElement Task;
    @FindBy(xpath = "//*[@id='lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]']")
    WebElement TaskValue;
    public AssignmentsPage() {
        PageFactory.initElements(driver, this);

    }

    public void clickonAssignmentsTab() {
        WebElement element = AssigmentsTab;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void ClickonNewRowButton() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(NewRow)).click();

    }

    public void EnterCraft() throws InterruptedException {
        Thread.sleep(2000);
        String status = "FABRIC";
        WebElement element = Craft;
        element.clear();
        for (int i = 0; i < status.length(); i++) {
            char c = status.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
            Thread.sleep(1000);
        }
    }
    public void EnterSkill() throws InterruptedException {
        Thread.sleep(2000);
        String status = "ENG";
        WebElement element = Skill;
        element.clear();
        for (int i = 0; i < status.length(); i++) {
            char c = status.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
            Thread.sleep(1000);
        }
    }
    public void EnterLabourNumber() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(LabourField)).sendKeys("404320");

    }
    public void DeletePreviousAssignment(){
        WebElement element = AssignmentDeleteButton;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void AddNewAssignment() throws InterruptedException {
        WebElement element = AssignmentNewRowButton;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(NewAssignmentLabour)).sendKeys("418590");
        Thread.sleep(1000);
        Task.click();
        Thread.sleep(1000);
        TaskValue.click();


    }

}

