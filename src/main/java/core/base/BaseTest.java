package core.base;

import com.utils.PropReader;
import drivers_initializer.drivers.SelInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class BaseTest {

    public static WebDriver webDriver;
    public static HashMap<String, Object> globalMap = new HashMap<>();

    @BeforeMethod
    public static void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(PropReader.readConfig("googleUrl"));
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
