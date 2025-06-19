package ge.credo;

import ge.credo.base.BaseTest;
import ge.credo.data.DataProviderClass;
import ge.credo.data.Language;
import ge.credo.steps.authorisationSteps.AuthorisationPageSteps;
import ge.credo.steps.authorisationSteps.PasswordRecoverySteps;
import io.qameta.allure.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static ge.credo.data.ExpectedBorderColors.*;
import static ge.credo.data.GlobalErrorMessagesTranslations.*;
import static ge.credo.data.AutomationErrorMessages.*;

@Epic("Authorisation tests")
@Test(groups = {"AuthorisationsGroup"})
public class AuthorisationTests extends BaseTest {

    private AuthorisationPageSteps authorisationPageSteps;
    private PasswordRecoverySteps passwordRecoverySteps;
    private SoftAssert softAssert;

    @BeforeClass
    public void initSteps() {
        authorisationPageSteps = new AuthorisationPageSteps(driver);
        passwordRecoverySteps = new PasswordRecoverySteps(driver);
        softAssert = new SoftAssert();
    }

    @Test(priority = 1, dataProvider = "languageProvider", dataProviderClass = DataProviderClass.class)
    @Feature("Authorisation")
    @Story("Login with invalid credentials")
    @Description("This test attempts login with random invalid credentials and validates the appropriate error message.")
    @Severity(SeverityLevel.NORMAL)
    public void caseWhenUserLogsInWithIncorrectData(Language language) {
        authorisationPageSteps
                .clickOnLanguageSwitcherButton()
                .chooseLanguageAccordingProvidedLanguage(language)
                .enterUsername(RandomStringUtils.randomAlphanumeric(8))
                .enterPassword(RandomStringUtils.randomAlphanumeric(10))
                .clickOnLogin();

        softAssert.assertTrue(
                authorisationPageSteps.validateErrorNotificationIsDisplayed(),
                ERROR_NOTIFICATION_NOT_DISPLAYED.getMessage()
        );

        softAssert.assertEquals(
                authorisationPageSteps.getTextFromErrorMessage(),
                GLOBAL_ERROR_DATA_IS_INCORRECT.get(language),
                ASSERT_EQUALS_FAIL.getMessage()
        );

        authorisationPageSteps.clickOnCloseButtonOnErrorNotification();
    }

    @Test(priority = 2, dataProvider = "languageProvider", dataProviderClass = DataProviderClass.class)
    @Feature("User Login")
    @Story("Lock account after multiple failed login attempts")
    @Description("Verifies that a real user gets blocked after entering an incorrect password 7 times. Also validates the correct error message appears in the selected language.")
    @Severity(SeverityLevel.NORMAL)
    public void caseWhenRealUserLogsInWithAnIncorrectPassword7Times(Language language) {
        authorisationPageSteps
                .clickOnLanguageSwitcherButton()
                .chooseLanguageAccordingProvidedLanguage(language)
                .enterUsername("123")
                .enterPassword(RandomStringUtils.randomAlphanumeric(10))
                .clickOnLogin(8);

        softAssert.assertTrue(
                authorisationPageSteps.validateErrorNotificationIsDisplayed(),
                ERROR_NOTIFICATION_NOT_DISPLAYED.getMessage());

        softAssert.assertEquals(
                authorisationPageSteps.getTextFromErrorMessage(),
                GLOBAL_ERROR_USER_IS_BLOCKED.get(language),
                ASSERT_EQUALS_FAIL.getMessage());

        authorisationPageSteps.clickOnCloseButtonOnErrorNotification();
    }

    @Test(priority = 3, dataProvider = "languageProvider", dataProviderClass = DataProviderClass.class)
    @Feature("Account Recovery")
    @Story("Verify personal number input validation and agreement acceptance during account recovery process")
    @Description("Tests the account recovery flow by selecting language, entering invalid and valid personal numbers, checking input border colors," +
            " verifying continue button state, selecting birth date, agreeing to terms, and navigating back.")
    @Severity(SeverityLevel.NORMAL)
    public void testAccountRecoveryInputValidation(Language language) {

        authorisationPageSteps
                .clickOnLanguageSwitcherButton()
                .chooseLanguageAccordingProvidedLanguage(language)
                .clickOnRecoveryAccount()
                .enterPersonalNumber("");

        softAssert.assertTrue(
                passwordRecoverySteps.getPersonalNumberInputTopBorderColor(ERRORED_BORDER)
                        .contains(ERRORED_BORDER.getRgbaValue()), BORDER_ERROR.getMessage()
        );

        passwordRecoverySteps.enterPersonalNumber(RandomStringUtils.randomAlphanumeric(9));

        softAssert.assertTrue(
                passwordRecoverySteps.getPersonalNumberInputTopBorderColor(VALID_BORDER)
                        .contains(VALID_BORDER.getRgbaValue()),
                BORDER_VALID.getMessage()
        );

        softAssert.assertFalse(
                passwordRecoverySteps.continueButtonIsEnable(),
                CONTINUE_BUTTON_SHOULD_BE_DISABLED.getMessage()
        );

        passwordRecoverySteps
                .chooseBirthDate()
                .chooseYear()
                .chooseMonth()
                .chooseDay();

        softAssert.assertFalse(
                passwordRecoverySteps.continueButtonIsEnable(),
                CONTINUE_BUTTON_SHOULD_BE_DISABLED_AFTER_BIRTHDATE.getMessage()
        );

        passwordRecoverySteps
                .clickOnAgreeTermsCheckBox()
                .clickOnRedCircleToExtendWholeAgreement()
                .clickOnAgreeButtonOnAgreementTermsPopuop()
                .waitContinueButtonToBeEnable();

        softAssert.assertTrue(
                passwordRecoverySteps.continueButtonIsEnable(),
                CONTINUE_BUTTON_SHOULD_BE_ENABLED.getMessage()
        );

        passwordRecoverySteps.clickOnGoBackButton();
    }

    @Test(priority = 4, dataProvider = "languageProvider", dataProviderClass = DataProviderClass.class)
    @Feature("Password Recovery")
    @Story("Submit incorrect recovery data")
    @Description("This test submits incorrect personal and birthdate data during password recovery and verifies the displayed error.")
    @Severity(SeverityLevel.NORMAL)
    public void incorrectDataValidationTestInPasswordRecovery(Language language) {

        authorisationPageSteps
                .clickOnLanguageSwitcherButton()
                .chooseLanguageAccordingProvidedLanguage(language)
                .clickOnRecoveryAccount()
                .enterPersonalNumber(RandomStringUtils.randomAlphanumeric(9))
                .chooseBirthDate()
                .chooseYear()
                .chooseMonth()
                .chooseDay()
                .clickOnAgreeTermsCheckBox()
                .clickOnRedCircleToExtendWholeAgreement()
                .clickOnAgreeButtonOnAgreementTermsPopuop()
                .waitContinueButtonToBeEnable()
                .clickOnContinueButton();

        softAssert.assertTrue(
                authorisationPageSteps.validateErrorNotificationIsDisplayed(),
                ERROR_NOTIFICATION_NOT_DISPLAYED.getMessage()
        );

        softAssert.assertEquals(
                authorisationPageSteps.getTextFromErrorMessage(),
                GLOBAL_ERROR_PROVIDED_DATA_IS_INCORRECT.get(language),
                ASSERT_EQUALS_FAIL.getMessage()
        );

        passwordRecoverySteps
                .clickOnCloseButtonOnErrorNotification()
                .clickOnGoBackButton();
    }

    @AfterClass
    public void afterclass() {
        softAssert.assertAll();
    }
}
