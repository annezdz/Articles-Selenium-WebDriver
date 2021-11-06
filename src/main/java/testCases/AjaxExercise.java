package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AjaxExercise {

    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.makemytrip.com/");


        //driver.findElement(By.xpath("//input[@data-cy='fromCity']")).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//input[@data-cy='fromCity']")))
                .click().keyDown(Keys.SHIFT).click().build().perform();

        WebElement test = driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-1']/div/div/p[@class='font14 appendBottom5 blackText']"));


        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.DOWN);
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ENTER);

        System.out.println(driver.findElement(By.xpath("//input[@data-cy='fromCity']")).getAttribute("value"));



    }
}
