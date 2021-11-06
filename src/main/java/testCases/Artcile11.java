package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class Artcile11 {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.get("https://echoecho.com/htmlforms10.htm");
//
//        int count = driver.findElements(By.xpath("//input[@type='radio'and @name='group1']")).size();

//        for(int i = 0; i < count; i++ ){
//
//            driver.findElements(By.xpath("//input[@type='radio'and @name='group1']")).get(i).click();
//        }

//        for(int i = 0; i < count; i++ ){
//            String text = driver.findElements(By.xpath("//input[@type='radio'and @name='group1']")).get(i).getAttribute("value");
//
//            if(text.equals("Butter")){
//                driver.findElements(By.xpath("//input[@type='radio'and @name='group1']")).get(i).click();
//            }

        driver.get("https://www.hollisterco.com/shop/wd");

        int totalLinks = driver.findElements(By.tagName("a")).size();
        System.out.println("Total link is : " + totalLinks);

        int totalLinksFooter = driver.findElements(By.xpath("//div[@class='footer__info-links grid-col grid-col-2']/div/ul/li/a")).size();
        System.out.println("Total links footer :" + totalLinksFooter);

        WebElement footDriver = driver.findElement(By.xpath("//div[@class='footer__info-links grid-col grid-col-2']"));

        System.out.println("Outra forma de achar com variavel e tagName : " + footDriver.findElements(By.tagName("a")).size());

        int anotherLinks = driver.findElements(By.xpath("//div[@class='footer__brand-links grid-col grid-col-1']/div[2]/ul/li")).size();
        //System.out.println("Anoter = " + anotherLinks);

        WebElement links = driver.findElement(By.xpath("//div[@class='footer__brand-links grid-col grid-col-1']/div[2]/ul"));

        for(int i = 0; i < links.findElements(By.tagName("li")).size(); i++){

            String clickLinksOnNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            links.findElements(By.tagName("a")).get(i).sendKeys(clickLinksOnNewTab);
            Thread.sleep(1000);

        }

        Iterator<String> iterator = driver.getWindowHandles().iterator();

        while(iterator.hasNext()){
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }


//        int linksIcons = driver.findElements(By.xpath("//ul[@class='icon-link-group-horizontal']/li/a")).size();
//        System.out.println("links Icons = " + linksIcons);
    }

    }

