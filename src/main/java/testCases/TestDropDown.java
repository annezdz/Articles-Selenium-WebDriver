package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestDropDown {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.findElement(By.xpath("//select[@id='searchLanguage']")).sendKeys("Polski"); Isso não funciona com
        // Select

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchLanguage']"));

        Select select = new Select(dropDown);

        //select.selectByVisibleText("Eesti");
        //select.selectByValue("ar");

        List<WebElement> values = driver.findElements(By.tagName("option"));
        System.out.println("Total values are : " + values.size());
//        for (WebElement value: values){
//            System.out.println(value.getText());
//        }
        //System.out.println(values.get(5).getText());

//        for (int i = 0; i < values.size(); i++){
//            System.out.println(values.get(i).getAttribute("lang"));
//        }

        List<WebElement> manyLinks = driver.findElements(By.className("other-project"));

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for(WebElement link : links){
            System.out.println(link.getText() + " --- URL --- " + link.getAttribute("href"));
        }


        System.out.println("Total links in this page:" + manyLinks.size());
        System.out.println("Total links a :  " + links.size());

        for(WebElement oneLink : manyLinks){
            System.out.println(oneLink.getText());
        }


    }
}
