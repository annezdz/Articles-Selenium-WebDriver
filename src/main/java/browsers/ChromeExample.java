package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeExample {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");

    //    WebDriverManager.chromedriver().setup();

        //ChromeDriver driver = new ChromeDriver();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        String title = driver.getTitle();

        System.out.println(title.length());
        System.out.println(title.toUpperCase());
        System.out.println(title);

        driver.close();//current browser window

        driver.quit();//current browser window + all related browser in the same session

    }
}
