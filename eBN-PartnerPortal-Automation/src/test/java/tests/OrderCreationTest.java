package tests;

import Pages.*;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.*;
import java.io.IOException;

public class OrderCreationTest {
    private WebDriver driver;
    private BrowserInitializer browserInitializer;
    private OrderFormPage orderFormPage;
    private OrdersPage ordersPage;
    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void Setup() throws IOException {
        browserInitializer = new BrowserInitializer();
        driver = browserInitializer.initializeBrowser("chrome");
        Actions.initialize(driver);
        orderFormPage = new OrderFormPage(driver);
        ordersPage = new OrdersPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage = new LoginPage(driver);
    }


    @Test( description = "Verifies successful login and navigation to the order form.")
    public void testSuccessfulLoginAndNavigationToOrderForm() throws IOException, ParseException {
        loginPage.loginWithValidCredentials();
        dashboardPage.assertOneKonnectLogoExist();
        dashboardPage.chooseElectronicDataInterchangeButton();
        orderFormPage.fillOutTheFormWithValidData();
        orderFormPage.clickOnOrdersButton();
        ordersPage.assertThatTheFormCreateAndAppearInTable();

    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}