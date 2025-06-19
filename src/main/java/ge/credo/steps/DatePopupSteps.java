package ge.credo.steps;

import ge.credo.pages.DatePopup;
import ge.credo.steps.authorisationSteps.PasswordRecoverySteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DatePopupSteps extends CommonSteps {
    DatePopup datePopup;

    public DatePopupSteps(WebDriver driver) {
        super(driver);
        datePopup = new DatePopup(driver);
    }

    @Step("Choose year from date picker")
    public DatePopupSteps chooseYear() {
        utils.jsClick(datePopup.getYearElement());
        return this;
    }

    @Step("Choose month from date picker")
    public DatePopupSteps chooseMonth() {
        utils.jsClick(datePopup.getMonthElement());
        return this;
    }

    @Step("Choose day from date picker and return to password recovery")
    public PasswordRecoverySteps chooseDay() {
        utils.jsClick(datePopup.getDayElement());
        utils.waitForElementInvisible(datePopup.getDayElement());
        return new PasswordRecoverySteps(driver);
    }
}
