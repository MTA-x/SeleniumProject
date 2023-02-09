package com.cydeo.tests.day_04_findElements_checkbox_radioButton;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T6_StaleElementReferenceException {
    public static void main(String[] args) {

        //OPEN CHROME BROWSER
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //GO TO : "http://practice.cydeo.com/abtest"
        driver.get("http://practice.cydeo.com/abtest");

        //LOCATE "CYDEO" LINK, VERIFY IT IS DISPLAYED
        WebElement linkOfCYDEO = driver.findElement(By.xpath("//a[text()='CYDEO']"));
        System.out.println("linkOfCYDEO.isDisplayed() = " + linkOfCYDEO.isDisplayed());

        //REFRESH THE PAGE
        driver.navigate().refresh();

        //VERIFY DISPLAYED AGAIN
        linkOfCYDEO = driver.findElement(By.xpath("//a[text()='CYDEO']"));
        System.out.println("linkOfCYDEO.isDisplayed() = " + linkOfCYDEO.isDisplayed());

        //QUIT FROM DRIVER(S)
        driver.quit();
    }
}
