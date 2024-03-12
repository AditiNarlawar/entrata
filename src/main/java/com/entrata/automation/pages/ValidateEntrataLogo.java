package com.entrata.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reusableComponents.AbstractComponents;

public class ValidateEntrataLogo extends AbstractComponents {

    WebDriver driver;

    public ValidateEntrataLogo(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "svg.landing-logo")
    WebElement entrataLogo;

    public boolean isEntrataLogoDisplayed() {
        System.out.println(entrataLogo.getText());
        return entrataLogo.isDisplayed();
    }

    public String getEntrataLogoText() {
        return entrataLogo.getAttribute("alt");
    }
}
