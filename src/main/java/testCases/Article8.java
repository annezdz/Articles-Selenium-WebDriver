package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Article8 {

    public static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
       // driver.get("https://www.facebook.com");
        driver.get("https://www.google.com");
        //driver.findElement(By.cssSelector("input.inputtext")).sendKeys("annezdz@hotmail.com");
        driver.findElement(By.cssSelector("div[class='a4bIc'] input")).sendKeys("home");
    }
}
