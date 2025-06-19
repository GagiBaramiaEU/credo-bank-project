package ge.credo.steps;

import ge.credo.data.Language;
import ge.credo.pages.LanguageSwitcherPopup;
import ge.credo.steps.authorisationSteps.AuthorisationPageSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LanguageSwitcherPopupSteps extends CommonSteps<LanguageSwitcherPopupSteps> {
    LanguageSwitcherPopup languageSwitcherPopup;

    public LanguageSwitcherPopupSteps(WebDriver driver) {
        super(driver);
        languageSwitcherPopup = new LanguageSwitcherPopup(driver);
    }

    @Step("Choose Georgian language")
    public LanguageSwitcherPopupSteps chooseGeoLanguage() {
        utils.jsClick(languageSwitcherPopup.getGeoLanguageOption());
        return this;
    }

    @Step("Choose Megrelian language")
    public LanguageSwitcherPopupSteps chooseMegrelLanguage() {
        utils.jsClick(languageSwitcherPopup.getMegrelLanguageOption());
        return this;
    }

    @Step("Choose Svan language")
    public LanguageSwitcherPopupSteps chooseSvanLanguage() {
        utils.jsClick(languageSwitcherPopup.getSvanLanguageOption());
        return this;
    }

    @Step("Choose language according to provided language: {language}")
    public AuthorisationPageSteps chooseLanguageAccordingProvidedLanguage(Language language) {
        switch (language) {
            case GEO_LANGUAGE -> chooseGeoLanguage();
            case MEGREL_LANGUAGE -> chooseMegrelLanguage();
            case SVAN_LANGUAGE -> chooseSvanLanguage();
            default -> throw new IllegalArgumentException("Unsupported language: " + language);
        }
        return new AuthorisationPageSteps(driver);
    }
}
