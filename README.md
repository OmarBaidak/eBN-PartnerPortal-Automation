# eBN Partner Portal Test Automation
> This is a test automation task on [__eBN Partner Portal website__](https://devtesting.onekonnect.com/eBNPartnerPortal_test2/Account/Login) website (The test covers logging in, creating an EDI order, and verifying it appears in the Orders tab.

).

## Installation

Clone the repo:

```sh
https://github.com/OmarBaidak/eBN-PartnerPortal-Automation.git
```

Install dependencies:

You need to install these dependencies from [_mvnrepository_](https://mvnrepository.com/):

```sh
Selenium WebDriver
TestNG
WebDriverManager
JSON Simple
```
Requires:
```sh
JDK 17
Maven
```

## Test Scenarios

Scenario:

1.Open the login page: https://devtesting.onekonnect.com/eBNPartnerPortal_test2/Account/Login
2.Login with credentials from JSON:
-Username: TestingAutomation
-Password: Interview@123!
3.Verify the dashboard appears
4.Click Add (+) and choose Electronic Data Interchange
5.Fill only mandatory fields from JSON
6.Submit the form
7.Go to the Orders tab
8.Verify the new order appears in the orders list

## Skills

- Java
- Selenium WebDriver
- TestNG
- POM (Page Object Model)
- Data-driven testing (JSON)
- Maven
