package com.cydeo.tests.day_10_upload_actions_jsexecutor;

import com.cydeo.tests.utilities.BrowserUtilities;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Actions_Hover {

    @Test
    public void hovering_test() {
        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        //Locate all images
        WebElement img_01 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img_02 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img_03 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        //Locate all the user text
        WebElement userText_01 = Driver.getDriver().findElement(By.xpath("h5[.='name: user1']"));
        WebElement userText_02 = Driver.getDriver().findElement(By.xpath("h5[.='name: user2']"));
        WebElement userText_03 = Driver.getDriver().findElement(By.xpath("h5[.='name: user3']"));

        //Creat an action class
        Actions actions = new Actions(Driver.getDriver());

        //2. Hover over to first image
                //Assert : name -> "user1" isDisplayed
                //“view profile” is displayed
        BrowserUtilities.sleep(2);
        actions.moveToElement(img_01).perform();
        Assert.assertTrue(userText_01.isDisplayed());

        //2. Hover over to first image
                //Assert : name -> "user2" isDisplayed
                //“view profile” is displayed

        BrowserUtilities.sleep(2);
        actions.moveToElement(img_02).perform();
        Assert.assertTrue(userText_02.isDisplayed());

        //2. Hover over to first image
                //Assert : name -> "user3" isDisplayed
                //“view profile” is displayed

        BrowserUtilities.sleep(2);
        actions.moveToElement(img_03).perform();
        Assert.assertTrue(userText_03.isDisplayed());


    }
}
