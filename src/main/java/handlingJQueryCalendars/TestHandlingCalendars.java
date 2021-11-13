package handlingJQueryCalendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TestHandlingCalendars {

    static int targetDay = 0,
            targetMonth = 0,
            targetYear = 0;

    static int currentDay = 0,
            currentMonth = 0,
            currentYear = 0;

    static int jumpMonthsBy = 0;
    static int jumpYearsBy = 0;

    static boolean incrementMonth = true;
    static boolean incrementYear = true;
    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {

        /*
        * target day, month , year
        * current day, month , year
        * jump to the month
        * increment or decrement
        * */

        String dateToSet = "26/06/2022";

        //get current date
        getCurrentDateMonthYear();

        //get target date

        getTargetDateMontAndYear(dateToSet);
        System.out.println(currentDay + " " + currentMonth + " " + currentYear );
        System.out.println(targetDay+  " " + targetMonth + " " + targetYear );

        //Get Jump month

        calculateHowManyMonthsToJump();
        calculateHowManyYearsToJump();
//        System.out.println(jumpMonthsBy);
//        System.out.println(jumpYearsBy);
//        System.out.println(incrementMonth);
//        System.out.println(incrementYear);


        System.setProperty("webdriver.gecko.driver",
                "C:\\utils\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile testprofile = profile.getProfile("SeleniumProfile");
        FirefoxOptions opt = new FirefoxOptions();
        opt.setProfile(testprofile);
        driver = new FirefoxDriver(opt);
        driver.get("https://jqueryui.com/datepicker/#other-months");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.switchTo().frame(0);


        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        for(int i = 0; i < jumpMonthsBy; i++){
            if(incrementMonth){
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            }else{
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.linkText(Integer.toString(targetDay))).click();


    }

    public static void calculateHowManyYearsToJump(){
        if((targetYear - currentYear) > 0){
            jumpYearsBy = (targetYear - currentYear);
        }else{
            jumpYearsBy = (currentYear - targetYear);
            incrementYear = false;
        }
    }

    public static void calculateHowManyMonthsToJump() {
        if(!incrementYear){
            if ((targetMonth - currentMonth) > 0) {
                jumpMonthsBy = (targetMonth - currentMonth);
            } else {
                jumpMonthsBy = (currentMonth - targetMonth);
                incrementMonth = false;
            }
        }else{
            jumpMonthsBy = (12 - currentMonth) + (targetMonth);
        }

    }


    public static void getCurrentDateMonthYear(){
        Calendar calendar = Calendar.getInstance();
        currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        currentMonth = calendar.get(Calendar.MONTH)+1;
        currentYear = calendar.get(Calendar.YEAR);
    }

    public static void getTargetDateMontAndYear(String dateString){

        int firstIndex = dateString.indexOf("/");
        int lastIndex = dateString.lastIndexOf("/");

        String day = dateString.substring(0,firstIndex);
        targetDay = Integer.parseInt(day);

        String month = dateString.substring(firstIndex + 1, lastIndex);
        targetMonth = Integer.parseInt(month);

        String year = dateString.substring(lastIndex + 1, dateString.length());
        targetYear = Integer.parseInt(year);
    }

}
