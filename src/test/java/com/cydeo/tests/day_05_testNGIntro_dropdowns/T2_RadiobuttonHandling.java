package com.cydeo.tests.day_05_testNGIntro_dropdowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_RadiobuttonHandling {

    public static void main(String[] args) throws InterruptedException {
        //Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //Go To : "https://practice.cydeo.com/radio_buttons"
        driver.get("https://practice.cydeo.com/radio_buttons");

        //Click to “Hockey” radio button
        WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        Thread.sleep(2000);
        hockeyButton.click();

        //Verify “Hockey” radio button is selected after clicking.
        try {
            System.out.println("hockeyButton.isDisplayed() = " + hockeyButton.isDisplayed());
        }catch (StaleElementReferenceException e){
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
