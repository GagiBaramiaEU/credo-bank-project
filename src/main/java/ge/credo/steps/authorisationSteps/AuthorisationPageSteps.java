package ge.credo.steps.authorisationSteps;

import ge.credo.data.ExpectedBorderColors;
import ge.credo.pages.authorisationPages.AuthorisationPage;
import ge.credo.steps.CommonSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AuthorisationPageSteps extends CommonSteps<AuthorisationPage> {
    private final AuthorisationPage authorisationPage;

    public AuthorisationPageSteps(WebDriver driver) {
        super(driver);
        authorisationPage = new AuthorisationPage(driver);
    }

    @Step("Enter username: {username}")
    public AuthorisationPageSteps enterUsername(String username) {
        utils.waitForElement(authorisationPage.getUsernameField());
        utils.enterText(authorisationPage.getUsernameField(), username);
        return this;
    }

    @Step("Enter password: {password}")
    public AuthorisationPageSteps enterPassword(String password) {
        utils.enterText(authorisationPage.getPasswordField(), password);
        return this;
    }

    @Step("Click on login button")
    public AuthorisationPageSteps clickOnLogin() {
        utils.click(authorisationPage.getLoginButton());
        return this;
    }

    @Step("Wait to authorisation loader")
    public AuthorisationPageSteps waitToAuthorisationLoader() {
        utils.waitForElementInvisible(authorisationPage.getAuthorisationLoader());
        return this;
    }

    @Step("Click on login button")
    public AuthorisationPageSteps clickOnLogin(int howManyTimes) {
        for (int i = 0; i < howManyTimes; i++) {
            try {
                utils.waitForElement(authorisationPage.getLoginButton());
                utils.waitForElementClickable(authorisationPage.getLoginButton());
                utils.click(authorisationPage.getLoginButton());
                waitToAuthorisationLoader();
            }catch (Exception e) {}
        }
        return this;
    }

    @Step("Click on 'Forgot Password' to start account recovery")
    public PasswordRecoverySteps clickOnRecoveryAccount(){
        utils.jsClick(authorisationPage.getForgotPassButton());
        return new PasswordRecoverySteps(driver);
    }
}
