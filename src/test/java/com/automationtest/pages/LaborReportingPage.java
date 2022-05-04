package com.automationtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaborReportingPage extends WorkOrderPage {
    private static String WorkOrderNumber;

    @FindBy(css = "#m68d8715f-tbb_text")
    WebElement AdvancedSearch;
    @FindBy(css = "#m64aa3412-tb")
    static
    WebElement WorkOrderSearchField;
    @FindBy(css = "#m69d4b684-pb")
    WebElement FindButton;
    public LaborReportingPage() {
        PageFactory.initElements(driver, this);
    }
    public void clickonAdvancedSearchButton() {
        AdvancedSearch.click();

    }

    public static void searchWO(String[] args) {

        WorkOrderSearchField.click();
        WorkOrderSearchField.sendKeys(WorkOrderNumber);
    }

}