package com.cydeo.tests.day_07_webtables_utilities_javafaker;

import com.cydeo.tests.utilities.BrowserUtilities;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearsDown(){
        driver.quit();
    }

    @Test
    public void window_handling_test() {
        // GO TO : "https://www.amazon.com"
        driver.get("https://www.amazon.com");

        // COPY AND PASTE THE LINES FROM BLOW INTO YOUR CLASS
        //HELPS US OPEN NEW BROWSER // CASTING DRIVER TO JS TYPE
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        // CREATE A LOGIC TO SWITCH TO THE TAB WHERE "Etsy.com" is open

        BrowserUtilities.switchWindowAndVerify(driver , "etsy" , "Etsy");

    }


}
