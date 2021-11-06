package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\utils\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://timesofindia.indiatimes.com/poll.cms");

        driver.findElement(By.xpath("//input[@value='2']")).click();

        String math = driver.findElement(By.id("mathq2")).getText();
        int resultado = 0;
        var res = math.split(" ");
        int numberOne = Integer.parseInt(res[0]);
        int numberTwo = Integer.parseInt(res[2]);
        if(res[1].equals("+")){
            resultado = numberOne + numberTwo;
            String resultadoFInal = String.valueOf(resultado);
            driver.findElement(By.xpath("//input[@id='mathuserans2']")).sendKeys(resultadoFInal);
        }
        else{
            resultado = numberOne - numberTwo;
            String resultadoFInal = String.valueOf(resultado);
            driver.findElement(By.xpath("//input[@id='mathuserans2']")).sendKeys(resultadoFInal);
        }

//        Pattern p = Pattern.compile("\\d+");
//        Matcher m = p.matcher(math);
//        while(m.find()) {
//            System.out.println(m.group());
//        }


    }
}
