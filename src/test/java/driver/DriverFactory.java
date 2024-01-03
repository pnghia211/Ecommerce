package driver;

import Platforms.Platform;
import Supports.MobileCapsTypeEx;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapsTypeEx {

    private static AppiumDriver<MobileElement> appiumDriver = null;

    public static AppiumDriver<MobileElement> getDriver(Platform platform) {
        String targetServer = "http://192.168.1.140:4723/wd/hub";
        DesiredCapabilities desiredCap = new DesiredCapabilities();

        desiredCap.setCapability(PLATFORM_NAME, platform);
        desiredCap.setCapability(AUTOMATION_NAME, "uiautomator2");
        desiredCap.setCapability(UDID, "emulator-5554");
        desiredCap.setCapability(APP_PACKAGE, "com.tuhuynh.sdetproecommerce");
        desiredCap.setCapability(APP_ACTIVITY, "host.exp.exponent.MainActivity");
//        desiredCap.setCapability(SYSTEM_PORT, "8300");

        if (appiumDriver == null) {
            URL appiumServer = null;

            try {
                appiumServer = new URL(targetServer);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (appiumServer == null) {
                throw new IllegalArgumentException("Cannot start appium session");
            }
        }
        appiumDriver = new AndroidDriver<>(desiredCap);
        appiumDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        return appiumDriver;
    }

    public void quitAppiumDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}
