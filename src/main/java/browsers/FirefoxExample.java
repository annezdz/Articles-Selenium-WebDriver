package browsers;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxExample {
    public static void main(String[] args) {

//        System.setProperty("webdriver.gecko.driver",
////                "C:\\utils\\geckodriver-v0.30.0-win64\\geckodriver.exe");

        WebDriverManager.firefoxdriver().setup();

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("http://www.google.com");
    }
}
