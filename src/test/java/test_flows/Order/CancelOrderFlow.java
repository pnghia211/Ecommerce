package test_flows.Order;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Components.order.CartComponent;
import models.Components.HomeComponent;
import models.Components.global.MainScreenComponent;
import org.testng.Assert;
import test_flows.BaseFlow;

public class CancelOrderFlow extends BaseFlow {

    public CancelOrderFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void orderProduct() {
        MainScreenComponent mainScreenComp = new MainScreenComponent(appiumDriver);
        HomeComponent homeComp = mainScreenComp.homeComp();
        homeComp.swipeUp();
        homeComp.clickAddCartBtn();
    }

    public void verifyCartOrderMsg () {
        HomeComponent homeComp = new MainScreenComponent(appiumDriver).homeComp();
        String expected = "Go to your cart to complete order";
        String actual = homeComp.getCartOrderMsg();
        Assert.assertEquals(expected,actual);
    }

    public void cancelOrder () {
        CartComponent cartComp = new MainScreenComponent(appiumDriver).cartComp();
        cartComp.cancelOrder();
    }

    public void verifyEmptyCart () {
        CartComponent cartComp = new MainScreenComponent(appiumDriver).cartComp();
        cartComp.verifyEmptyCart();
    }


}
