package android_tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidBuildInAppDemo {
    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage", "com.android.chrome"); //"com.android.deskclock"
        caps.setCapability("appActivity", "org.chromium.chrome.browser.document.ChromeLauncherActivity"); //.DeskClock
        caps.setCapability("noReset", "true");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void clickTest() {
        driver.findElementByAccessibilityId("More options").click();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
