package models.Components.order;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.Components.HomeComponent;
import models.Components.global.MainScreenComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    private final By cartHeaderSel = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Cart\")");
    private final By emptyCartMsgSel = MobileBy.AccessibilityId("emptyCartSuggestionMsg");
    private final By cartTotalPriceSel = MobileBy.AccessibilityId("cartTotalPrice");
    private final By clearbtnSel = MobileBy.AccessibilityId("clearCartBtn");
    private final By checkoutBtnSel = MobileBy.AccessibilityId("checkoutBtn");

    public CartComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void cancelOrder () {
        WebDriverWait wait = new WebDriverWait(appiumDriver,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartHeaderSel));
        appiumDriver.findElement(clearbtnSel).click();
    }

    public void verifyEmptyCart () {
        if(!appiumDriver.findElement(emptyCartMsgSel).isDisplayed()) {
            Assert.fail("[ERR] cart have not been empty!!!");
        };
    }

    public void verifyCart () {
        HomeComponent homeComp = new MainScreenComponent(appiumDriver).homeComp();
        double totalPrice = 0;
        for (MobileElement price : homeComp.productPriceList()) {
            double productPrice = Double.parseDouble(price.getText().replace("$","").trim());
            totalPrice +=productPrice;
        }
        double CartTotalPrice = Double.parseDouble(appiumDriver.findElement(cartTotalPriceSel).getText().replace("$","").trim());
        Assert.assertEquals(totalPrice,CartTotalPrice);
    }

    public void clickCheckoutBtn () {
        appiumDriver.findElement(checkoutBtnSel).click();
    }
}
