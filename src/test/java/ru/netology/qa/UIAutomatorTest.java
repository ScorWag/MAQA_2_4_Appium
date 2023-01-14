package ru.netology.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.qa.screens.MainScreen;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.IOSMobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;


public class UIAutomatorTest {

    private AppiumDriver driver;
    enum Platform {ANDROID, IOS};
    Platform platform = Platform.ANDROID;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        if (platform.equals(Platform.ANDROID)) {
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("appium:deviceName", "Galaxy_A_50");
            desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
            desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        } else if (platform.equals(Platform.IOS)) {
            desiredCapabilities.setCapability(PLATFORM_NAME, "iOS");
            desiredCapabilities.setCapability(DEVICE_NAME, "iPhone 11");
            desiredCapabilities.setCapability(BUNDLE_ID, "ru.netology.testing.uiautomator");
            desiredCapabilities.setCapability(AUTOMATION_NAME, "XCUITest");
            driver = new IOSDriver(remoteUrl, desiredCapabilities);
        }
    }

    @Test
    public void testNotChangeTextWithEmptyField() {
        MainScreen mainScreen = new MainScreen(driver);
        String expected = mainScreen.textToBeChanged.getText();
        mainScreen.buttonChange.click();
        Assertions.assertEquals(expected, mainScreen.textToBeChanged.getText());
    }

    @Test
    public void testOpenAnotherActivity() {
        MainScreen mainScreen = new MainScreen(driver);
        String text = "Hello, I`m student!!!";
        mainScreen.userInput.sendKeys(text);
        mainScreen.buttonActivity.click();
        Assertions.assertEquals(text, mainScreen.textNewActivity.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
