package com.cydeo.tests.day_05_testNGIntro_dropdowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class T4_Simple_Dropdowns {

    WebDriver driver;
    @BeforeClass
    public void setUpMethod(){
        //Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //Go to : "https://practice.cydeo.com/dropdown"
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test (priority = 1)
    public void dropDownTitle(){
        //Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”

        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();

        String expectedDropDownTitle = "Please select an option"
                , actualDropdownTile = currentlySelectedOption.getText();

        Assert.assertEquals(expectedDropDownTitle
                , actualDropdownTile
                , "DROPDOWN TITLE VERIFICATION FAILED");
    }

    @Test (priority = 2)
    public void stateSelection(){
        //Verify “State selection” default selected value is correct
        //Expected: “Select a State”
        Select stateSelectionDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        WebElement currentlySelectedOption = stateSelectionDropdown.getFirstSelectedOption();

        String expectedStateSelectionTitle = "Select a State"
                ,actualStateSelectionTitle = currentlySelectedOption.getText();

        Assert.assertEquals(expectedStateSelectionTitle
                , actualStateSelectionTitle
                , "STATE SELECTION TITLE VERIFICATION FAILED");
    }

    @AfterClass
    public void tearsDown(){
        driver.quit();
    }
}
