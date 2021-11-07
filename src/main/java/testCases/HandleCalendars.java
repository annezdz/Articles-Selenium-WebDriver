package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.sound.midi.spi.SoundbankReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HandleCalendars {

    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException, ParseException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.goibibo.com/");

        driver.findElement(By.xpath("//input[@id='departureCalendar']")).click();
        Thread.sleep(3000);

        String date = "26/06/2022";

        String months[] = {"January","February","March","April","May","June"
                ,"July","August","September","October","November","December"};
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date myDate = df.parse(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

//        System.out.println(day);
//        //System.out.println(month);
//        System.out.println(months[month]);
//        System.out.println(year);

        String forwardArrow = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']";
        String travelMonth = months[month] + " " + year;
        //System.out.println(travelMonth);

        String xpathMonthYearSection = "//div[@class='DayPicker-Caption']";

        while(!driver.findElement(By.xpath(xpathMonthYearSection)).getText().equals(travelMonth)){
            driver.findElement(By.xpath(forwardArrow)).click();
        }

        driver.findElement(By.xpath("//div[text()='" + day + "']")).click();
    }
}
