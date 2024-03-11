package com.entrata.automation.tests;

import com.entrata.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import javax.xml.ws.RequestWrapper;

public class HomePageNavigation extends BaseTest {

    /**
     * Test method to navigate to the landing page, submit a form, select a unit count,
     * and then navigate back to the previous page.
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    @Test
    public void goToLandingPage() {
        FormSubmissionPage formSubmissionPage = landingPage.goToFormSubmission();
        formSubmissionPage.submitForm("Aditi", "Narlawar", "aditinarlawar@gmail.com", "Wipro Ltd.", "7522942206");
        formSubmissionPage.selectUnitCount("Software Engineer In Test");
        driver.navigate().back();
    }

    /**
     * Test method to navigate back to the previous page.
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    @Test(dependsOnMethods = {"goToLandingPage"})
    public void WindowActivities() {
        driver.navigate().back();
    }

    /* @Test()
     public void validateBaseCamp() {

         BaseCampPage baseCampPage = new BaseCampPage(driver);
         baseCampPage.navigateToBaseCamp();
         String confirmationMessage = BaseCampPage.getConfirmationMessage();
         Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Personal Information"));
 }*/

    /**
     * Test method to get the title from the product dropdown, count the number of links, and move to the products dropdown.
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    @Test
    public void getTitleFromProductDropdown() throws InterruptedException {
        ValidateProductsDropdown productsDropdown = new ValidateProductsDropdown(driver);
        productsDropdown.countOfLinks();
        productsDropdown.moveToProductsDropdown();
    }

    /**
     * Test method to get the sales number from the footer section and validate it.
     */
    @Test
    public void getSalesNumberAndValidate() {
        ValidateSalesNumber salesNumber = new ValidateSalesNumber(driver);
        salesNumber.validateSalesNumberFromFooterSection();
    }

    /**
     * Test method to validate the Entrata logo by checking if it is displayed and validating its text.
     */
    @Test
    public void testEntrataLogo() {

        ValidateEntrataLogo validateEntrataLogo = new ValidateEntrataLogo(driver);
        // Validate if the Entrata logo is displayed
        Assert.assertTrue(validateEntrataLogo.isEntrataLogoDisplayed(), "Entrata logo is not displayed.");

        // Get the text of the Entrata logo
        String logoText = validateEntrataLogo.getEntrataLogoText();

        // Validate the text of the Entrata logo
        Assert.assertEquals(logoText, "Entrata Inc. Logo", "Logo text does not match.");
    }

}
