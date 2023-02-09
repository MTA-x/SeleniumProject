package com.cydeo.tests.day_05_testNGIntro_dropdowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class T7_Facebook {
    WebDriver driver;
    String expectedTitle = "Facebook";

    @BeforeClass
    public void setUpMethod() {
        //Open chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //Go to : "https://practice.cydeo.com/dropdown"
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void locateAndClick() {
        WebElement nonDropdownList = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        nonDropdownList.click();

        //4. Select Facebook from dropdown
        nonDropdownList = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        nonDropdownList.click();
        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook";

        titleVerification(actualTitle);

    }

    public void titleVerification(String getTitle) {
        Assert.assertEquals(getTitle, expectedTitle);
    }


}
