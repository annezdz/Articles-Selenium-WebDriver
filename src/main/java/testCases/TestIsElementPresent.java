package testCases;

import org.openqa.selenium.By;

public class TestIsElementPresent extends BaseClas{


    public static boolean isElementPresent(By by){

        driver().get("\"https://www.wikipedia.org/\"");
//        try{
//            inicialize().findElement(By.xpath(locator));
//            return true;
//        }catch (Throwable t){
//            return false;
//        }
        int size = driver().findElements(by).size();
        if(size != 0){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {

//        System.out.println(inicialize()
//                .findElement(By.xpath("//strong[normalize-space()='English']"))
//                .isDisplayed());

        System.out.println(isElementPresent(By.xpath("//select[@id='searchLanguage']")));








    }
}
