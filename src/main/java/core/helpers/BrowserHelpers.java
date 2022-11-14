package core.helpers;

import core.base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

import static core.helpers.ElementHelpers.waitForTime;

public class BrowserHelpers extends BaseTest {

    static ArrayList<String> numberOfTabsTwo;

    public static void scrollBy(String width) {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0," + width + ")", "");
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

    public static void acceptBrowserAlert() {
        try {
            webDriver.switchTo().alert().accept();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
