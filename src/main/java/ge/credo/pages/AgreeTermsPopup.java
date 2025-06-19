package ge.credo.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AgreeTermsPopup extends Commons{

    public AgreeTermsPopup(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='primary circle-btn']")
    private WebElement circleBtnToExtendAgreement;

    @FindBy(xpath = "//div[contains(@class, 'agreement-wrapper')]//button[not(contains(@class, 'circle-btn'))]")
    private WebElement agreeButtonOnAgreementTermsPopup;

    @FindBy(css = ".primary .btn-loading")
    private WebElement agreeButtonLoader;
}
