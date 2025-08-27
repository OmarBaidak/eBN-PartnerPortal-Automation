package utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Actions {

    static WebDriver driver;
    private static WebDriverWait wait;
    private static final Duration DEFAULT_WAIT_TIME = Duration.ofSeconds(35);

    // This method must be called once to initialize the driver and wait objects
    public static void initialize(WebDriver webDriver) {
        Actions.driver = webDriver;
        Actions.wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
    }

    // Private helper method to encapsulate the explicit wait logic
    private static WebElement waitForElement(By locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            Assert.fail("Element not found or not clickable within timeout: " + locator);
            return null;
        }
    }

    private static WebElement findElement(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            Assert.fail("Element not found: " + locator);
            return null;
        }
    }

    public static void click(By by) {
        try {
            WebElement element = waitForElement(by);
            element.click();
        } catch (Exception e) {
            Assert.fail("Failed to click element: " + by + " due to " + e.getMessage());
        }
    }
    public static void pressEnter(By by) {
        try {
            WebElement element = findElement(by); // Use your existing findElement helper
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            // Assert.fail or throw a custom exception
            throw new RuntimeException("Failed to press Enter on element: " + by, e);
        }
    }

    public static void type(By by, String text) {
        try {
            WebElement element = waitForElement(by);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            Assert.fail("Failed to type into element: " + by + " due to " + e.getMessage());
        }
    }

    public static String getElementText(By by) {
        try {
            WebElement element = waitForElement(by);
            return element.getText();
        } catch (Exception e) {
            Assert.fail("Failed to get text from element: " + by + " due to " + e.getMessage());
            return null;
        }
    }


    public static void clickWithJs(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void scrollIntoView(By by) {
        try {
            WebElement element = findElement(by);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            Assert.fail("Element not found or not visible after scrolling: " + by);
        }
    }

    public static void selectByValue(By locator, String value) {
        WebElement dropdownElement = findElement(locator);
        Select dropdown = new Select(dropdownElement);
        try {
            dropdown.selectByValue(value);
        } catch (NoSuchElementException e) {
            Assert.fail("Option with value '" + value + "' not found in dropdown: " + locator);
        }
    }

    public static void selectByIndex(By locator, int index) {
        WebElement dropdownElement = findElement(locator);
        Select select = new Select(dropdownElement);
        try {
            select.selectByIndex(index);
        } catch (NoSuchElementException e) {
            Assert.fail("Option at index '" + index + "' not found in dropdown: " + locator);
        }
    }

    public static void switchToIframe(By iframeLocator) {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
        } catch (TimeoutException e) {
            Assert.fail("Could not switch to iframe: " + iframeLocator);
        }
    }

    public static void switchToDefaultContent() {
        if (driver != null) {
            driver.switchTo().defaultContent();
        } else {
            Assert.fail("Driver is null, cannot switch to default content.");
        }
    }

    public static void waitForNumberOfWindows(int numberOfWindows) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
    }
}