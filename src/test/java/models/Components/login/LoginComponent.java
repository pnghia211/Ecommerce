package models.Components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.Components.global.MainScreenComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests_data.Models.DataObjectBuilder;
import tests_data.Models.LoginDataObject;

public class LoginComponent {
    private final AppiumDriver<MobileElement> appiumDriver;

    private final By emailSel = MobileBy.AccessibilityId("emailInput");
    private final By passwordSel = MobileBy.AccessibilityId("passwordInput");
    private final By loginBtnSel = MobileBy.AccessibilityId("loginBtn");
    private final By signoutBtn = MobileBy.AccessibilityId("signOutBtn");
    private final By errorMsgSel = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Please provide correct credentials\")");

    public LoginComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void inputEmail(String emailTxt) {
        appiumDriver.findElement(emailSel).sendKeys(emailTxt);
    }

    public void inputPassword(String passwordTxt) {
        appiumDriver.findElement(passwordSel).sendKeys(passwordTxt);
    }

    public void clickLoginBtn() {
        appiumDriver.findElement(loginBtnSel).click();
    }

    public String getErrorMsg() {
        return appiumDriver.findElement(errorMsgSel).getText();
    }

    public boolean signoutBtnDisplaying() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signoutBtn));
        return appiumDriver.findElement(signoutBtn).isDisplayed();
    }

    public void inputLoginCred() {
        String loginDataCred = "/src/test/java/tests_data/LoginOrderData.json";
        LoginDataObject loginDataObject = DataObjectBuilder.buildDataObject(loginDataCred, LoginDataObject.class);
        LoginComponent loginComp = new MainScreenComponent(appiumDriver).loginComp();
        loginComp.inputEmail(loginDataObject.getEmail());
        loginComp.inputPassword(loginDataObject.getPassword());
        loginComp.clickLoginBtn();
    }
}
