package models.Components.order;

import com.google.gson.Gson;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.Components.HomeComponent;
import models.Components.global.MainScreenComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests_data.Models.DataObjectBuilder;
import tests_data.Models.ShippingDataObject;

import java.security.GuardedObject;
import java.util.regex.Pattern;

public class ConfirmComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    private final By address1Sel = MobileBy.AccessibilityId("confirmShippingAdd1");
    private final By address2Sel = MobileBy.AccessibilityId("confirmShippingAdd2");
    private final By citySel = MobileBy.AccessibilityId("confirmCity");
    private final By zipcodeSel = MobileBy.AccessibilityId("confirmZIPCode");
    private final By countrySel = MobileBy.AccessibilityId("confirmCountry");
    private final By confirmSel = MobileBy.AccessibilityId("placeOrderBtn");
    private final By orderMsgSel = MobileBy.xpath("//*[contains(@text, \"Order Completed\")]");

    public ConfirmComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public String getAddress1 () {
        return appiumDriver.findElement(address1Sel).getText();
    }

    public String getAddress2 () {
        return appiumDriver.findElement(address2Sel).getText();
    }

    public String getCity () {
        return appiumDriver.findElement(citySel).getText();
    }

    public String getZipcode () {
        return appiumDriver.findElement(zipcodeSel).getText();
    }

    public String getCountry () {
        return appiumDriver.findElement(countrySel).getText();
    }

    public void clickConfirm () {
        appiumDriver.findElement(confirmSel).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderMsgSel));
    }
}
