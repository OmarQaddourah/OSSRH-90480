package core.base;

import com.utils.PropReader;
import drivers_initializer.drivers.SelInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static WebDriver webDriver;

    @BeforeMethod
    public static void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(PropReader.readConfig("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        try {
            webDriver.quit();
        } finally {
            SelInstance.webDriver.set(null);
        }
    }
}
