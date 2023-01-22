package ru.netology.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.qa.screens.MainScreen;

import java.net.MalformedURLException;
import java.net.URL;

public class UIAutomatorTest {

    private AppiumDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "Galaxy_A_50");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity",
                "ru.netology.testing.uiautomator.MainActivity");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }


    @Test
    public void testNotChangeTextWithEmptyField() {
        MainScreen mainScreen = new MainScreen(driver);
        MobileElement textToBeChanged = mainScreen.textToBeChanged;
        textToBeChanged.isDisplayed();
        String expected = textToBeChanged.getText();
        MobileElement buttonChange = mainScreen.buttonChange;
        buttonChange.isDisplayed();
        buttonChange.click();
        textToBeChanged.isDisplayed();
        Assertions.assertEquals(expected, textToBeChanged.getText());
    }

    @Test
    public void testOpenAnotherActivity() {
        MainScreen mainScreen = new MainScreen(driver);
        String text = "Hello, I`m student!!!";
        MobileElement userInput = mainScreen.userInput;
        userInput.isDisplayed();
        userInput.sendKeys(text);
        MobileElement buttonActivity = mainScreen.buttonActivity;
        buttonActivity.isDisplayed();
        buttonActivity.click();
        MobileElement textNewActivity = mainScreen.textNewActivity;
        textNewActivity.isDisplayed();
        Assertions.assertEquals(text, textNewActivity.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
