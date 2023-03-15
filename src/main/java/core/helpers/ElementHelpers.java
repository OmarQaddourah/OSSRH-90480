package core.helpers;

import com.utils.handler.ElementHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.base.BaseTest.webDriver;

public class ElementHelpers {

    private static final int TIME_OUT_IN_SECONDS = 60;
    private static WebDriverWait webDriverWait;
    private static Actions actions;
    private static final String OPERATING_SYSTEM = System.getProperty("os.name");

    public static void elementToBeVisible(WebElement webElement) {
        webDriverWait = new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void elementToBeClickable(WebElement webElement) {
        webDriverWait = new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void clickSafe(WebElement webElement) {
        ElementHelper.safeClick(webElement);
    }

    public static void scrollTo(WebElement webElement) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(false);", webElement);
    }

    public static void hoverOnElement(WebElement webElement) {
        actions = new Actions(webDriver);
        actions.moveToElement(webElement).perform();
    }

    public static void updateInputField(WebElement webElement, String text) {
        if (OPERATING_SYSTEM.equals("Mac OS X")) {
            webElement.sendKeys(Keys.chord(Keys.COMMAND, "a"), text);
        } else {
            webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
        }
    }

    public static void waitForTime(int millis) { // prefer not to be used
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
