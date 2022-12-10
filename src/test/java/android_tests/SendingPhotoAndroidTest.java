package android_tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SendingPhotoAndroidTest {
    public AndroidDriver driver;

    private static By photo = By.xpath("//android.view.ViewGroup[contains(@content-desc,'Photo taken')]");

    File classPath, imageDir, img;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "3200f0504eaca509"); //Android Emulator
        caps.setCapability("appPackage", "com.google.android.apps.photos");
        caps.setCapability("appActivity", ".home.HomeActivity");
        caps.setCapability("noReset", "true");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void sendPhotoTest() throws IOException {
        classPath = new File(System.getProperty("user.dir"));
        imageDir = new File(classPath, "/resources/images");
        img = new File(imageDir.getCanonicalFile(), "test_img.png");

        WebDriverWait wait =  new WebDriverWait(driver, 10);
        String AndroidPhotoPath = "mnt/sdcard/Pictures";
        driver.pushFile(AndroidPhotoPath + "/" + img.getName(), img);
        ExpectedCondition condition = ExpectedConditions.numberOfElementsToBe(photo, 1);
        wait.until(condition);

    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
