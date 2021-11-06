package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleWebTables {

    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://money.rediff.com/index.html");
        driver.findElement(By.xpath("//a[@href='//money.rediff.com/gainers/bse/daily/groupa']")).click();

        String text = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[5]/table[1]/tbody[1]/tr[277]/td[4]")).getText();
       // System.out.println(text);

        List<WebElement> companies = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));

        List<WebElement> prices = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));

        for(int i = 0 ; i < companies.size(); i++){
            if(companies.get(i).getText().equals("Hero MotoCorp"))
            System.out.println("Company : " + companies.get(i).getText() + " Price: " + prices.get(i).getText());
        }
    }
}
