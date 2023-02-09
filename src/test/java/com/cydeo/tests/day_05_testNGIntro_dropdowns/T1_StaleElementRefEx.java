package com.cydeo.tests.day_05_testNGIntro_dropdowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_StaleElementRefEx {
    public static void main(String[] args) {

        // OPEN CHROME BROWSER
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //GO TO : "https://practice.cydeo.com/add_remove_elements/"
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //CLICK THE "Add Element Button"
        WebElement AddElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        AddElementButton.click();

        //VERIFY THE "Delete" BUTTON DISPLAYED AFTER CLICKING
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());

        //CLICK THE DELETE BUTTON
        deleteButton.click();

        //VERIFY THE "Delete" BUTTON IS NOT DISPLAYED AFTER CLICKING
        try {
            System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("< StaleElementReferenceException is thrown >"
                    +"\n< This means web element is completly deleted from the page >"
            + "\n< deleteButton.isDisplayed() = false");
        }

        driver.quit();
    }
}
