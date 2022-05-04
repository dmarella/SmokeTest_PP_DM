package com.automationtest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ActualsPage extends PreventiveMaintenancePage {
    public static String date2;
    @FindBy(xpath = "//*[@id='m272f5640-tab_anchor' and @title='Actuals']")
    WebElement ActualsTab;
    @FindBy(css = "#m4dfd8aef_bg_button_addrow-pb")
    WebElement Newrow;
    @FindBy(css = "#m71551ec4-tb")
    WebElement Worktype;
    @FindBy(css = "#mef50ddba-tb")
    WebElement LabourField;
    @FindBy(css = "#mf3329b8e-tb")
    WebElement StartDateField;
    @FindBy(css = "#m89f2c8ee-tb")
    WebElement FinishDateField;
    @FindBy(css = "#m5df1446b-tb")
    WebElement StartTimeField;
    @FindBy(css = "#m6d560e2d-tb")
    WebElement FinishTimeField;
    @FindBy(css = "#toolactions_SAVE-tbb_image")
    WebElement SaveButton;
    @FindBy(xpath = "//img[@id='mfae908c1_tdrow_[C:9]_txt-img[R:0]']")
    WebElement DetailMenu;
    @FindBy(xpath = "//*[@id='NORMAL_applink_undefined_a_tnode']")
    WebElement ActivitiesandTasks;
    @FindBy(xpath = "//*[@id='m6271c2a9-tb']")
    WebElement ActualStart;
    @FindBy(xpath = "//*[@id='mfb789313-tb']")
    WebElement ActualFinish;
    static
    @FindBy(xpath = "//*[@id='m8b12679c-tb']")
    WebElement ScheduleStart;
    static
    @FindBy(xpath = "//*[@id='m1576f23f-tb']")
    WebElement ScheduleFinish;
    @FindBy(xpath = "//*[@id='mb81f4493-cb_img']")
    WebElement MobileRideCheckBox;
    @FindBy(xpath = "//*[@id='m29468bc5-tb']")
    WebElement Reason;

    public ActualsPage() {
        PageFactory.initElements(driver, this);

    }

    public void clickonActualsTab() {
        WebElement element = ActualsTab;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickonNewRow() {
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        WebElement element = Newrow;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void enterLaborNumber() throws InterruptedException {
        Thread.sleep(2000);
        LabourField.sendKeys("404320");
    }
    public void enterSecondLaborNumber() throws InterruptedException {
        Thread.sleep(2000);
        LabourField.sendKeys("404320");
    }

    public void enterStartDate() throws InterruptedException {
        Thread.sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        Date date = new Date();
        String date2 = dateFormat.format(date).trim();
        //WebDriverWait wait = new WebDriverWait(driver, 100);
        //wait.until(ExpectedConditions.elementToBeClickable(StartDateField)).sendKeys(date2);
        WebElement Start = StartDateField;
        Start.clear();
        for (int i = 0; i < date2.length(); i++) {
            char c = date2.charAt(i);
            String s = new StringBuilder().append(c).toString();
            Start.sendKeys(s);

        }
    }

    public void enterFinishDate() throws InterruptedException {
        Thread.sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        Date date = new Date();
        String date1 = dateFormat.format(date).trim();
        //WebDriverWait wait = new WebDriverWait(driver, 100);
        //wait.until(ExpectedConditions.elementToBeClickable(FinishDateField)).sendKeys(date1);
        WebElement Finish = FinishDateField;
        Finish.clear();
        for (int i = 0; i < date1.length(); i++) {
            char c = date1.charAt(i);
            String s = new StringBuilder().append(c).toString();
            Finish.sendKeys(s);
        }


    }

    public void enterStartTimeforTravel() throws InterruptedException {
        Thread.sleep(1000);
        String time = "9:00 AM";
        WebElement Start = StartTimeField;
        Start.clear();
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            String s = new StringBuilder().append(c).toString();
            Start.sendKeys(s);

        }
    }
    public void enterEndTimeforTravel() throws InterruptedException {
        Thread.sleep(1000);
        String time = "9:15 AM";
        WebElement Finish = FinishTimeField;
        Finish.clear();
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            String s = new StringBuilder().append(c).toString();
            Finish.sendKeys(s);

        }
    }

    public void enterStartTimeforOnsite() throws InterruptedException {
        Thread.sleep(1000);
        String time = "9:15 AM";
        WebElement Start = StartTimeField;
        Start.clear();
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            String s = new StringBuilder().append(c).toString();
            Start.sendKeys(s);


        }
    }
    public void enterEndTimeforOnsite() throws InterruptedException {
        String time = "9:30 AM";
        WebElement Finish = FinishTimeField;
        Finish.clear();
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            String s = new StringBuilder().append(c).toString();
            Finish.sendKeys(s);
        }
    }
    public void enterStartTimeforWork() throws InterruptedException {
        Thread.sleep(1000);
        String time = "9:30 AM";
        WebElement Start = StartTimeField;
        Start.clear();
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            String s = new StringBuilder().append(c).toString();
            Start.sendKeys(s);


        }
    }
    public void enterEndTimeforWork() throws InterruptedException {
        String time = "9:45 AM";
        WebElement Finish = FinishTimeField;
        Finish.clear();
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            String s = new StringBuilder().append(c).toString();
            Finish.sendKeys(s);
        }
    }
    public void enterStartTimeforWoComp() throws InterruptedException {
        Thread.sleep(1000);
        String time = "9:45 AM";
        WebElement Start = StartTimeField;
        Start.clear();
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            String s = new StringBuilder().append(c).toString();
            Start.sendKeys(s);


        }
    }
    public void enterEndTimeforWoComp() throws InterruptedException {
        String time = "10.00 AM";
        WebElement Finish = FinishTimeField;
        Finish.clear();
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            String s = new StringBuilder().append(c).toString();
            Finish.sendKeys(s);
        }
    }
    public void selectTravelType() throws InterruptedException {
        Thread.sleep(2000);
        Worktype.clear();
        Worktype.sendKeys("TRAVEL");
        Thread.sleep(2000);
    }

    public void selectWorkType() throws InterruptedException {
        Thread.sleep(2000);
        Worktype.clear();
        Worktype.sendKeys("WORK");
        Thread.sleep(2000);


    }

    public void selectonsiteType() throws InterruptedException {
        Thread.sleep(2000);
        Worktype.clear();
        Worktype.sendKeys("ONSITE");
        Thread.sleep(2000);
    }

    public void selectwocompType() throws InterruptedException {
        Thread.sleep(2000);
        Worktype.clear();
        Worktype.sendKeys("WOCOMP");
        Thread.sleep(2000);
    }

    public void clickonSaveButton() throws InterruptedException {
        WebElement element = SaveButton;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(1000);
    }

    public void ClickonDetailMenuIcon() throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = DetailMenu;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(1000);
    }

    public void ActivitiesandTasks() throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = ActivitiesandTasks;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(1000);

    }

    public void AddActualStartandFinishDates() throws InterruptedException {
     /*   ActualStart.clear();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.sendKeys(ActualStart, " 5/1/2020").perform();
        Thread.sleep(1000);
        ActualFinish.clear();
        Thread.sleep(2000);
        Actions actions1 = new Actions(driver);
        actions1.sendKeys(ActualFinish, " 5/1/2020").perform();*/
        Thread.sleep(1000);
        Calendar cal = Calendar.getInstance();
        //subtracting a day
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat s = new SimpleDateFormat("d/M/yy");
        String YesterdayDate = s.format(new Date(cal.getTimeInMillis()));
        ActualStart.clear();
        /*for (int i = 0; i < YesterdayDate.length(); i++) {
            char c = YesterdayDate.charAt(i);
            String SR = new StringBuilder().append(c).toString();*/
            ActualStart.sendKeys(YesterdayDate);
            Thread.sleep(3000);
            //ActualFinish.clear();
            ActualFinish.sendKeys(YesterdayDate);


        }


    public static void EditScheduleStartandFinishDates() throws InterruptedException {
        Thread.sleep(1000);
        DateFormat dateFormat = new SimpleDateFormat("d/M/yy");
        Date date = new Date();
        date2 = dateFormat.format(date).trim();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        ScheduleStart.clear();
        wait.until(ExpectedConditions.elementToBeClickable(ScheduleStart)).sendKeys(date2);
        Thread.sleep(2000);
        ScheduleFinish.clear();
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.elementToBeClickable(ScheduleFinish)).sendKeys(date2);


    }

    public void ChooseMobileOverrideoption() {
        if (!MobileRideCheckBox.isSelected())
            MobileRideCheckBox.click();
        Reason.click();
        Reason.sendKeys("Testing");
    }
}





