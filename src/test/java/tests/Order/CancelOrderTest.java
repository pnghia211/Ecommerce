package tests.Order;

import org.testng.annotations.Test;
import test_flows.Order.CancelOrderFlow;
import tests.BaseTest;

public class CancelOrderTest extends BaseTest {

    @Test
    public void testCancelCartOrder() {
        CancelOrderFlow cancelOrderFlow = new CancelOrderFlow(appiumDriver);
        cancelOrderFlow.goHomeScreen();
        cancelOrderFlow.orderProduct();
        cancelOrderFlow.goCartScreen();
        cancelOrderFlow.verifyCartOrderMsg();
        cancelOrderFlow.cancelOrder();
        cancelOrderFlow.verifyEmptyCart();
    }
}
