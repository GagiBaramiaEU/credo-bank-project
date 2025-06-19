package ge.credo.data;

import org.testng.annotations.DataProvider;

import static ge.credo.data.Language.*;

public class DataProviderClass {

    @DataProvider(name = "languageProvider")
    public static Object[][] languageData() {
        return new Object[][]{
                {GEO_LANGUAGE},
                {SVAN_LANGUAGE},
                {MEGREL_LANGUAGE}
        };
    }
}
