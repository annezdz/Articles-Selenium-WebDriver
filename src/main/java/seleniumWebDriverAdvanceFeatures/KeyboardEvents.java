package seleniumWebDriverAdvanceFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class KeyboardEvents {

    public static WebDriver driver = null;

    public static void main(String[] args) {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.get("https://gmail.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.id("identifierId")).sendKeys("annezdz@hotmail.com");
        driver.findElement(By.xpath("//div[@class='xkfVF']")).click();

        //driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.chord(Keys.CONTROL + "a")).build().perform();
        actions.sendKeys(Keys.chord(Keys.CONTROL + "c")).build().perform();
        driver.findElement(By.id("identifierId")).click();
        actions.sendKeys(Keys.chord(Keys.CONTROL + "v")).build().perform();

        actions.sendKeys(Keys.ENTER).perform();

    }
}
