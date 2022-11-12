package core.base;

import drivers_initializer.drivers.AppiumMobileDriver;
import drivers_initializer.instance.MobileDriverInstance;
import io.appium.java_client.Setting;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class MobileBaseTest {

    public static AppiumMobileDriver appiumDriver;

    public static AppiumMobileDriver getAppiumDriver() {
        appiumDriver = MobileDriverInstance.getAppiumMobileDriver();
        return appiumDriver;
    }

    @BeforeClass()
    public static void setupDriver() {
        getAppiumDriver().setup();
        appiumDriver.getDriver().setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 200);
    }

    @AfterClass()
    public static void tearDown() {
        appiumDriver.getDriver().quit();
    }
}
