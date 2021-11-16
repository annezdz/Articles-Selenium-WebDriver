package parameterizedTests;

import com.beust.jcommander.Parameter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParametersFromXML {

    @Parameters({"browser","env"})
    @Test
    public void getBrowser(String browser, String environment){
        System.out.println(browser + " - " + environment);
    }
}
