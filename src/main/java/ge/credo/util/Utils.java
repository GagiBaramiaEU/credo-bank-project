package ge.credo.util;

import ge.credo.data.ExpectedBorderColors;
import ge.credo.helpers.ConfigReader;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public WebDriver driver;

    public ConfigReader configReader = ConfigReader.getInstance();
    JavascriptExecutor js;

    long waitTime;
    public Utils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitTime = Long.parseLong((configReader.get("wait")));
        js = (JavascriptExecutor) driver;
    }

    /**
     * Wait for the element to be visible for a maximum of 10 seconds.
     *
     * @param locator The element you want to wait for.
     */
    @Step("Wait for the element to be visible")
    public void waitForElement(WebElement locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
            wait.until(ExpectedConditions.visibilityOf(locator));
        } catch (Exception e) {
            System.out.println("Caught an Exception Element: " + e.getMessage());
        }
    }

    /**
     * Wait for element and enter text in that
     *
     * @param element element you want to enter the text
     * @param text    text you want to enter
     */
    @Step("enter text: {element}, {text}")
    public void enterText(WebElement element, String text) {
        waitForElement(element);
        waitForElementClickable(element);
        element.clear();
        element.sendKeys(text);

    }

    /**
     * Wait for the element to be clickable for a maximum of 10 seconds.
     *
     * @param webElement The element you want to wait for.
     */
    @Step("Wait for the element to be clickable: {webElement}")
    public void waitForElementClickable(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
            System.out.println("Element Not Clickable");
        }
    }

    /**
     * Wait for element to be visible and click on it
     *
     * @param element element you want to click
     */
    @Step("enter text: {element}")
    public void click(WebElement element) {
        waitForElement(element);
        waitForElementClickable(element);

        element.click();
        System.out.println("Clicked on: " + element.getText());
    }


    /**
     * Click on element using JavaScript Executor.
     *
     * @param element element you want to click
     */
    @Step("Click on element using JavaScript Executor: {element}")
    public void jsClick(WebElement element) {
        try {
            waitForElement(element);
            waitForElementClickable(element);

            js.executeScript("arguments[0].click();", element);

            System.out.println("JS Clicked on: " + element.getText());
        } catch (Exception e) {
            System.out.println("JS Click failed: " + e.getMessage());
        }
    }

    /**
     * Wait until the element is enabled (not disabled).
     *
     * @param element The element you want to wait for.
     */
    @Step("Wait for the element to be enabled: {element}")
    public void waitUntilElementWillBeEnable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
            wait.until(driver -> element.isEnabled() && !element.getAttribute("class").contains("disabled"));
            System.out.println("Element is now enabled: " + element.getText());
        } catch (Exception e) {
            System.out.println("Element did not become enabled in time: " + e.getMessage());
        }
    }

    /**
     * Wait for the element to be invisible for a maximum of 10 seconds.
     *
     * @param webElement The element you want to wait for.
     * @return the boolean
     */
    @Step("Wait for the element to be invisble - disappear: {webElement}")
    public boolean waitForElementInvisible(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
            wait.until(ExpectedConditions.invisibilityOf(webElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Click on an empty space (e.g., body) to trigger blur events or remove focus from inputs.
     */
    @Step("Click on empty space to remove focus from active elements")
    public void clickOnEmptySpace() {
        try {
            WebElement body = driver.findElement(org.openqa.selenium.By.tagName("body"));
            org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
            actions.moveToElement(body, 0, 0).click().perform();
            System.out.println("Clicked on empty space (body) to trigger blur event.");
        } catch (Exception e) {
            System.out.println("Failed to click on empty space: " + e.getMessage());
        }
    }

    @Step("Wait for element to have border color: {expectedColor}")
    public void waitForElementBorderColor(WebElement element, ExpectedBorderColors expectedColor) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
            wait.until(driver -> {
                String actualColor = element.getCssValue("border-top-color");
                return expectedColor.getRgbaValue().equals(actualColor);
            });
            System.out.println("Element has expected border color: " + expectedColor.getRgbaValue());
        } catch (Exception e) {
            System.out.println("Border color did not match in time. Expected: " + expectedColor.getRgbaValue() + " - " + e.getMessage());
        }
    }
}
