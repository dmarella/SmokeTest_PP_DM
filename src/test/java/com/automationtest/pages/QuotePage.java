package com.automationtest.pages;

import com.automationtest.base.Testbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuotePage extends Testbase {
   @FindBy(xpath = "//img[@id='mfbd60227_tdrow_[C:0]_txt-img[R:0]']")
   WebElement QuoteExpandButton;
   @FindBy(xpath = "//span[@id='NORMAL_applink_undefined_a_tnode'] ")
   WebElement GenerateQuotationManagerLink;
   @FindBy(xpath = "//input[@id='m6a7dfd2f_tfrow_[C:1]_txt-tb']")
   WebElement QuoteField;
   @FindBy(xpath = "//input[@id='me9f01837-tb']")
   WebElement StatusField;
   @FindBy(xpath = "//input[@id='m9ef728a1-tb']")
   WebElement OwenerGroupField;
   @FindBy(xpath = "//img[@id='m70f9498d-ti_img']")
   WebElement Attachmentimage;
   @FindBy(xpath = "//span[@id='DRATTACHMENTS_draddnew_a_tnode']")
   WebElement AddNewAttachments;
   @FindBy(xpath = "//form/div/div[2]/div")
   WebElement AddNewFile;
   @FindBy(xpath = "//*[@id='IMPORT']/table/tbody/tr/td/label")
   WebElement SelectButton;

    public QuotePage() {
        PageFactory.initElements(driver, this);

    }
    public void ClicktoExpandQuote() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", QuoteExpandButton);
        QuoteExpandButton.click();
    }
        public void ClickonGnerateQuoteManagerLink () {
            WebDriverWait wait1 = new WebDriverWait(driver, 20);
            wait1.until(ExpectedConditions.elementToBeClickable(GenerateQuotationManagerLink));
            GenerateQuotationManagerLink.click();


        }
        public void VerifytheQuoteStatus(){
           /* String Actual =StatusField.getText();
            Assert.assertEquals(Actual , "SCOPING");

            String OwenerGroup = OwenerGroupField.getText();
            Assert.assertEquals(OwenerGroup , "QTSCOPE" );*/
        }
        public void AddAttachment(){
           /* WebDriverWait wait1 = new WebDriverWait(driver, 60);
            wait1.until(ExpectedConditions.elementToBeClickable(Attachmentimage));
            Attachmentimage.click();
            WebDriverWait wait2 = new WebDriverWait(driver, 60);
            wait1.until(ExpectedConditions.elementToBeClickable(AddNewAttachments));
            AddNewAttachments.click();
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", AddNewFile);
            SelectButton.click();*/


        }


        }










