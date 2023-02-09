package com.cydeo.tests.day_05_testNGIntro_dropdowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;


@SuppressWarnings("ALL")
public class T5_SelectState_from_StateDropdown {
    WebDriver driver;
    static String actual;
    static ArrayList<String> eachSelectState = new ArrayList<>();
    static Select simpleDropdown;
    static int sizeOfArrays;

    @BeforeClass
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        sizeOfArrays = eachSelectState.size();

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void loopForStates(ArrayList<String> givenList, String givenXpath, String givenExpected) throws InterruptedException {
        simpleDropdown = new Select(driver.findElement(By.xpath(givenXpath)));

        int i = 0;
        for (String each : givenList) {
            simpleDropdown.selectByVisibleText(givenList.get(i++));
            WebElement currentlySelected = simpleDropdown.getFirstSelectedOption();
            Thread.sleep(1500);

            actual = currentlySelected.getText().trim();
        }
        verification(givenExpected, actual);

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void loopForValues(ArrayList<String> givenList, String givenXpath, String givenExpected) throws InterruptedException {
        simpleDropdown = new Select(driver.findElement(By.xpath(givenXpath)));

        int i = 0;
        for (WebElement each : simpleDropdown.getOptions()) {
            simpleDropdown.selectByValue(givenList.get(i++));
            WebElement currentlySelected = simpleDropdown.getFirstSelectedOption();
            Thread.sleep(1500);
            actual = currentlySelected.getText().trim();
        }

        verification(givenExpected, actual);
    }
    ////////////////////////////////////////// < VERIFICATION > //////////////////////////////////////////
    public void verification(String givenActual, String givenExpected) {
        Assert.assertEquals(givenExpected
                , givenActual
                , "FAILED");
    }
    ////////////////////////////////////////// < TEST CASES > //////////////////////////////////////////
    @Test(priority = 1)
    public void selectStatesByText() throws InterruptedException {
        eachSelectState.addAll(Arrays.asList("Illinois", "Virginia", "California"));
        loopForStates(eachSelectState, "//select[@id='state']", "California");
    }
    ////// < -------- > //////
    @Test(priority = 2)
    public void selectStatesByValue() throws InterruptedException {
        eachSelectState.addAll(Arrays.asList("IL", "VA", "CA"));
        loopForValues(eachSelectState, "//select[@id='state']/option", "CA");
    }
    ////////////////////////////////////////// < AFTER EACH CLASS > //////////////////////////////////////////
    @AfterClass
    public void tearsDown() {
        driver.quit();
    }
}