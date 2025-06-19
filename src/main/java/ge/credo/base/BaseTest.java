package ge.credo.base;

import ge.credo.helpers.ConfigReader;
import ge.credo.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;

public abstract class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeClass(alwaysRun = true)
    @org.testng.annotations.Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverManager.getDriver(browser);
        baseUrl = ConfigReader.getInstance().get("baseUrl");
        driver.get(baseUrl);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

