package models.Components;

import Supports.SwipeEx;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;

public class HomeComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    private By cartBtnSel = MobileBy.AccessibilityId("addToCartBtn");
    private By cartMsgSel = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Go to your cart to complete order\")");
    private By searchBarSel = MobileBy.AccessibilityId("searchInput");
    private By productInfoSel = MobileBy.AccessibilityId("productItem");
    private By productNameSel = MobileBy.AccessibilityId("productName");
    private By productPriceSel = MobileBy.AccessibilityId("productPrice");

    public HomeComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void swipeUp() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBarSel));
        SwipeEx swipeEx = new SwipeEx(appiumDriver);
        swipeEx.swipeUp();
    }

    public List<MobileElement> productPriceList() {
        return appiumDriver.findElements(productPriceSel);
    }

    public void clickAddCartBtn() {
        List<MobileElement> randomProduct = appiumDriver.findElements(cartBtnSel);
        if (randomProduct.isEmpty()) {
            Assert.fail("[ERR] product list is empty!!!");
        }
        for (MobileElement mobileElement : randomProduct) {
            mobileElement.click();
        }
    }

    public String getCartOrderMsg() {
        return appiumDriver.findElement(cartMsgSel).getText();
    }


}
