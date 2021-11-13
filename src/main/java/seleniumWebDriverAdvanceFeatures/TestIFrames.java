package seleniumWebDriverAdvanceFeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestIFrames {

    public static WebDriver driver;

    public static void captureScreenshot() throws IOException {

        Date d = new Date();
        String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src//main//resources//screenshoots"+fileName));

    }

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*Set<String> winids = driver.getWindowHandles();
		Iterator<String> iterate = winids.iterator();

		String first_window = iterate.next();
		*/

        driver.switchTo().frame("iframeResult");
        //driver.findElement(By.xpath("/html/body/button")).click();


        //((JavascriptExecutor) driver).executeScript("myFunction()");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("myFunction()");

        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.id("mySubmit")));


        //driver.switchTo().window(first_window);
        driver.switchTo().defaultContent();

        List<WebElement> frames = driver.findElements(By.tagName("iframe"));

        System.out.println(frames.size());

        for (WebElement frame : frames) {

            System.out.println(frame.getAttribute("id"));
        }


        captureScreenshot();


    }

}
