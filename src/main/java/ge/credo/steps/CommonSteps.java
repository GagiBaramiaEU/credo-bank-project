package ge.credo.steps;

import ge.credo.util.Utils;
import ge.credo.pages.Commons;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommonSteps<T> {
    protected WebDriver driver;
    protected Utils utils;
    private final Commons commons;

    public CommonSteps(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new Utils(driver);
        commons = new Commons(driver);
    }

    @Step("Validate that error notification is displayed")
    public boolean validateErrorNotificationIsDisplayed() {
        utils.waitForElement(commons.getErrorNotificationContainer());
        return commons.getErrorNotificationContainer().isDisplayed();
    }

    @Step("Get text from error message")
    public String getTextFromErrorMessage() {
        utils.waitForElement(commons.getGlobalErrorMessage());
        return commons.getGlobalErrorMessage().getText();
    }

    @Step("Click on close button of error notification")
    public T clickOnCloseButtonOnErrorNotification() {
        utils.jsClick(commons.getCloseButtonOnErrorNotificationContainer());
        return (T) this;
    }

    @Step("Click on language switcher button")
    public LanguageSwitcherPopupSteps clickOnLanguageSwitcherButton() {
        utils.jsClick(commons.getLanguageSwitcherButton());
        return new LanguageSwitcherPopupSteps(driver);
    }
}
