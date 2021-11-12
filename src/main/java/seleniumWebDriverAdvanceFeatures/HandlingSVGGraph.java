package seleniumWebDriverAdvanceFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingSVGGraph {

    public static WebDriver driver = null;

    public static void main(String[] args) {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.get("https://www.covid19india.org/");

        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("(//div[@class='cell'])[8]")))
                .click();
        driver.findElement(By.xpath("//span[normalize-space()='See more details']")).click();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<WebElement> graphPoints = driver.findElements(By.xpath("//*[name()='svg' and @preserveAspectRatio='xMidYMid meet']"));
        for(WebElement point : graphPoints ){
            Actions action = new Actions(driver);
            action.moveToElement(point).perform();
            System.out.println(driver.findElement(By.xpath("//div[@class='stats is-confirmed']//div[@class='stats-bottom']/h2")).getText());
        }
    }
}
