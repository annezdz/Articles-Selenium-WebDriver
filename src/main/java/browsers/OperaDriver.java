package browsers;

import testCases.WebDriver;

public class OperaDriver implements WebDriver {

    public OperaDriver(){
        System.out.println("Launching Opera");
    }

    public void get(String url){
        System.out.println("Navigating to the URL by Opera");
    }

    public void getTitle(){
        System.out.println("Getting the title from current page in Opera");
    }

    public void click(){
        System.out.println("Clicking on an element in Opera");
    }

    public void sendKeys(){
        System.out.println("Typing in an Element in Opera");
    }
}
