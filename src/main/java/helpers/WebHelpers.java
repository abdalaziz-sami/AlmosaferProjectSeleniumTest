package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.utils.PropReader.readConfig;
import static core.WebBassClass.webDriver;

public class WebHelpers {

    private static WebDriverWait wait;
    private static final String OPERATING_SYSTEM = System.getProperty("os.name");

    public static WebElement elementToBeVisible(WebElement webElement) {
        wait = new WebDriverWait(webDriver, Duration.parse(readConfig("time-out-in-seconds-web")));
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static Boolean elementToBeInvisible(WebElement webElement) {
        wait = new WebDriverWait(webDriver, Duration.parse(readConfig("time-out-in-seconds-web")));
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public static WebElement elementToBeClickable(WebElement webElement) {
        wait = new WebDriverWait(webDriver, Duration.parse(readConfig("time-out-in-seconds-web")));
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void moveToElement(WebElement webElement) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).perform();
    }

    public static void updateInputField(WebElement webElement, String text) {
        if (OPERATING_SYSTEM.equals("Mac OS X")) {
            webElement.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        for (char c : text.toCharArray()) {
            webElement.sendKeys(String.valueOf(c));
        }
    }

    public static void uploadFile(WebElement webElement, String fileName) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/TestFiles/" + fileName;
        webElement.sendKeys(filePath);
    }

    public static void switchToFrame(WebElement element) {

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public static void switchToDefaultContent() {
        webDriver.switchTo().defaultContent();
    }

    public static void implicitlyWait(int time) {

        webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
