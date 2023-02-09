package com.cydeo.tests.day_05_testNGIntro_dropdowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class T8_MultipleSelectDropdown {

    WebDriver driver;

    @BeforeClass
    public void setUpMethod() {
        //Open chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //Go to : "https://practice.cydeo.com/dropdown"
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearsDown() {
        driver.quit();
    }


    @Test
    public void printOutTheValues() {
        Select multipleDropdownList = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> getAllOpts = multipleDropdownList.getOptions();

        for (WebElement eachOpts : getAllOpts) {
            eachOpts.click();
            System.out.println("eachOpts = " + eachOpts);
        }

        multipleDropdownList.deselectAll();
    }

}
