package regression;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {

    @Test
    public void validateTitles(){

        SoftAssert softAssert = new SoftAssert();
        System.out.println("Begining");
        String expected_title = "Yahoo.com"; // excel
        String actual_title = "Gmail.com";   //selenium

//        if (expected_title.equals(actual_title)) {
//
//            System.out.println("Test case passed");
//        }else{
//            System.out.println("Test case fail");
//        }

        // Assert.assertEquals(actual_title,expected_title);
        //isElementPresent ("xpath) - True or False"
        //Assert.assertTrue("Element not found",true);
        System.out.println("validating image");
        softAssert.assertEquals(true,false,"image not present");
        System.out.println("validating text box presenc");
        softAssert.assertEquals(true,false,"text box not present");
        //Assert.fail("Failing the test as the condition is not met");
        System.out.println("ending");

        softAssert.assertAll();
    }
}
