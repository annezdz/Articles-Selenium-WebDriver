package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Article17 {

    public static WebDriver driver = null;

    public static void main(String[] args) {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.americangolf.co.uk/");

        /*
        * Simular o efeito do SHIFT para letras maiúsculas
        * */

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//input[@id='q']")))
                .click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
    }
}
