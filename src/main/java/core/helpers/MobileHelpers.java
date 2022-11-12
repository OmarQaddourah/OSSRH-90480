package core.helpers;

import core.base.MobileBaseTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class MobileHelpers extends MobileBaseTest {

    public static void waitForElement(AndroidElement element, int Time) {
        WebDriverWait wait = new WebDriverWait(appiumDriver.getDriver(), Time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void touchActionScrolling(int width, int startY, int endY) {
        new TouchAction(appiumDriver.getDriver()).press(point(width, startY)).waitAction(waitOptions(Duration.ofSeconds(1)))
                .moveTo(point(width, endY)).release().perform();
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
                new TouchAction(appiumDriver.getDriver()).press(point(startX, height)).waitAction(waitOptions(Duration.ofSeconds(1)))
                        .moveTo(point(endX, height)).release().perform();
            }
        }
    }
}