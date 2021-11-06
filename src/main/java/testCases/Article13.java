package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;

public class Article13 {

    public static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.hdfc.com/");

        driver.findElement(By.xpath("//li[@class='sitemap-blogs']/a[@title='Blogs']")).click();

        Iterator<String> iterator = driver.getWindowHandles().iterator();

        String parentId = iterator.next();
        String childId = iterator.next();

        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());

        driver.switchTo().window(parentId);
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//div[@id='hdfc-language-change']//button[@type='button'][normalize-space()='×']")).click();

        driver.findElement(By.xpath("//li[@class='sitemap-careers']/a[@title='Careers']")).click();

        String child2Id = iterator.next();

        driver.switchTo().window(child2Id);
        System.out.println(driver.getTitle());

        driver.switchTo().window(parentId);

    }
}
