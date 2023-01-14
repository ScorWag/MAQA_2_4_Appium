package ru.netology.qa.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class MainScreen {

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement userInput;
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement buttonChange;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement textToBeChanged;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement buttonActivity;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/text")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement textNewActivity;

    private AppiumDriver driver;

    public MainScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}


