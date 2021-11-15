package testNGLearning;

import org.junit.Assert;
import org.testng.annotations.Test;

public class TestCase3 {

    @Test(priority = 1, groups = {"functional", "smoke"})
    public void doRegister(){
        System.out.println("Executing register test");
        //Assert.fail("User not registered success");
    }

    @Test(priority = 2, dependsOnMethods = "doRegister",groups = {"functional","smoke"})
    public void doLogin(){
        System.out.println("Executing login test");
    }

    @Test(priority = 3, dependsOnMethods = "doRegister", alwaysRun = true, groups = {"functional","smoke"})
    public void thirdTest(){
        System.out.println("Executing third test");
    }

    @Test(priority = 4, groups = "bvt")
    public void forthTest(){
        System.out.println("Executing forth test");
    }
}
