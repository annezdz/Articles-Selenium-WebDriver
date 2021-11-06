package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Assignment2 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.way2automation.com/way2auto_jquery/index.php");
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Anne Zimmermann");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("(47)99106-9919");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("annezdz@hotmail.com");
        WebElement dropDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Brazil");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Blumenau");
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[6]/input[1]")).sendKeys("annezdz");
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[7]/input[1]")).sendKeys("123456");
        driver.findElement(By.xpath
                ("//div[@id='load_box']/form[@id='load_form']/div[@class='bottom row']/div[@class='span_1_of_4']/input[@class='button']")).click();
    }
}
