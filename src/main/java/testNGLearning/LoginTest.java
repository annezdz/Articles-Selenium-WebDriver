package testNGLearning;

import browsers.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void doLogin(){

        try{
            driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1637844700&rver=7.0.6737.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26RpsCsrfState%3d1bcae29f-cf57-5bf9-5da3-64f25ae13c8c&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=90015");
            driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("annezdz@hotmail.com");
            driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
        }catch (Throwable throwable){
            // Capturing Screenshot
        }

    }

    @Test
    public void composeEmail(){
        Assert.fail("Error in composing email");
    }
}
