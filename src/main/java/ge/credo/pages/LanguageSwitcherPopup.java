package ge.credo.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LanguageSwitcherPopup extends Commons {
    public LanguageSwitcherPopup(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='bottom-wrapper']//p[@class='paragraph-14' and text()='ქართული']")
    private WebElement geoLanguageOption;

    @FindBy(xpath = "//div[@class='bottom-wrapper']//p[@class='paragraph-14' and text()='მეგრული']")
    private WebElement megrelLanguageOption;

    @FindBy(xpath = "//div[@class='bottom-wrapper']//p[@class='paragraph-14' and text()='სვანური']")
    private WebElement svanLanguageOption;

}
