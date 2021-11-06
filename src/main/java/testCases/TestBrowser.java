package testCases;

import browsers.ChromeDriver;
import browsers.IEDriver;
import browsers.OperaDriver;

public class TestBrowser {

    public static String browser = "ie";
    public static WebDriver driver;

    public static void main(String[] args) {

        if(browser.equals("chrome")){
             driver = new ChromeDriver();
        }
        else if(browser.equals("ie")){
             driver = new IEDriver();
        }else if(browser.equals("opera")){
             driver = new OperaDriver();
        }

        driver.get("http://www.google.com");
        driver.getTitle();
        driver.click();
        driver.sendKeys();
    }
}
