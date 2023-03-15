package core.helpers;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.base.BaseTest.webDriver;
import static core.base.MobileBaseTest.appiumDriver;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class MobileHelpers {

    private static final int TIME_OUT_IN_SECONDS = 60;
    private static WebDriverWait webDriverWait;

    public static void elementToBeVisible(WebElement webElement) {
        webDriverWait = new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void elementToBeClickable(WebElement webElement) {
        webDriverWait = new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void touchActionScrolling(int width, int startY, int endY) {
        new TouchAction(appiumDriver.getDriver()).press(point(width, startY))
                .waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(width, endY)).release().perform();
    }

    public static void scrollTo(String direction, int times) {
        if (direction.equals("down")) {
            Dimension dimensions = appiumDriver.getDriver().manage().window().getSize();
            int width = dimensions.getWidth() / 2;
            for (int i = 0; i < times; i++) {
                int startY = (int) (dimensions.getHeight() * 0.7);
                int endY = (int) (dimensions.getHeight() * 0.5);
                touchActionScrolling(width, startY, endY);
            }
        }
        if (direction.equals("up")) {
            Dimension dim = appiumDriver.getDriver().manage().window().getSize();
            int width = dim.getWidth() / 2;
            for (int i = 0; i < times; i++) {
                int startY = (int) (dim.getHeight() * 0.3);
                int endY = (int) (dim.getHeight() * 0.7);
                touchActionScrolling(width, startY, endY);
            }
        }
        if (direction.equals("left")) {
            Dimension dim = appiumDriver.getDriver().manage().window().getSize();
            int height = dim.getWidth() / 2;
            for (int i = 0; i < times; i++) {
                int startX = dim.getWidth() / 2;
                int endX = dim.getWidth() / 3;
                new TouchAction(appiumDriver.getDriver()).press(point(startX, height))
                        .waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(endX, height))
                        .release().perform();
            }
        }
    }

    public static void hideKeyboard() {
        try {
            appiumDriver.getDriver().hideKeyboard();
        } catch (Exception ignored) {}
    }
}