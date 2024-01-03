package models.Components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    private final By emailSel = MobileBy.AccessibilityId("email");
    private final By nameSel = MobileBy.AccessibilityId("name");
    private final By phoneSel = MobileBy.AccessibilityId("phone");
    private final By passwordSel = MobileBy.AccessibilityId("password");
    private final By registerAccountBtnSel = MobileBy.AccessibilityId("registerAccountBtn");
    private final By registerBtnSel = MobileBy.AccessibilityId("registerBtn");
    private final By backToLoginBtnSel = MobileBy.AccessibilityId("backToLoginBtn");
    private final By registerSucceedSel = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Registration Succeeded\")");
    private final By registerErrorMsgSel = MobileBy.xpath("//*[contains(@text, \"Please fill in the form correctly\")]");

    public RegisterComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public RegisterComponent inputEmail(String emailTxt) {
        MobileElement emailEle = appiumDriver.findElement(emailSel);
        emailEle.clear();
        emailEle.sendKeys(emailTxt);
        return this;
    }

    public RegisterComponent inputName(String nameTxt) {
        MobileElement emailEle = appiumDriver.findElement(nameSel);
        emailEle.clear();
        emailEle.sendKeys(nameTxt);
        return this;
    }

    public RegisterComponent inputPhone(String phoneTxt) {
        MobileElement emailEle = appiumDriver.findElement(phoneSel);
        emailEle.clear();
        emailEle.sendKeys(phoneTxt);
        return this;
    }

    public RegisterComponent inputPassword(String passwordTxt) {
        MobileElement emailEle = appiumDriver.findElement(passwordSel);
        emailEle.clear();
        emailEle.sendKeys(passwordTxt);
        return this;
    }

    public void clickRegisterAccountBtn() {
        appiumDriver.findElement(registerAccountBtnSel).click();
    }

    public void clickRegister() {
        appiumDriver.findElement(registerBtnSel).click();
    }

    public void clickBackLoginBtn() {
        appiumDriver.findElement(backToLoginBtnSel).click();
    }

    public String getRegisterErrStr() {
        return appiumDriver.findElement(registerErrorMsgSel).getText();
    }

    public String getRegisterSucceedStr() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 3);
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(registerSucceedSel)));
        return appiumDriver.findElement(registerSucceedSel).getText();
    }
}
