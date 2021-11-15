package testNGLearning;

import org.junit.Assert;
import org.testng.annotations.Test;

public class TestFailure {

    @Test
    public void doLogin(){
        Assert.fail("Failing the login test");
        System.out.println("Capture screenshot");
    }
}
