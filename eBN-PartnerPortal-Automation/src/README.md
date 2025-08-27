eBN Partner Portal Test Automation

This is a test automation task for the eBN Partner Portal website. The test covers logging in, creating an EDI order, and verifying it appears in the Orders tab.

Installation

Clone the repo:

https://github.com/OmarBaidak/eBN-PartnerPortal-Automation.git


Install dependencies:

You need the following dependencies (managed via pom.xml):

Selenium WebDriver

TestNG

WebDriverManager

JSON Simple (for JSON data handling)

Requires:

JDK 17

Maven

Test Scenarios

Scenario:

Open the login page:
https://devtesting.onekonnect.com/eBNPartnerPortal_test2/Account/Login

Login with credentials (read from JSON):

Username: TestingAutomation

Password: Interview@123!

Verify the dashboard appears.

Click Add (+) → choose Electronic Data Interchange.

Fill only mandatory fields (loaded from JSON).

Submit the form.

Navigate to the Orders tab.

Verify that your new order appears in the orders list.

Skills Demonstrated

Java (JDK 17)

Selenium WebDriver

TestNG

Page Object Model (POM)

Data-driven testing via JSON

Maven build automation