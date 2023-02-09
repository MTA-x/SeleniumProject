package com.cydeo.tests.day_06_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T1_Alert_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethods() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearsDown(){
        driver.quit();
    }

    @Test
    public void alert_test1() throws InterruptedException {
        //Click to “Click for JS Alert” button -> "//button[text()='Click for JS Alert']" <-
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        Thread.sleep(2500);
        jsAlertButton.click();

        //TO ABLE TO CLICK TO ALERT OK BUTTON WE NEED TO SWITCH DRIVERS FOCUS TO ALERT ITSELF
        Alert alert = driver.switchTo().alert();

        //Click to OK button from the alert
        alert.accept(); // WE CANNOT LOCATE THE ALERT BUTTON BCS THIS IS NOT PART OF THE HTML CODE

        //Verify “You successfully clicked an alert” text is displayed.
        WebElement resultOfAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = resultOfAlert.getText()
                , expectedResult = "You successfully clicked an alert";

        Assert.assertEquals(actualResult , expectedResult , "VERIFYING RESULT TEXT IS FAILED");
    }

    @Test
    public void alert_test2() throws InterruptedException {
        // Click to “Click for JS Confirm” button
        WebElement jsConfirmButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        jsConfirmButton.click();

        Thread.sleep(2500);
        // Click to OK button from the alert
        driver.switchTo().alert().accept();

        // Verify “You clicked: Ok” text is displayed.
        WebElement resultOfAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = resultOfAlert.getText()
                , expectedResult = "You clicked: Ok";

        Assert.assertEquals(actualResult , expectedResult , "VERIFYING RESULT TEXT IS FAILED");
    }

    @Test
    public void alert_test3() {
        // Click to “Click for JS Prompt” button
        WebElement jsPromptButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        jsPromptButton.click();

        // Send “hello” text to alert
        driver.switchTo().alert().sendKeys("hello");

        // Click to OK button from the alert
        driver.switchTo().alert().accept();

        // Verify “You entered: hello” text is displayed.
        WebElement resultOfAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = resultOfAlert.getText()
                , expectedResult = "You entered: hello";

        Assert.assertEquals(actualResult , expectedResult , "VERIFYING RESULT TEXT IS FAILED");
    }
}
