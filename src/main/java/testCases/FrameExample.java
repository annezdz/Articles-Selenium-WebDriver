package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class FrameExample {

    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://paytm.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
        System.out.println("Number of Frames in this page: " + driver.findElements(By.tagName("iframe")).size());

        driver.switchTo().frame(0);

    }
}
