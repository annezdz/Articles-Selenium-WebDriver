package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assignment1 {

    public static WebDriver driver;

    public static boolean isElementPresent(By by){

        int size = driver.findElements(by).size();
        if(size != 0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.way2automation.com/");

        List<WebElement> listLinks = driver.findElements(By.className("elementor-icon-list-text"));

        System.out.println("Numbers links are: " + listLinks.size());

        for(WebElement link : listLinks){
            System.out.println(link.getText());
        }
    }
}
