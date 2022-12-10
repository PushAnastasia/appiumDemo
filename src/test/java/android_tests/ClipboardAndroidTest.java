package android_tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ClipboardAndroidTest {
    public AndroidDriver<WebElement> driver;
    public AndroidTouchAction actions;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "Android Emulator"); //3200f0504eaca509
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/selendroid.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        actions = new AndroidTouchAction(driver);
    }

    @Test
    public void clipboardTest() {
        String text = "Hello TAU";

        MobileElement okButton = (MobileElement) driver.findElementById("android:id/button1");
        actions.tap(ElementOption.element(okButton)).perform();

        driver.setClipboardText(text);
        MobileElement nameTxt = (MobileElement) driver.findElementByAccessibilityId("my_text_fieldCD");
        nameTxt.clear();
        nameTxt.sendKeys(driver.getClipboardText());
        Assert.assertEquals(text, nameTxt.getText());
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
