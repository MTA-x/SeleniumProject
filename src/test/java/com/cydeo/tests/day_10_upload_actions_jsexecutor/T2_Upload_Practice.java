package com.cydeo.tests.day_10_upload_actions_jsexecutor;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.BrowserUtilities;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void upload_test() {
        //1. Go to : "https://practice.cydeo.com/upload"
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String pathOfFile = "/Users/x3res/Downloads/Pics/Wallpaper/3865921.jpg";

        //3. Upload the file.
        WebElement chooseFileButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));

        BrowserUtilities.sleep(2);
        chooseFileButton.sendKeys(pathOfFile);

        //Submit File
        WebElement fileSubmitButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        fileSubmitButton.click();


        //4. Assert: File uploaded text is displayed on the page
        WebElement verificationText = Driver.getDriver().findElement(By.tagName("h3"));

        /*String expectedText = "File Uploaded!"
                , actualText = verificationText.getText();

        Assert.assertEquals(expectedText , actualText);*/

        Assert.assertTrue(verificationText.isDisplayed());
    }

    @AfterClass
    public void tearsDown(){
        Driver.getDriver().quit();
    }
}
