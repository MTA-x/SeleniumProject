package com.cydeo.tests.day_10_upload_actions_jsexecutor;

import com.cydeo.tests.utilities.BrowserUtilities;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class T6_JavascriptExecutor {

    @Test
    public void javascript_executor_test() {

        //2- Go to: "https://practice.cydeo.com/infinite_scroll"
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //Create an javascriptExecutor object
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

        for (int i = 0; i < 10; i++) {
            javascriptExecutor.executeScript("window.scrollBy(0 , 750)");
        }

        // 3- Use below JavaScript method and scroll

        //a. 750 pixels down 10 times.
        BrowserUtilities.sleep(2);
        javascriptExecutor.executeScript("window.scrollBy(0 ,750)");

        //b. 750 pixels up 10 times
        BrowserUtilities.sleep(2);
        javascriptExecutor.executeScript("window.scrollBy(750 ,0)");

    }
    @AfterClass
    public void tearDown(){
        Driver.getDriver().quit();
    }

}

