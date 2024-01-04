package models.Components.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BottomComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    private final By homeSel = MobileBy.AccessibilityId("homeIcon");
    private final By cartSel = MobileBy.AccessibilityId("cartIcon");
    private final By userSel = MobileBy.AccessibilityId("userIcon");

    public BottomComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickHomeComp () {
        appiumDriver.findElement(homeSel).click();
    }

    public void clickCartComp () {
        appiumDriver.findElement(cartSel).click();
    }

    public void clickUserComp () {
        WebDriverWait wait = new WebDriverWait(appiumDriver,2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userSel));
        appiumDriver.findElement(userSel).click();
    }


}
