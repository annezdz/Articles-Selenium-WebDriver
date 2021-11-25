package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver = null;

    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebDriver getDriver(String browser){

        switch (browser)
        {
            case "chrome":
            {
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--disable-notifications");

                System.setProperty("webdriver.chrome.driver",
                        "C:\\utils\\chrome\\chromedriver.exe");
                driver = new ChromeDriver(ops);
                break;
            }
            case "firefox":
            {
                System.setProperty("webdriver.gecko.driver",
                        "C:\\utils\\geckodriver-v0.30.0-win64\\geckodriver.exe");
                ProfilesIni profile = new ProfilesIni();
                FirefoxProfile testprofile = profile.getProfile("SeleniumProfile");
                FirefoxOptions opt = new FirefoxOptions();
                opt.setProfile(testprofile);
                driver = new FirefoxDriver(opt);
                break;
            }
            case "opera":
            {
                System.setProperty("webdriver.opera.driver",
                        "C:\\utils\\operadriver_win64\\operadriver_win64\\operadriver.exe");

                DesiredCapabilities capabilities = new DesiredCapabilities();
                OperaOptions options = new OperaOptions();
                options.setBinary("C:\\Users\\anicolle\\AppData\\Local\\Programs\\Opera\\opera.exe");
                capabilities.setCapability(OperaOptions.CAPABILITY, options);

                driver = new org.openqa.selenium.opera.OperaDriver();
                break;
            }
            case "edge":
            {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }
            case "ie":
            {
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);

                System.setProperty("webdriver.ie.driver",
                        "C:\\utils\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe");

                driver = new InternetExplorerDriver(capabilities);
            }
            default: {
                System.out.println("Webdriver não informado. Escolha entre: chrome, firefox, ie, edge ou opera.");
            }
        }
        return driver;
    }

}
