package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class HardWait {

    public static FirefoxDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.gecko.driver",
                "C:\\utils\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile testprofile = profile.getProfile("SeleniumProfile");
        FirefoxOptions opt = new FirefoxOptions();
        opt.setProfile(testprofile);
        driver = new FirefoxDriver(opt);
        driver.get("https://alaskatrips.poweredbygps.com/");
        driver.findElement(By.xpath("//input[@id='package-origin-hp-package']")).sendKeys("nyc");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='package-origin-hp-package']")).sendKeys(Keys.ARROW_DOWN);
//        driver.findElement(By.xpath("//input[@id='package-origin-hp-package']")).sendKeys(Keys.ENTER);

//        System.out.println(driver.findElement(By.xpath("//div[@class='multiLineDisplay details']/strong"))
//                .getText());

        while (!driver.findElement(By.xpath("//div[@class='multiLineDisplay details']/strong"))
                .getText().equals("New York (JFK - John F. Kennedy Intl.)")) {
            driver.findElement(By.xpath("//input[@id='package-origin-hp-package']")).sendKeys(Keys.DOWN);
            Thread.sleep(2000);

        }


    }
}


