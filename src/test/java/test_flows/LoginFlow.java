package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Components.LoginComponent;
import models.Components.RegisterComponent;
import models.Components.global.MainScreenComponent;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.Assert;

public class LoginFlow extends BaseFlow {

    String email;
    String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String email, String password) {
        super(appiumDriver);
        this.email = email;
        this.password = password;
    }

    public void inputLoginCred() {
        MainScreenComponent mainScreenComp = new MainScreenComponent(appiumDriver);
        LoginComponent loginComp = mainScreenComp.loginComponent();
        loginComp.inputEmail(email);
        loginComp.inputPassword(password);
    }

    public void clickLoginBtn() {
        MainScreenComponent mainScreenComp = new MainScreenComponent(appiumDriver);
        LoginComponent loginComp = mainScreenComp.loginComponent();
        loginComp.clickLoginBtn();
    }

    public void verifyLoginCred() {
        LoginComponent loginComp = new MainScreenComponent(appiumDriver).loginComponent();
        boolean isInvalidEmail = EmailValidator.getInstance().isValid(email);
        boolean isInvalidPassword = password.length() > 7;

        if (!isInvalidEmail) {
            verifyInvalidEmail(loginComp);
        }
        if (!isInvalidPassword) {
            verifyInvalidPassword(loginComp);
        }
        if (isInvalidEmail && isInvalidPassword) {
            verifyValidCred(loginComp);
        }
    }

    private void verifyInvalidEmail(LoginComponent loginComp) {
        String actualInvalid = loginComp.getErrorMsg();
        String expected = "Please provide correct credentials";
        Assert.assertEquals(actualInvalid, expected);
    }

    private void verifyInvalidPassword(LoginComponent loginComp) {
        String actualInvalid = loginComp.getErrorMsg();
        String expected = "Please provide correct credentials";
        Assert.assertEquals(actualInvalid, expected);
    }

    private void verifyValidCred(LoginComponent loginComp) {
        if (!loginComp.signoutBtnDisplaying()) {
            Assert.fail("[ERR] login fail!!!");
        }
    }
}
