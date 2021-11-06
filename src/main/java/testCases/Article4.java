package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Article4 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");

        System.setProperty("webdriver.edge.driver",
                "C:\\utils\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = null;

        driver = new ChromeDriver();
        driver.get("https://www.google.com");

//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getPageSource());

        driver.navigate().to("https://yahoo.com");
        driver.navigate().back();
        driver.close();

//        driver = new EdgeDriver();
//        driver.get("https://www.google.com");

    }
}
