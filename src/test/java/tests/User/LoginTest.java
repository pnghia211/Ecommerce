package tests.User;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_flows.LoginFlow;
import tests.BaseTest;
import tests_data.DataObjectBuilder;
import tests_data.Models.LoginData;
import tests_data.Models.RegisterData;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void testLogin(LoginData loginData) {
        LoginFlow loginFlow = new LoginFlow(appiumDriver, loginData.getEmail(), loginData.getPassword());
        loginFlow.goUserScreen();
        loginFlow.inputLoginCred();
        loginFlow.clickLoginBtn();
        loginFlow.verifyLoginCred();
    }

    @DataProvider
    private LoginData[] loginData() {
        String filePath = "/src/test/java/tests_data/LoginData.json";
        return DataObjectBuilder.buildDataObject(filePath, LoginData[].class);
    }
}
