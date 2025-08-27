eBN Partner Portal Test Automation

This is a test automation task for the eBN Partner Portal website. The test covers logging in, creating an EDI order, and verifying it appears in the Orders tab.

Installation
Clone the repo:

https://github.com/OmarBaidak/eBN-PartnerPortal-Automation.git


Install dependencies:
You need the following dependencies from Maven:

Selenium WebDriver

TestNG

WebDriverManager

JSON Simple

Requires:

JDK 17

Maven

Test Scenario

Open the login page: https://devtesting.onekonnect.com/eBNPartnerPortal_test2/Account/Login

Login with credentials from JSON:

Username: TestingAutomation

Password: Interview@123!

Verify the dashboard appears

Click Add (+) and choose Electronic Data Interchange

Fill only mandatory fields from JSON

Submit the form

Go to the Orders tab

Verify the new order appears in the orders list

Skills

Java

Selenium WebDriver

TestNG

POM (Page Object Model)

Data-driven testing (JSON)

Maven
