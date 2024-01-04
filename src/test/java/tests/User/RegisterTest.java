package tests.User;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_flows.Authen.RegisterFlow;
import tests.BaseTest;
import tests_data.Models.DataObjectBuilder;
import tests_data.Models.RegisterData;

public class RegisterTest extends BaseTest {

    @Test(dataProvider = "registerData")
    public void testUser(RegisterData registerData) {
        RegisterFlow registerFlow = new RegisterFlow(appiumDriver, registerData.getEmail(), registerData.getPhone()
                , registerData.getName(), registerData.getPassword());
        registerFlow.goUserScreen();
        registerFlow.clickRegisterAccountBtn();
        registerFlow.registerCred();
        registerFlow.clickRegisterBtn();
        registerFlow.verifyRegisterCred();
    }

    @DataProvider
    private RegisterData[] registerData() {
        String filePath = "/src/test/java/tests_data/RegisterData.json";
        return DataObjectBuilder.buildDataObject(filePath, RegisterData[].class);
    }
}
