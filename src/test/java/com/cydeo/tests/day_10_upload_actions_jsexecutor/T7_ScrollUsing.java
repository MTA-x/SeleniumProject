package com.cydeo.tests.day_10_upload_actions_jsexecutor;

import com.cydeo.tests.utilities.BrowserUtilities;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class T7_ScrollUsing {

    @Test
    public void scroll_using_test(){
        //1- Go to: "https://practice.cydeo.com/large"
        Driver.getDriver().get("https://practice.cydeo.com/large");

        //Create an JavascriptExecutor Object
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)Driver.getDriver();

        //3- Scroll down to “Cydeo” link
        WebElement cydeoTextLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", cydeoTextLink);


        //Wait 3 Sec
        BrowserUtilities.sleep(3);

        //4- Scroll up to “Home” link
        WebElement homeTextLink = Driver.getDriver().findElement(By.linkText("Home"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", homeTextLink);

    }

    @AfterClass
    public void tearDown(){
        Driver.getDriver().quit();
    }
}
