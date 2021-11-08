package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.util.concurrent.TimeUnit;

public class ImplicitWair {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver",
                "C:\\utils\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile testprofile = profile.getProfile("SeleniumProfile");
        FirefoxOptions opt = new FirefoxOptions();
        opt.setProfile(testprofile);
        driver = new FirefoxDriver(opt);
        driver.manage().window().maximize();

        driver.get("https://www.expedia.co.in/");
        driver.findElement(By.xpath("//span[@class='uitk-tab-text'][contains(text(),'Flights')]")).click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@aria-label='Leaving from']")).click();

        //driver.findElement(By.xpath("//button[@aria-label='Leaving from']")).click();

        driver.findElement(By.xpath("//input[@id='location-field-leg1-origin']")).sendKeys("ca");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//ul[@class='uitk-typeahead-results no-bullet']/li[1]")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//ul[@class='uitk-typeahead-results no-bullet']/li[1]")).sendKeys(Keys.ENTER);
    }
}
