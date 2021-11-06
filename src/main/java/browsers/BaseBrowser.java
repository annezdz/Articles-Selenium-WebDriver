package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseBrowser {

    public static String browser = "opera";
    public static WebDriver driver;

    public static void main(String[] args) {

        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equals("ie")){
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);

            System.setProperty("webdriver.ie.driver",
                    "C:\\utils\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe");

            InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);
        }else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if (browser.equals("opera")){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }

        driver.get("https://www.udemy.com/");
    }
}
