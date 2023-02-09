package com.cydeo.tests.day_11_actions_jsexecutor_practice;

import com.cydeo.tests.utilities.BrowserUtilities;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll_JSExecutor {

    @Test
    public void task_07_scroll_test() {
        //Go to : "https://practice.cydeo.com/large"
        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

        //Scroll down to "Cydeo" link
        BrowserUtilities.sleep(2);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);

        //Scroll up to "Home" link
        BrowserUtilities.sleep(2);
        javascriptExecutor.executeScript("arguments[1].scrollIntoView(true)" , cydeoLink , homeLink);


    }
}
