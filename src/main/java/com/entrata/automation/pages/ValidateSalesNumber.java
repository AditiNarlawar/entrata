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
        //Initialization code
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
        // waitForWebElementToDisappear(acceptCookiesButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)");

        // Get the text containing the sales number
        String salesText = footerText.getText();

        // Extract the sales number from the text
        String salesNumber = extractSalesNumber(salesText);

        // Print the sales number in the console output
        System.out.println("Sales Number: " + salesNumber);

        // Perform validation on the sales number as needed
        // For example, you can compare it to an expected value
        String expectedSales = "866.807.0880";
        Assert.assertEquals(salesNumber, expectedSales, "Sales number doesn't match the expected value.");
    }

    // Method to extract sales number from text
    private String extractSalesNumber(String text) {
        return text.replaceAll("[^\\d.]", ""); // Remove all non-numeric characters except '.'
    }
}

