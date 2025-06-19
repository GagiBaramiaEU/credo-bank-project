package ge.credo.pages;

import ge.credo.data.GeorgianMonth;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.Month;

public class DatePopup extends Commons {

    public DatePopup(WebDriver driver) {
        super(driver);
    }

    private final LocalDate dateMinus18Years = LocalDate.now().minusYears(18);
    private final int year = dateMinus18Years.getYear();
    private final int month = dateMinus18Years.getMonthValue();
    private final int day = dateMinus18Years.getDayOfMonth();
    private final Month javaMonth = Month.of(month);

    public WebElement getYearElement() {
        return driver.findElement(By.xpath("//p[contains(text(),'" + year + "')]"));
    }

    public WebElement getMonthElement() {
        return driver.findElement(By.xpath("//p[contains(text(),'" + GeorgianMonth.fromJavaMonth(javaMonth) + "')]"));
    }

    public WebElement getDayElement() {
        return driver.findElement(By.xpath("//p[contains(text(),'" + day + "')]"));
    }
}

