package browsers;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEExample {

    public static void main(String[] args) {

        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);

        System.setProperty("webdriver.ie.driver",
                "C:\\utils\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe");

        InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);
        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-ie-driver/3.141.59");
    }
}
