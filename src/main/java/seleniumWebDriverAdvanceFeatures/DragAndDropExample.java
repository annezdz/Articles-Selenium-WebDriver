package seleniumWebDriverAdvanceFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDropExample {

    public static WebDriver driver = null;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver",
                "C:\\utils\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile testprofile = profile.getProfile("SeleniumProfile");
        FirefoxOptions opt = new FirefoxOptions();
        opt.setProfile(testprofile);
        driver = new FirefoxDriver(opt);
        driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();

    }
}
