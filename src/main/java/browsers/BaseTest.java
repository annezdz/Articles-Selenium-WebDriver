package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    public static String mailscreenshotpath;

    @BeforeSuite
    public void setUp(){
            getDriver("firefox");
//            driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1637844700&rver=7.0.6737.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26RpsCsrfState%3d1bcae29f-cf57-5bf9-5da3-64f25ae13c8c&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=90015");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
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

    public static void captureScreenshot(){

        Calendar calendar = new GregorianCalendar();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int sec = calendar.get(Calendar.SECOND);
        int min = calendar.get(Calendar.MINUTE);
        int date = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            mailscreenshotpath = String.valueOf(new File("src\\main\\resources" + year + "_" + date + "_"
                    + (month + 1) +
                    "_" + hour + "_" + min + "_" + sec + ".png"));
            FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //  @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}
