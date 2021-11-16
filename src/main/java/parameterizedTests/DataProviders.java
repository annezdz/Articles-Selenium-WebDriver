package parameterizedTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviders {

    @DataProvider(name = "dp1")
    public static Object[][] getData(Method method){

        Object[][] data = null;
        if(method.getName().equals("testLogin")){
            data = new Object[2][2];
            data[0][0] = "raman";
            data[0][1] = "123456";

            data[1][0] = "ahura";
            data[1][1] = "789101";
        }else{
            data = new Object[2][3];
            data[0][0] = "raman";
            data[0][1] = "123456";
            data[0][2] = "teste@teste.com";

            data[1][0] = "ahura";
            data[1][1] = "789101";
            data[1][2] = "uzuzu@zuzu.com";
        }
        return data;
    }

}
