package regression;


import org.testng.annotations.*;

public class TestCase1 {

    @BeforeTest
    public void creatingDBConnection(){
        System.out.println("Creating DB Conection");
    }

    @AfterTest
    public void closeDBConnection(){
        System.out.println("Closing DB Conection");
    }

    @BeforeMethod
    public void launchBrowser(){
        System.out.println("Launching browser");
    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("Closing the browser");
    }

    @Test(priority = 1)
    public void doRegister(){
        System.out.println("Executing register test");
    }

    @Test(priority = 2)
    public void doLogin(){
        System.out.println("Executing login test");
    }


}
