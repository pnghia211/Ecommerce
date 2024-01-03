package models.Components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CartComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public CartComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
}
