package seleniumWebDriverAdvanceFeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testCases.WebDriver;

import java.util.concurrent.TimeUnit;

public class ActionsAPIHandlingMouseOverEvents {

    public static FirefoxDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver",
                "C:\\utils\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile testprofile = profile.getProfile("SeleniumProfile");
        FirefoxOptions opt = new FirefoxOptions();
        opt.setProfile(testprofile);
        driver = new FirefoxDriver(opt);
        driver.get("https://google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("way2automation");

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lJ9FBc']//input[@name='btnK']"))).click();

        driver.findElement(By.xpath("//h3[normalize-space()='Way2Automation']")).click();

        WebElement menu = driver.findElement(By.xpath("//li[@id='menu-item-25091']//span[@class='menu-text'][normalize-space()='Resources']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(menu).perform();

        driver.findElement(By.cssSelector("li[id='menu-item-25092'] span[class='menu-text']")).click();





    }
}
