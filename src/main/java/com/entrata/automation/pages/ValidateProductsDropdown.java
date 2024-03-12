package com.entrata.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import reusableComponents.AbstractComponents;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ValidateProductsDropdown extends AbstractComponents {
    WebDriver driver;

    public ValidateProductsDropdown(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='main-nav-link dark-section'])[1]")
    WebElement products;

    @FindBy(tagName = "a")
    List<WebElement> linkCounts;

    @FindBy(css = ".fat-nav-grid .nav-group:first-of-type")
    List<WebElement> firstBlockProducts;

    public void validateProductTitlesInProductDropdown() throws InterruptedException {
        products.click();

        int totalLinksInFirstBlock = 0;
        List<String> consoleTitles = new ArrayList<>(); // Store console output titles

        for (WebElement product : firstBlockProducts) {
            List<WebElement> links = product.findElements(By.tagName("a"));

            // Increment the total count of links
            totalLinksInFirstBlock += links.size();

            // Click on each link and open in a new tab
            for (WebElement link : links) {
                String clickOnTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
                link.sendKeys(clickOnTab);
                Thread.sleep(3000L); // Adding sleep time to allow the page to load
            }
        }

        // Wait for all windows/tabs to be opened and page titles to be loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Adjust the timeout as needed
        wait.until(ExpectedConditions.numberOfWindowsToBe(totalLinksInFirstBlock + 1));

        //get title of each tab
        Set<String> getWindowHandles = driver.getWindowHandles();
        for (String windowHandle : getWindowHandles) {
            driver.switchTo().window(windowHandle);
            String title = driver.getTitle();
            System.out.println("Page Title: " + title);
            consoleTitles.add(title);
        }

        // Compare each console output title with the title of the opened pages
        for (int i = 0; i < consoleTitles.size(); i++) {
            String consoleTitle = consoleTitles.get(i);
            String pageTitle = driver.getTitle();

            //we are checking if the current page title exists in the console titles.
            //we are using contains methods as we are unsure about the sequence of the page title corresponding to console titles.
            Assert.assertTrue(consoleTitles.contains(pageTitle));
        }
        System.out.println("Total number of links in the first block: " + totalLinksInFirstBlock);
    }

    public void validateLinkCount() {
        System.out.println("Total number of links are: " + linkCounts.size() + " Links");
        Assert.assertEquals(linkCounts.size(), 196);
    }
}

