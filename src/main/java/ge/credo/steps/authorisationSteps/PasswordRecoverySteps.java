package ge.credo.steps.authorisationSteps;

import ge.credo.data.ExpectedBorderColors;
import ge.credo.pages.authorisationPages.PasswordRecoveryPage;
import ge.credo.steps.AgreeTermsPopupSteps;
import ge.credo.steps.CommonSteps;
import ge.credo.steps.DatePopupSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class PasswordRecoverySteps extends CommonSteps<PasswordRecoverySteps> {

    PasswordRecoveryPage passwordRecoveryPage;

    public PasswordRecoverySteps(WebDriver driver) {
        super(driver);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
    }

    @Step("Get top border color of personal number input")
    public String getPersonalNumberInputTopBorderColor(ExpectedBorderColors expectedBorderColor) {
        utils.waitForElement(passwordRecoveryPage.getPersonalNumberInput());
        utils.waitForElementBorderColor(passwordRecoveryPage.getPersonalNumberInput(), expectedBorderColor);
        return passwordRecoveryPage.getPersonalNumberInput().getCssValue("border-top-color");
    }

    @Step("Enter personal number: {personalNumber}")
    public PasswordRecoverySteps enterPersonalNumber(String personalNumber) {
        utils.waitForElement(passwordRecoveryPage.getPersonalNumberInput());
        utils.enterText(passwordRecoveryPage.getPersonalNumberInput(), personalNumber);
        utils.clickOnEmptySpace();

        return this;
    }


    @Step("Click on birthdate input to open date picker")
    public DatePopupSteps chooseBirthDate(){
        utils.click(passwordRecoveryPage.getBirthDateInput());
        return new DatePopupSteps(driver);
    }

    @Step("Click on 'Agree to Terms' checkbox")
    public AgreeTermsPopupSteps clickOnAgreeTermsCheckBox(){
        utils.jsClick(passwordRecoveryPage.getAgreeTermsCheckBox());
        return new AgreeTermsPopupSteps(driver);
    }

    @Step("Check if the Continue button is enabled")
    public boolean continueButtonIsEnable(){
        utils.waitForElement(passwordRecoveryPage.getContinueButton());
        return passwordRecoveryPage.getContinueButton().isEnabled();
    }

    @Step("Wait until the Continue button becomes enabled")
    public PasswordRecoverySteps waitContinueButtonToBeEnable(){
        utils.waitUntilElementWillBeEnable(passwordRecoveryPage.getContinueButton());
        return this;
    }

    @Step("Click on the Continue button")
    public PasswordRecoverySteps clickOnContinueButton(){
        utils.jsClick(passwordRecoveryPage.getContinueButton());
        return this;
    }

    @Step("Click on 'Go Back' to return to login")
    public AuthorisationPageSteps clickOnGoBackButton(){
        utils.jsClick(passwordRecoveryPage.getGoBackButton());
        return new AuthorisationPageSteps(driver);
    }
}
