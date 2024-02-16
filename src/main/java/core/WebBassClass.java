package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebBassClass {

    public static WebDriver webDriver;

    @BeforeClass()
    public static void setupWebDriver() {

        webDriver.manage().window().maximize();

        webDriver.get("");
    }

    @AfterClass(alwaysRun = true)
    public static void closeWebDriver() {
        webDriver.quit();
    }
}
