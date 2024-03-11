package com.entrata.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reusableComponents.AbstractComponents;

import java.util.Iterator;
import java.util.Set;

public class BaseCampPage extends AbstractComponents {
    WebDriver driver;

    public BaseCampPage(WebDriver driver) {
        super(driver);
        //Initialization code
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Base Camp']")
    WebElement baseCamp;
    @FindBy(xpath = "//div[@class='text-block-18']")
    WebElement registerButton;

    @FindBy(xpath = "//*[text()='Personal Information']")
    static WebElement personalInfo;

    public void navigateToBaseCamp() {
        baseCamp.click();
        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();

        String parentWindowId = it.next();
        String childWindowId = it.next();

        driver.switchTo().window(childWindowId);
        registerButton.click();
    }


    public static String getConfirmationMessage() {
        return personalInfo.getText();
    }

}
