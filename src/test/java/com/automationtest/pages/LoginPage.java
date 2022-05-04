package com.automationtest.pages;

import com.automationtest.base.Testbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Testbase {
    @FindBy(id = "j_username")
    WebElement UsernameField;
    @FindBy(id = "userNameInput")
    WebElement PreProdUsernameField;
    @FindBy(xpath = "//input[@id='passwordInput']")
    WebElement PreProdPasswordField;
    @FindBy(xpath = "//input[@id='j_password']")
    WebElement PasswordField;
    @FindBy(xpath = "//*[@id='loginbutton']")
    WebElement SignIntoMaximo;
    @FindBy(xpath = "//*[@id='submitButton']")
    WebElement SignIntoMaximoinFF;
    @FindBy(xpath = "//input[@name='Email']")
    WebElement PreProdLoginEmailField;
    @FindBy(xpath = "//input[@name='HomeRealmByEmail']")
    WebElement PreProdLoginNextButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void EnterUserName(String Username) {
        UsernameField.sendKeys(Username);

    }

    public void EnterPassword(String Password) {
        PasswordField.sendKeys(Password);

    }

    public HomePage login() {
        SignIntoMaximo.click();
        return new HomePage();

    }

    public void PreProdLogin(String Email) throws InterruptedException {
        Thread.sleep(2000);
        WebElement ele = PreProdLoginEmailField;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", ele);
        PreProdLoginEmailField.sendKeys(Email);
        PreProdLoginNextButton.click();
    }

    public void PreProdEnterUsernameforFirefox(String Username) {
        PreProdUsernameField.sendKeys(Username);
    }

    public void PreProdEnterPasswordforFirefox(String PreprodFFPassword) {
        PreProdPasswordField.sendKeys(PreprodFFPassword);
    }

    public void PreProdEnterLoginforFirefox() throws InterruptedException {
        SignIntoMaximoinFF.click();
        Thread.sleep(2000);

    }


}


