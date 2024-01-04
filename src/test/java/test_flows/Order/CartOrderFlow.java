package test_flows.Order;

import Supports.CreditCard;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Components.order.CartComponent;
import models.Components.HomeComponent;
import models.Components.login.LoginComponent;
import models.Components.global.MainScreenComponent;
import models.Components.order.ConfirmComponent;
import models.Components.order.PaymentComponent;
import models.Components.order.ShippingAddressComponent;
import org.testng.Assert;
import test_flows.BaseFlow;
import tests_data.Models.DataObjectBuilder;
import tests_data.Models.ShippingDataObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartOrderFlow extends BaseFlow {

    public CartOrderFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void orderProduct() {
        MainScreenComponent mainScreenComp = new MainScreenComponent(appiumDriver);
        HomeComponent homeComp = mainScreenComp.homeComp();
        homeComp.swipeUp();
        homeComp.clickAddCartBtn();
        verifyCartOrderMsg();
    }

    private void verifyCartOrderMsg() {
        HomeComponent homeComp = new MainScreenComponent(appiumDriver).homeComp();
        String expected = "Go to your cart to complete order";
        String actual = homeComp.getCartOrderMsg();
        Assert.assertEquals(expected, actual);
    }

    public void verifyCartOrder() {
        CartComponent cartComp = new MainScreenComponent(appiumDriver).cartComp();
        cartComp.verifyCart();
    }

    public void inputLoginData() {
        LoginComponent loginComp = new MainScreenComponent(appiumDriver).loginComp();
        loginComp.inputLoginCred();
        loginComp.signoutBtnDisplaying();
    }

    public void clickCheckout() {
        CartComponent cartComp = new MainScreenComponent(appiumDriver).cartComp();
        cartComp.clickCheckoutBtn();
    }

    public void inputShippingData() {
        ShippingAddressComponent shippingAddressComp = new MainScreenComponent(appiumDriver).shippingAddressComp();
        String shippingDataLoc = "/src/test/java/tests_data/ShippingData.json";
        ShippingDataObject shippingDataObj = DataObjectBuilder.buildDataObject(shippingDataLoc, ShippingDataObject.class);
        shippingAddressComp.inputPhone(shippingDataObj.getPhone());
        shippingAddressComp.inputShippingAdd1(shippingDataObj.getShippingAddress1());
        shippingAddressComp.inputShippingAdd2(shippingDataObj.getShippingAddress2());
        shippingAddressComp.inputShippingCity(shippingDataObj.getCity());
        shippingAddressComp.inputZipcode(shippingDataObj.getZipcode());
        shippingAddressComp.selectCountry(shippingDataObj.getCountry());
        clickConfirm();
    }

    private void clickConfirm () {
        ShippingAddressComponent shippingAddressComp = new MainScreenComponent(appiumDriver).shippingAddressComp();
        shippingAddressComp.clickConfirmBtn();
    }

    public void selectCOD () {
        PaymentComponent paymentComp = new MainScreenComponent(appiumDriver).paymentComp();
        paymentComp.selectCashOnDelivery();
    }

    public void selectBankTransfer () {
        PaymentComponent paymentComp = new MainScreenComponent(appiumDriver).paymentComp();
        paymentComp.selectBankTransfer();
    }

    public void selectPayment (CreditCard creditCard) {
        PaymentComponent paymentComp = new MainScreenComponent(appiumDriver).paymentComp();
        paymentComp.selectCardPayment(creditCard);
    }

    public void verifyShippingLoc () {
        String shippingInfo  = "/src/test/java/tests_data/ShippingData.json";
        ShippingDataObject shippingDataObj = DataObjectBuilder.buildDataObject(shippingInfo, ShippingDataObject.class);
        ConfirmComponent confirmComp = new MainScreenComponent(appiumDriver).confirmComp();

        Pattern patternAdd1 = Pattern.compile(shippingDataObj.getShippingAddress1());
        Matcher matcherAdd1 = patternAdd1.matcher(confirmComp.getAddress1());
        if(!matcherAdd1.find()) Assert.fail("[ERR] shipping address 1 is not correct!!!");

        Pattern patternAdd2 = Pattern.compile(shippingDataObj.getShippingAddress2());
        Matcher matcherAdd2 = patternAdd2.matcher(confirmComp.getAddress2());
        if(!matcherAdd2.find()) Assert.fail("[ERR] shipping address 2 is not correct!!!");

        Pattern patternCity = Pattern.compile(shippingDataObj.getCity());
        Matcher matcherCity = patternCity.matcher(confirmComp.getCity());
        if(!matcherCity.find()) Assert.fail("[ERR] City is not correct!!!");

        Pattern patternZipcode = Pattern.compile(shippingDataObj.getZipcode());
        Matcher matcherZipcode = patternZipcode.matcher(confirmComp.getZipcode());
        if(!matcherZipcode.find()) Assert.fail("[ERR] Zip code is not correct!!!");

        Pattern patternCountry = Pattern.compile(shippingDataObj.getCountry());
        Matcher matcherCountry = patternCountry.matcher(confirmComp.getCountry());
        if(!matcherCountry.find()) Assert.fail("[ERR] Country is not correct!!!");
    }

    public void placeOrder () {
        ConfirmComponent confirmComp = new MainScreenComponent(appiumDriver).confirmComp();
        confirmComp.clickConfirm();
    }
}
