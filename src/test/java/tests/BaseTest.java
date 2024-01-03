package tests;

import Platforms.Platform;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public static AppiumDriver<MobileElement> appiumDriver;

    @BeforeTest
    public void initAppiumSession() {
        appiumDriver = DriverFactory.getDriver(Platform.android);
    }

//    @AfterTest(alwaysRun = true)
//    public void quitAppiumSession() {
//        appiumDriver.quit();
//    }
}
