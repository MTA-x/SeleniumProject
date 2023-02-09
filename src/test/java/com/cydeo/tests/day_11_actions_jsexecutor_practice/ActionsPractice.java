package com.cydeo.tests.day_11_actions_jsexecutor_practice;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@SuppressWarnings("ALL")
public class ActionsPractice {

    @Test
    public void task_04_abd_05_test() {

        //Go to : "https://practice.cydeo.com/"
        Driver.getDriver().get("https://practice.cydeo.com/");

        //Scroll down to "Powered By CYDEO"
        Actions actions = new Actions(Driver.getDriver());

        //Scroll using Actions class "moveTo(element)" method
        WebElement poweredByCydeoText = Driver.getDriver().findElement(By.linkText("CYDEO"));
        actions.moveToElement(poweredByCydeoText).perform();

        //Scroll back to "Home" link using PageUP button
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
    }


    @AfterClass
    public void tearsDown(){
        Driver.closeDriver();
    }
}
