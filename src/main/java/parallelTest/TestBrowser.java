package parallelTest;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.util.Date;

public class TestBrowser {

    @Parameters({"browser"})
    @Test
    public void doLogin(String browser) throws InterruptedException {
        Date date = new Date();
        System.out.println("Browser name is " + browser + " -- " + date);
        Thread.sleep(2000);
    }
}


