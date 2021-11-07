package testCases;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutor {
    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");



        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://ksrtc.in");
        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        String scriptFrom = "return document.getElementById(\"fromPlaceName\").value;";
        String text = (String) js1.executeScript(scriptFrom);
        //System.out.println(text);

        int count = 0;

        while(!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")){
            driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
            Thread.sleep(1000);
            text = (String) js1.executeScript(scriptFrom);
            count++;
            //System.out.println(text);
            if(count > 10){
                break;
            }
        }

        if(count > 10){
            System.out.println("Element not found");
        }else{
            driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ENTER);
        }

        //driver.findElement(By.xpath("//input[@id='toPlaceName']")).click();
        driver.findElement(By.xpath("//input[@id='toPlaceName']")).sendKeys("bana");
        driver.findElement(By.xpath("//input[@id='toPlaceName']")).sendKeys(Keys.DOWN);
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@id='toPlaceName']")).sendKeys(Keys.DOWN);

        String scriptTo = "return document.getElementById(\"toPlaceName\").value;";

        JavascriptExecutor js2 = (JavascriptExecutor) driver;

        String textTo = (String) js2.executeScript(scriptTo);

        int countTo = 0;

        while(!textTo.equalsIgnoreCase("BANASHANKARI BMTC TTMC")) {
            driver.findElement(By.xpath("//input[@id='toPlaceName']")).sendKeys(Keys.DOWN);
            //Thread.sleep(1000);
            textTo = (String) js2.executeScript(scriptTo);
            //System.out.println(textTo);
            countTo++;
            if (countTo > 10) {
                break;
            }
        }
        if(countTo > 10){
            System.out.println("Element not found");
        }else{
            driver.findElement(By.xpath("//input[@id='toPlaceName']")).sendKeys(Keys.ENTER);
        }

        //System.out.println(textTo);

    }
}
