package ge.credo.pages.authorisationPages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class AuthorisationPage {

    public AuthorisationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    private WebElement usernameField;

    @FindBy(id = "newPass")
    private WebElement passwordField;

    @FindBy(id = "submitAuth")
    private WebElement loginButton;

    @FindBy(css = ".auth .loading")
    private WebElement authorisationLoader;

    @FindBy(id = "forgotPass")
    private WebElement forgotPassButton;
}
