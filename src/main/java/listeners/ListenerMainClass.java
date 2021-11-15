package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ListenerMainClass {

    public static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver",
                "C:\\utils\\geckodriver-v0.30.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
        EvenCapture eCapture = new EvenCapture();
        //Registering with EventFiringWebDriver
        //Register method allows to register our implementation of WebDriverEventListner to listen to the WebDriver events
        eventHandler.register(eCapture);
        //navigating to the webpage "www.softwaretestingmaterial.com"
        eventHandler.navigate().to("https://www.softwaretestingmaterial.com/");
        eventHandler.findElement(By.xpath("//input[@placeholder='Your Email']")).sendKeys("asdsadsa");
        //navigating to the webpage "www.softwaretestingmaterial.com/category/selenium/"
        eventHandler.navigate().to("https://www.softwaretestingmaterial.com/");
        //navigating back to the first page
        eventHandler.navigate().back();
        eventHandler.quit();
        //Unregister allows to detach
        eventHandler.unregister(eCapture);
        System.out.println("End of Listners Class");
    }
}
