package com.entrata.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reusableComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class*=header-desktop-buttons] a[class*=button-default]:nth-child(1)")
    WebElement watchDemo;

    public FormSubmissionPage goToFormSubmission() {
        watchDemo.click();
        FormSubmissionPage formSubmissionPage = new FormSubmissionPage(driver);
        return formSubmissionPage;
    }

    public void goTo() {
        // Navigate to the Entrata website
        driver.get("https://www.entrata.com/");
    }
}


