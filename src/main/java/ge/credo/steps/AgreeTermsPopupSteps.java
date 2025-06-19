package ge.credo.steps;

import ge.credo.pages.AgreeTermsPopup;
import ge.credo.steps.authorisationSteps.PasswordRecoverySteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AgreeTermsPopupSteps extends CommonSteps<AgreeTermsPopupSteps> {
    AgreeTermsPopup agreeTermsPopup;

    public AgreeTermsPopupSteps(WebDriver driver) {
        super(driver);
        agreeTermsPopup = new AgreeTermsPopup(driver);
    }

    @Step("Click on red circle to expand the full agreement text")
    public AgreeTermsPopupSteps clickOnRedCircleToExtendWholeAgreement() {
        utils.jsClick(agreeTermsPopup.getCircleBtnToExtendAgreement());
        return this;
    }

    @Step("Wait for agreement button loader to disappear")
    public AgreeTermsPopupSteps waitToButtonLoader() {
        utils.waitForElementInvisible(agreeTermsPopup.getAgreeButtonLoader());
        return this;
    }

    @Step("Click on 'Agree' button in agreement terms popup")
    public PasswordRecoverySteps clickOnAgreeButtonOnAgreementTermsPopuop() {
        utils.waitUntilElementWillBeEnable(agreeTermsPopup.getAgreeButtonOnAgreementTermsPopup());
        utils.jsClick(agreeTermsPopup.getAgreeButtonOnAgreementTermsPopup());
        waitToButtonLoader();
        return new PasswordRecoverySteps(driver);
    }
}
