package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class TestCheckBoxes {

    public static WebDriver driver;


    public static boolean isElementPresent(By by){

//        try{
//            inicialize().findElement(By.xpath(locator));
//            return true;
//        }catch (Throwable t){
//            return false;
//        }
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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
//        driver.findElement(By.xpath("//div[4]//input[1]")).click();
//        driver.findElement(By.xpath("//div[4]//input[2]")).click();
//        driver.findElement(By.xpath("//div[4]//input[3]")).click();
//        driver.findElement(By.xpath("//div[4]//input[4]")).click();


//
//        for(int i = 1; i <= 4; i++){
//            driver.findElement(By.xpath("//div[4]//input["+i+"]")).click();
//        }

        int i = 1;
        int count = 0;

        while(isElementPresent(By.xpath("//div[4]//input["+i+"]"))){
            driver.findElement(By.xpath("//div[4]//input["+i+"]")).click();
            i++;
            count++;
        }
        System.out.println("Total checkboxes are: " + count);

//        Dimension countCheckbox = driver.findElement(By.xpath("//input[@type='checkbox']")).getSize();
//        System.out.println(countCheckbox);

        WebElement block = driver.findElement(By.xpath("//td[@class='mainIn']"));

        List<WebElement> countCheckboxes = block.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(countCheckboxes.size());

        for(WebElement checkbox : countCheckboxes){
            checkbox.click();
        }

    }
}
