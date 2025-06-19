package ge.credo.pages.authorisationPages;

import ge.credo.pages.Commons;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PasswordRecoveryPage extends Commons {
    @FindBy(id = "personalNumPassRecovery")
    private WebElement personalNumberInput;

    @FindBy(css = "app-date-picker .date-picker-container")
    private WebElement birthDateInput;

    @FindBy(id = "circle")
    private WebElement agreeTermsCheckBox;

    @FindBy(id = "toNextStep")
    private WebElement continueButton;

    @FindBy(id = "recoveryButtonGoBack")
    private WebElement goBackButton;

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }
}
