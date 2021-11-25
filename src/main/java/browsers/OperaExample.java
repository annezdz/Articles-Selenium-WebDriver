package browsers;

import com.opera.core.systems.OperaDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.opera.core.systems.OperaDriver.*;

public class OperaExample {
    public static void main(String[] args) {

        System.setProperty("webdriver.opera.driver",
                "C:\\utils\\operadriver_win64\\operadriver_win64\\operadriver.exe");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Users\\anicolle\\AppData\\Local\\Programs\\Opera\\opera.exe");
        capabilities.setCapability(OperaOptions.CAPABILITY, options);

        WebDriver driver = new org.openqa.selenium.opera.OperaDriver();
        driver.get("https://relogioonline.com.br");
    }
}
