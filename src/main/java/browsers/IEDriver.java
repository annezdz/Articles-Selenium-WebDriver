package browsers;

import testCases.WebDriver;

public class IEDriver implements WebDriver {

    public IEDriver(){
        System.out.println("Launching IE");
    }

    public void get(String url){
        System.out.println("Navigating to the URL by IE");
    }

    public void getTitle(){
        System.out.println("Getting the title from current page in IE");
    }

    public void click(){
        System.out.println("Clicking on an element in IE");
    }

    public void sendKeys(){
        System.out.println("Typing in an Element in IE");
    }
}
