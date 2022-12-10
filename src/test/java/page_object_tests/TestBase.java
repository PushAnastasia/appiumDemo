package page_object_tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests {
    public static AppiumDriver driver;

    public static void Android_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "Android Emulator"); //3200f0504eaca509
        capabilities.setCapability("app", System.getProperty("user.dir")
                + "/apps/ToDo_1.24_Apkpure.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
