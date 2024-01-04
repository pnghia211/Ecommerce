package tests.Order;

import Supports.CreditCard;
import org.testng.annotations.Test;
import test_flows.Order.CartOrderFlow;
import tests.BaseTest;

public class CartOrderTest extends BaseTest {

    private CreditCard creditCard;

    @Test
    public void testCartOrder() {
        CartOrderFlow cartOrderFlow = new CartOrderFlow(appiumDriver);
        cartOrderFlow.goHomeScreen();
        cartOrderFlow.orderProduct();
        cartOrderFlow.goCartScreen();
        cartOrderFlow.verifyCartOrder();
        cartOrderFlow.goUserScreen();
        cartOrderFlow.inputLoginData();
        cartOrderFlow.goCartScreen();
        cartOrderFlow.clickCheckout();
        cartOrderFlow.inputShippingData();
        cartOrderFlow.selectBankTransfer();
        cartOrderFlow.verifyShippingLoc();
        cartOrderFlow.placeOrder();
    }
}
