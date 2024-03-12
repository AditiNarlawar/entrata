package com.entrata.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import reusableComponents.AbstractComponents;

public class ValidateSalesNumber extends AbstractComponents {
    WebDriver driver;

    public ValidateSalesNumber(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class*='footer-text']")
    WebElement footerText;

    @FindBy(id = "rcc-confirm-button")
    WebElement acceptCookiesButton;

    public void validateSalesNumberFromFooterSection() {
        if (acceptCookiesButton.isDisplayed()) {
            acceptCookiesButton.click();
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)");

        String salesText = footerText.getText();
        String salesNumber = extractSalesNumber(salesText);
        System.out.println("Sales Number: " + salesNumber);

        String expectedSales = "866.807.0880";
        Assert.assertEquals(salesNumber, expectedSales, "Sales number doesn't match the expected value.");
    }

    // Method to extract sales number from text
    private String extractSalesNumber(String text) {
        return text.replaceAll("[^\\d.]", ""); // Remove all non-numeric characters except '.'
    }
}

