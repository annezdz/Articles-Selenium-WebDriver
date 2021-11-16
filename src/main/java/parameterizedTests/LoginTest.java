package parameterizedTests;

import org.testng.annotations.Test;

public class LoginTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "dp1")
    public void testLogin(String username, String password){
        System.out.println(username + " - " + password );
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "dp1")
    public void testUserRegistration(String firstname, String lastname, String email){
        System.out.println(firstname + " - " + lastname + " - " + email);
    }
}
