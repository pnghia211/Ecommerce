package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Components.global.BottomComponent;
import models.Components.global.MainScreenComponent;

public class BaseFlow {

    protected final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void goUserScreen () {
        MainScreenComponent mainScreenComp = new MainScreenComponent(appiumDriver);
        BottomComponent bottomComp = mainScreenComp.bottomComp();
        bottomComp.clickUserComp();
    }

    public void goCartScreen () {
        MainScreenComponent mainScreenComp = new MainScreenComponent(appiumDriver);
        BottomComponent bottomComp = mainScreenComp.bottomComp();
        bottomComp.clickCartComp();
    }

    public void goHomeScreen () {
        MainScreenComponent mainScreenComp = new MainScreenComponent(appiumDriver);
        BottomComponent bottomComp = mainScreenComp.bottomComp();
        bottomComp.clickHomeComp();
    }
}
