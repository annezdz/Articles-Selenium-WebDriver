package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {

    public static WebDriver driver = null;
    public static void main(String[] args) {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.americangolf.co.uk/");

        Actions actions = new Actions(driver);

        actions.moveToElement
                        (driver.findElement(By.xpath("//div/ul/li[4]/a[contains(text(), 'Golf Clubs')]")))
                .build().perform();

        driver.findElement(By.xpath("//div[@id='CLUBS_1']//span[@class='name'][normalize-space()='Drivers']")).click();

        actions.moveToElement(driver.findElement(By.xpath("//div/ul/li[5]/a[contains(text(), 'Clothing & Shoes') and @class='a-level-1']")))
                .build().perform();

        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='CLOTHFOOTW_1']/ul[@class='category-groups']/li[@class='category-group'][2]/ul/li/a/span[contains(text(), 'Shirts')]")));

        driver.findElement(By.xpath("//div[@id='CLOTHFOOTW_1']/ul[@class='category-groups']/li[@class='category-group'][2]/ul/li/a/span[contains(text(), 'Shirts')]")).click();
    }

}
