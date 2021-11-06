package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Article15 {
    public static WebDriver driver = null;
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");

        WebElement confirmationAlert = driver.findElement(By.xpath("//input[@type='button']"));
        confirmationAlert.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    }
