package test_flows.Authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Components.RegisterComponent;
import models.Components.global.MainScreenComponent;
import org.testng.Assert;
import test_flows.BaseFlow;

public class RegisterFlow extends BaseFlow {

    String email;
    String phone;
    String name;
    String password;

    public RegisterFlow(AppiumDriver<MobileElement> appiumDriver, String email, String name, String phone, String password) {
        super(appiumDriver);
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.password = password;
    }

    public void clickRegisterAccountBtn() {
        MainScreenComponent mainScreenComp = new MainScreenComponent(appiumDriver);
        RegisterComponent userComp = mainScreenComp.registerComp();
        userComp.clickRegisterAccountBtn();
    }

    public void registerCred() {
        MainScreenComponent mainScreenComp = new MainScreenComponent(appiumDriver);
        RegisterComponent userComp = mainScreenComp.registerComp();
        userComp.inputEmail(email)
                .inputName(name)
                .inputPhone(phone)
                .inputPassword(password);
    }

    public void clickRegisterBtn() {
        MainScreenComponent mainScreenComp = new MainScreenComponent(appiumDriver);
        RegisterComponent userComp = mainScreenComp.registerComp();
        userComp.clickRegister();
    }

    public void verifyRegisterCred() {
        RegisterComponent registerComp = new MainScreenComponent(appiumDriver).registerComp();
        boolean isInvalidName = name.isBlank();
        boolean isInvalidEmail = email.isBlank();
        boolean isInvalidPhone = phone.isBlank();
        boolean isInvalidPassword = password.isBlank();

        if (isInvalidName) {
            verifyInvalidName(registerComp);
        }
        if (isInvalidEmail) {
            verifyInvalidEmail(registerComp);
        }
        if (isInvalidPhone) {
            verifyInvalidPhone(registerComp);
        }
        if (isInvalidPassword) {
            verifyInvalidPassword(registerComp);
        }
        if (!isInvalidName && !isInvalidEmail && !isInvalidPhone && !isInvalidPassword) {
            verifyValidCred(registerComp);
        }
    }

    private void verifyInvalidName(RegisterComponent registerComp) {
        String actualInvalid = registerComp.getRegisterErrStr();
        String expected = "Please fill in the form correctly";
        Assert.assertEquals(actualInvalid, expected);
    }

    private void verifyInvalidEmail(RegisterComponent registerComp) {
        String actualInvalid = registerComp.getRegisterErrStr();
        String expected = "Please fill in the form correctly";
        Assert.assertEquals(actualInvalid, expected);
    }

    private void verifyInvalidPhone(RegisterComponent registerComp) {
        String actualInvalid = registerComp.getRegisterErrStr();
        String expected = "Please fill in the form correctly";
        Assert.assertEquals(actualInvalid, expected);
    }

    private void verifyInvalidPassword(RegisterComponent registerComp) {
        String actualInvalid = registerComp.getRegisterErrStr();
        String expected = "Please fill in the form correctly";
        Assert.assertEquals(actualInvalid, expected);
    }

    private void verifyValidCred(RegisterComponent registerComp) {
        String actualSucceed = registerComp.getRegisterSucceedStr();
        String expected = "Registration Succeeded";
        Assert.assertEquals(actualSucceed, expected);
    }
}
