package browsers;

import testCases.WebDriver;

public class ChromeDriver implements WebDriver {

    public ChromeDriver(){
        System.out.println("Launching Chrome");
    }

    public void get(String url){
        System.out.println("Navigating to the URL by Chrome");
    }

    public void getTitle(){
        System.out.println("Getting the title from current page in Chrome");
    }

    public void click(){
        System.out.println("Clicking on an element in Chrome");
    }

    public void sendKeys(){
        System.out.println("Typing in an Element in Chrome");
    }
}
