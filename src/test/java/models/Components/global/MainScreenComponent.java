package models.Components.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Components.order.CartComponent;
import models.Components.HomeComponent;
import models.Components.login.LoginComponent;
import models.Components.RegisterComponent;
import models.Components.order.ConfirmComponent;
import models.Components.order.PaymentComponent;
import models.Components.order.ShippingAddressComponent;

public class MainScreenComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public MainScreenComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public BottomComponent bottomComp () {
        return new BottomComponent(appiumDriver);
    }
    public HomeComponent homeComp () {
        return new HomeComponent(appiumDriver);
    }
    public CartComponent cartComp () {
        return new CartComponent(appiumDriver);
    }
    public ShippingAddressComponent shippingAddressComp () {
        return new ShippingAddressComponent(appiumDriver);
    }
    public PaymentComponent paymentComp () {
        return new PaymentComponent(appiumDriver);
    }
    public ConfirmComponent confirmComp () {
        return new ConfirmComponent(appiumDriver);
    }
    public RegisterComponent registerComp() {
        return new RegisterComponent(appiumDriver);
    }
    public LoginComponent loginComp() {
        return new LoginComponent(appiumDriver);
    }
}
