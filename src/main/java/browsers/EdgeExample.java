package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeExample {

    public static void main(String[] args) {

        //System.setProperty("webdriver.edge.driver","C:\\utils\\edgedriver_win64 (4.0.992.50)\\msedgedriver.exe");
        //DISM.exe /Online /Add-Capability /CapabilityName:Microsoft.WebDriver~~~~0.0.1.0
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://relogioonline.com.br/");
    }
}
