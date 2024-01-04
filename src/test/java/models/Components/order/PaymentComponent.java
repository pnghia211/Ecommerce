package models.Components.order;

import Supports.CreditCard;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PaymentComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    private final By cashOnDeliverySel = MobileBy.AccessibilityId("Cash on Delivery");
    private final By bankTransferSel = MobileBy.AccessibilityId("Bank Transfer");
    private final By cardPaymentSel = MobileBy.AccessibilityId("Card Payment");
    private final By subCardPaymentSel = MobileBy.id("android:id/text1");
    private final By cardPaymentListSel = MobileBy.id("android:id/text1");
    private final By confirmBtnSel = MobileBy.AccessibilityId("confirmBtn");

    int walletIndex = 0;
    int visaIndex = 1;
    int masterCardIndex = 2;
    int otherIndex = 3;

    public PaymentComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void selectCashOnDelivery() {
        appiumDriver.findElement(cashOnDeliverySel).click();
        appiumDriver.findElement(confirmBtnSel).click();
    }

    public void selectBankTransfer() {
        appiumDriver.findElement(bankTransferSel).click();
        appiumDriver.findElement(confirmBtnSel).click();
    }

    public void selectCardPayment(CreditCard creditCard) {
        appiumDriver.findElement(cardPaymentSel).click();
        appiumDriver.findElement(subCardPaymentSel).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardPaymentListSel));
        List<MobileElement> creditCardType = appiumDriver.findElements(cardPaymentListSel);

        switch (creditCard) {
            case WALLET:
                creditCardType.get(walletIndex).click();
            case VISA:
                creditCardType.get(visaIndex).click();
            case MASTER_CARD:
                creditCardType.get(masterCardIndex).click();
            case OTHER:
                creditCardType.get(otherIndex).click();
        }
        appiumDriver.findElement(confirmBtnSel).click();
    }
}
