package parameterizedTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {

    @Test(dataProvider = "getData")
    public void doLogin(String username, String password){
        System.out.println(username + "---" + password);
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[3][2];
        data[0][0] = "trainer@waytoautomation.com";
        data[0][1] = "123456%";
        data[1][0] = "teste@waytoautomation.com";
        data[1][1] = "testeteste";
        data[2][0] = "blabla@blacla.com";
        data[2][1] = "teste";
        return data;
    }
}
