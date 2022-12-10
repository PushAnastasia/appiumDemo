package android_tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class AndroidHybridAppTest {

    private static By chromeBtn = MobileBy.AccessibilityId("buttonStartWebviewCD");
    private static By gotoHomeBtn = By.id("goBack");
    private AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator1");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "Android Emulator"); //3200f0504eaca509
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("app", System.getProperty("user.dir")
                + "/apps/selendroid.apk");
        caps.setCapability("chromedriverExecutable", System.getProperty("user.dir") + "/drivers/chromedriver.exe");


        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    public void switchToWebView() {
        Set<String> contexts = driver.getContextHandles();
        for (String context: contexts) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                break;
            }
        }
    }

    @Test
    public void HybridTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(chromeBtn)).click();
        switchToWebView();
        WebElement nameInput = driver.findElement(By.id("name_input"));
        nameInput.clear();
        String name = "Ana";
        nameInput.sendKeys(name);
        driver.context("NATIVE_APP");
        driver.findElement(gotoHomeBtn).click();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
