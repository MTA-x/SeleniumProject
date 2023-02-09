package com.cydeo.tests.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtilities {

    //THIS METHOD WILL ACCEPT INT AND EXECUTE Thread.sleep(second)
    //for given duration
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedURL , String expectedTInitle) {
        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String allWindowsHandle : allWindowsHandles) {
            driver.switchTo().window(allWindowsHandle);

            if (driver.getCurrentUrl().equals(expectedURL)) {break;
            }
        }

        //ASSERT TO TITLE CONTAINS : "expectedInTitle"
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTInitle) , "TITLE VERIFICATION FAILED");

    }

    public static void verifyTitle(WebDriver driver , String expectedTitle){
        Assert.assertEquals(driver.getTitle() , expectedTitle);
    }

}
