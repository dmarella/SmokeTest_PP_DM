package com.automationtest.pages;

import com.automationtest.base.Testbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

public class PlansPage extends Testbase {
    @FindBy(xpath = "//*[@id='m356798d1-tab_anchor' and @title='Plans']")
    WebElement Planstab;
    @FindBy(xpath = "//button[@id='mbb442a0c_bg_button_addrow-pb' and @type='button']")
    WebElement NewRowButtonforPlansSection;
    @FindBy(xpath = "//input[@id='mbb442a0c_tdrow_[C:3]_txt-tb[R:0]']")
    WebElement SummaryField;
    @FindBy(xpath = "//input[@id='mbb442a0c_tdrow_[C:4]_txt-tb[R:0]']")
    WebElement Duration;
    @FindBy(xpath = "//img[@id='toolactions_SAVE-tbb_image']")
    WebElement SaveButton;

    public PlansPage() {
        PageFactory.initElements(driver, this);

    }

    public void clickonPlansTab() {
        WebElement element = Planstab;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickonNewRowforPlans() {
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        WebElement element = NewRowButtonforPlansSection;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void AddSummary() throws InterruptedException {
        Thread.sleep(2000);
        String status = "InternalEngineer";
        WebElement element = SummaryField;
        element.clear();
        for (int i = 0; i < status.length(); i++) {
            char c = status.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
            Thread.sleep(1000);
        }
    }

    public void AddDuration() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(Duration)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(Duration)).sendKeys("1:00");


    }
    public void ClickonSaveButton(){
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        WebElement element = SaveButton;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


}




