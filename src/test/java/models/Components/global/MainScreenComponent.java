package models.Components.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Components.LoginComponent;
import models.Components.RegisterComponent;

public class MainScreenComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public MainScreenComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public BottomComponent bottomComp () {
        return new BottomComponent(appiumDriver);
    }

    public RegisterComponent registerComp() {
        return new RegisterComponent(appiumDriver);
    }

    public LoginComponent loginComponent() {
        return new LoginComponent(appiumDriver);
    }
}
