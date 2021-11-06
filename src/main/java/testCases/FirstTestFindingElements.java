package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class FirstTestFindingElements {

    public static void main(String[] args) {

       // WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://hotmail.com");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //WebElement username = driver.findElement(By.id("identifierId"));
//        WebElement username = driver.findElement(By.name("identifier"));
//        username.sendKeys("annezdz@hotmail.com");
//        WebElement nextButton = driver.findElement(By.xpath("//input[@id='identifierId']")).c;
//        nextButton.click();

        driver.findElement(By.xpath("//nav[@aria-label='Links rápidos']//a[@class='internal sign-in-link'][normalize-space()='Entrar']")).click();
        driver.findElement(By.id("i0116")).sendKeys("annezdz@hotmail.com");
        driver.findElement(By.id("idSIButton9")).click();

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//        WebDriverWait wait = new WebDriverWait(driver, 20);

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .pollingEvery(5, TimeUnit.SECONDS)
                .withMessage("User defined timed out after 30 seconds")
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("i0118"))).sendKeys("blablabla");


//        driver.findElement(By.id("i0118")).sendKeys("blablabla");



        driver.findElement(By.id("idSIButton9")).click();
    }
}
