package models.Components.order;

import Supports.SwipeEx;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.Components.HomeComponent;
import models.Components.global.MainScreenComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingAddressComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    private final By phoneSel = MobileBy.AccessibilityId("phoneNum");
    private final By shippingAdd1Sel = MobileBy.AccessibilityId("shippingAdd1");
    private final By shippingAdd2Sel = MobileBy.AccessibilityId("shippingAdd2");
    private final By shippingCitySel = MobileBy.AccessibilityId("shippingCity");
    private final By shippingZIPCodeSel = MobileBy.AccessibilityId("shippingZIPCode");
    private final By countrySel = MobileBy.id("android:id/text1");
    private final By countryList = MobileBy.className("android.widget.ListView");
    private final By confirmBtnSel = MobileBy.AccessibilityId("confirmShippingFormBtn");

    public ShippingAddressComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void inputPhone(String phoneTxt) {
        appiumDriver.findElement(phoneSel).sendKeys(phoneTxt);
    }

    public void inputShippingAdd1(String shippingAdd1) {
        appiumDriver.findElement(shippingAdd1Sel).sendKeys(shippingAdd1);
    }

    public void inputShippingAdd2(String shippingAdd2) {
        appiumDriver.findElement(shippingAdd2Sel).sendKeys(shippingAdd2);
        swipeUp();
    }

    public void inputShippingCity(String shippingCity) {
        appiumDriver.findElement(shippingCitySel).sendKeys(shippingCity);
    }

    public void inputZipcode(String zipCode) {
        appiumDriver.findElement(shippingZIPCodeSel).sendKeys(zipCode);
    }

    public void selectCountry(String country) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
        appiumDriver.findElement(countrySel).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryList));
        MobileElement countryEle = appiumDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + country + "\"))"));
        countryEle.click();
    }

    public void clickConfirmBtn() {
        appiumDriver.findElement(confirmBtnSel).click();
    }

    private void swipeUp() {
        SwipeEx swipeEx = new SwipeEx(appiumDriver);
        swipeEx.swipeUp();
    }
}
