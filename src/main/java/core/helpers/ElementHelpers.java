package core.helpers;

import com.utils.handler.ElementHelper;
import core.base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelpers extends BaseTest {

    private static final String operatingSystem = System.getProperty("os.name");

    public static void waitForElement(WebElement element, int Time) {
        WebDriverWait wait = new WebDriverWait(webDriver, Time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClick(WebElement element, int Time) {
        WebDriverWait wait = new WebDriverWait(webDriver, Time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public static void hoverOnElement(WebElement element) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).perform();
    }

    public static void safeClick(WebElement element) {
        ElementHelper.safeClick(element);
    }

    public static void updateAllText(WebElement element, String newText) {
        if (operatingSystem.equals("Mac OS X")) {
            element.sendKeys(Keys.chord(Keys.COMMAND, "a"), newText);
        } else {
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"), newText);
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
