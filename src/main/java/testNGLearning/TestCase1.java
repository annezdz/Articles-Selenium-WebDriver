package testNGLearning;


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

    @Test(priority = 1, groups = "functional")
    public void doRegister(){
        try{
            System.out.println("Executing register test");
        }catch (Throwable throwable){
            System.out.println("Capturing screenshot");
        }

    }

    @Test(priority = 2, groups = "functional")
    public void doLogin(){
        System.out.println("Executing login test");
    }


}
