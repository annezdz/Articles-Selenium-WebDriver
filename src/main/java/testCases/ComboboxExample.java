package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ComboboxExample {

    public static WebDriver driver;

    public static void main(String[] args) {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.jobserve.com/in/en/Job-Search/");

        driver.findElement(By.xpath("//span[@class='ui-dropdownchecklist-text']")).click();
        driver.findElement(By.xpath("//div[@class = 'ddcl-selInd-i0-fake fakeInput active']")).click();

        String industry = "Education";
        List<String> industries = List.of("Engineering","Education","Manufacturing");


        List<WebElement> allIndustries = driver.findElements(By.xpath("//div[@id='industryDisplay']/div/div/div/label"));

        for(int i = 0; i < allIndustries.size(); i++){
            for(int j = 0; j < industries.size(); j++){
                if(allIndustries.get(i).getText().equalsIgnoreCase(industries.get(j))){
                    allIndustries.get(i).click();
                }
            }
        }

    }
}
