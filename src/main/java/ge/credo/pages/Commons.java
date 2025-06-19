package ge.credo.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class Commons {
    protected WebDriver driver;

    public Commons(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "growlText")
    private WebElement globalErrorMessage;

    @FindBy(css = ".notification-container.error")
    private WebElement errorNotificationContainer;

    @FindBy(xpath = "//section//div[contains(@class, 'close')]")
    private WebElement closeButtonOnErrorNotificationContainer;

    @FindBy(id = "languageSwitcherBtn")
    private WebElement languageSwitcherButton;
}
