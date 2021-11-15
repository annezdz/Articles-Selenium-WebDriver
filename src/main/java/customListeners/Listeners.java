package customListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {

    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onTestSuccess(ITestResult result) {

        System.out.println("Passed Test - " + result.getName());

    }

    public void onTestFailure(ITestResult result) {

        System.setProperty("org.uncommons.reportng.escape-output","false");
        Reporter.log("<a href=\"https://static-cse.canva.com/blob/183497/Canva-Photographer-Works-with-His-DSLR-Camera.004c8572.jpg\" target=\"_blank\">Screenshot link</a>");
        Reporter.log("<br>");
        Reporter.log("<a href=\"https://static-cse.canva.com/blob/183497/Canva-Photographer-Works-with-His-DSLR-Camera.004c8572.jpg\"><img height=200 width=200 src=\"Área de Trabalho\\error.jpg\"></a>");


        System.out.println("Capturing screenshot for the failed test --> " + result.getName());

    }

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }

}
