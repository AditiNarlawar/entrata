# Web UI Automation Project

This project is designed for automating tests for the Entrata website's user interface (UI). It utilizes Selenium WebDriver and TestNG for test automation.

## Test Cases

### 1. Landing Page Navigation with Form Submission

- **Description:** Navigates to the landing page, submits a form, selects a unit count, and then navigates back to the previous page.
- **Test Method:** testLandingPageNavigationWithFormSubmission()

### 2. Product Title from Product Dropdown

- **Description:** Gets the title from the product dropdown, counts the number of links, and moves to the products dropdown.
- **Test Method:** testProductTitleFromProductDropdown()

### 3. Sales Number from Footer Section

- **Description:** Gets the sales number from the footer section and validates it.
- **Test Method:** testSalesNumberFromFooterSection()

### 4. Entrata Logo Validation

- **Description:** Validates the Entrata logo by checking if it is displayed and validating its text.
- **Test Method:** testEntrataLogo()

## Prerequisites

- Java Development Kit (JDK)
- Selenium
- TestNG
- Maven
- WebDriver executable (e.g., chromedriver.exe)
- IDE (e.g., IntelliJ IDEA)

## Setup Instructions

1. Clone the project repository.
2. Open the project in your preferred IDE.
3. Configure the project dependencies and WebDriver executable.
4. Locate the HomepageNavigationTestng.xml file in the project structure.
   Right-click on the HomepageNavigationTestng.xml file.
   Select run option to run the TestNG suite.

## Author

[Aditi Narlawar]
