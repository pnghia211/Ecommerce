package models.Components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomeComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public HomeComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
}
