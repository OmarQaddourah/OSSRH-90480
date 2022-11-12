package core.helpers;

import core.base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ElementHelpers extends BaseTest {

    private static final String operatingSystem = System.getProperty("os.name");
    static ArrayList<String> numberOfTabsTwo;

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

    public static void scrollBy(String width) {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0," + width + ")", "");
    }

    public static void waitForTime(int milis) { // prefer not to be used
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollSlowly(int width) {
        for (int i = 200; i <= width; i = i + 100) {
            scrollBy(String.valueOf(width));
            waitForTime(500);
        }
    }

    public static void refreshPage() {
        webDriver.navigate().refresh();
    }

    public static void updateAllText(WebElement element, String newText) {
        if (operatingSystem.equals("Mac OS X")) {
            element.sendKeys(Keys.chord(Keys.COMMAND, "a"), newText);
        } else {
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"), newText);
        }
    }

    public static void switchToTab(int tabIndex) {
        numberOfTabsTwo = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(numberOfTabsTwo.get(tabIndex));
    }

    public static void scrollToDirection(String direction) {
        if (direction.equals("bottom")) {
            ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
        }
        if (direction.equals("top")) {
            ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, 0);");
        }
    }

    public static void openNewTab(String url) {
        ((JavascriptExecutor) webDriver).executeScript("window.open('" + url + "')");
    }
}
