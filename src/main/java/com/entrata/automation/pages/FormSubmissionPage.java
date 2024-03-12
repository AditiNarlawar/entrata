package com.entrata.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import reusableComponents.AbstractComponents;

public class FormSubmissionPage extends AbstractComponents {
    WebDriver driver;

    public FormSubmissionPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(xpath = "//input[@id='Company']")
    WebElement companyName;

    @FindBy(id = "Phone")
    WebElement phone;

    @FindBy(id = "Unit_Count__c")
    WebElement unitCount;

    @FindBy(id = "Title")
    WebElement jobTitle;

    public void submitForm(String userName, String userLastName, String userEmail, String userCompanyName, String userPhone) {
        firstName.sendKeys(userName);
        lastName.sendKeys(userLastName);
        email.sendKeys(userEmail);
        companyName.sendKeys(userCompanyName);
        phone.sendKeys(userPhone);
    }

    public void selectUnitCount(String userJobTitle) {
        Select dropdown = new Select(unitCount);
        dropdown.selectByValue("1 - 10");
        unitCount.click();
        jobTitle.sendKeys(userJobTitle);
    }
}
