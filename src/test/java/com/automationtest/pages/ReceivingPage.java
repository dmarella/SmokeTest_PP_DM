package com.automationtest.pages;

import com.automationtest.base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReceivingPage extends Testbase {
    @FindBy(xpath = "//*[contains(text(),'Select Ordered Items')]")
    WebElement SelectOrderedItemsButton;
    @FindBy(xpath = "//img[@id='mf9bb799f_tdrow_[C:0]_tbselrow-ti[R:0]_img'] ")
    WebElement POline;
    @FindBy(xpath = "//*[contains(text(),'OK')]")
    WebElement OKbutton;
    @FindBy(xpath = "//img[@id='toolactions_SAVE-tbb_image']")
    WebElement SaveButton;

    public ReceivingPage() {
        PageFactory.initElements(driver, this);


    }

    public void clcikonSelectOrderedItemsButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(SelectOrderedItemsButton)).click();
    }

    public void clickonPOline() {
        Actions act = new Actions(driver);
        act.moveToElement(POline).click().build().perform();

    }

    public void clickonOKbutton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(OKbutton)).click();
    }

    public void clickonSaveButton() {
        Actions act = new Actions(driver);
        act.moveToElement(SaveButton).click().build().perform();
        driver.switchTo().alert().accept();
    }

}






