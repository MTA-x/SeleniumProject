package com.cydeo.tests.day_06_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class T5_Window_Handle_practice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethods() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // GO TO : "https://practice.cydeo.com/windows"
        driver.get("https://practice.cydeo.com/windows");
    }

    @AfterMethod
    public void tearsDown() {
        driver.quit();
    }

    @Test
    public void multiple_window_test() {

        //STORING OF THE MAIN PAGES WINDOWS HANDLE AS A STRING
        String mainHandle = driver.getWindowHandle();

        //Assert : Title is "Windows"
        String expectedTitle = "Windows", actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click to : "Click here" link
        WebElement clickToLink = driver.findElement(By.linkText("Click Here"));
        clickToLink.click();

        //Switch to new window
        Set<String> allWindows = driver.getWindowHandles();

        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
        }

        //Assert : Title is "New Window"
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


    }
}
