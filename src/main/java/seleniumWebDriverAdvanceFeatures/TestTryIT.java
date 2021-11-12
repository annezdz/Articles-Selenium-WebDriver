package seleniumWebDriverAdvanceFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestTryIT {

    public static WebDriver driver = null;

    public static void main(String[] args) {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



        driver.switchTo().frame("iframeResult");
       // driver.findElement(By.xpath("button[onclick='myFunction()']")).click();
        driver.switchTo().defaultContent();


        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println(frames.size());

        for(WebElement frame : frames){
            System.out.println(frame.getAttribute("id"));
        }

    }
}
