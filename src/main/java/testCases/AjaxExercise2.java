package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AjaxExercise2 {
    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://in.search.yahoo.com/?fr2=inr");
        driver.findElement(By.xpath("//input[@id='yschsp']")).sendKeys("hello");

        List<WebElement> values = driver.findElements(By.xpath("//div[@class='sa-sbx-container']"));
        Thread.sleep(5000);

        for(int i = 0; i < values.size(); i++){
            System.out.println(values.get(i).getText());
        }

        //System.out.println(driver.findElement(By.xpath("//div/ul/li/span/b[@class='yui3-highlight']")).getText());
    }
}
