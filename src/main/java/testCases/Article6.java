package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Article6 {

    public static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        //driver.findElement(By.id("email")).sendKeys("annezdz@hotmail.com");
//        driver.findElement(By.cssSelector("#email")).sendKeys("annezdz@hotmail.com");
//        driver.findElement(By.name("pass")).sendKeys("anne280785");
//        driver.findElement(By.xpath("//input[contains(@id,'u_0_')]")).click();
        //driver.findElement(By.linkText("Esqueceu a senha?")).click();

        //driver.findElement(By.xpath("//*[@name = 'login']")).click();

        //driver.findElement(By.cssSelector("*[name = 'login']")).click();
//        driver.findElement(By.cssSelector("#u_0_d_mY")).click();
        driver.findElement(By.xpath("//*[@a = 'Sobre'")).click();
        //driver.findElement(By.cssSelector("input[data-ved*='9UDCA']")).sendKeys("SELENIUM");

    }
}
