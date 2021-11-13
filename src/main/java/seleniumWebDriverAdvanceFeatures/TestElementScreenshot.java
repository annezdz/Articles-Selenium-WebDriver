package seleniumWebDriverAdvanceFeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestElementScreenshot {

    public static WebDriver driver;

    public static void captureScreenshot() throws IOException {

        Date d = new Date();
        String fileName = d.toString()
                .replace(":", "_")
                .replace(" ", "_") + ".jpg";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(".//screenshot//" + fileName));

    }

    public static void captureAnElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("myFunction()");

        js.executeScript("arguments[0].style.border='2px solid red'", element);

    }

    public static void captureEleScreenshot(WebElement ele) throws IOException {

        Date d = new Date();
        String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";


        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        BufferedImage fullImg = ImageIO.read(screenshot);

        Point point = ele.getLocation();

        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();

        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "jpg", screenshot);

        File screenshotLocation = new File("src/main/resources/screenshoots"+ fileName);
        FileUtils.copyFile(screenshot, screenshotLocation);

    }

    public static void main(String[] args) throws IOException {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/search?q=images&sxsrf=AOaemvIt6D9nKyQtDSQiqVhMop9ee4AtlQ:1636760728860&source=lnms&tbm=isch&sa=X&ved=2ahUKEwi5iM3ugJT0AhXGrpUCHeDuBEoQ_AUoAXoECAEQAw&biw=1264&bih=296&dpr=1.5");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement ele = driver.findElement(By.xpath("//img[@alt='100+ Focus Pictures | Download Free Images on Unsplash']"));


        captureScreenshot();
        captureEleScreenshot(ele);
        captureAnElement(ele);
    }

}
