package com.cydeo.tests.day_04_findElements_checkbox_radioButton;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class T3_xpathLocatorExercise {

    static String result = "";

    public static void main(String[] args) {
        //OPEN CHROME BROWSER
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //GO TO : "http://practice.cydeo.com/multiple_buttons"
        driver.get("http://practice.cydeo.com/multiple_buttons");

        //CLICK ON BUTTON#1
        WebElement clickOnButton1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        clickOnButton1.click();

        // VERIFY TEXT DISPLAYED IS AS EXPECTED : "Clicked on button one!"
        WebElement verificationOfText = driver.findElement(By.xpath("//p[text()='Clicked on button one!']"));

        String expectedVerificationText = "Clicked on button one!"
                , actualVerificationText = verificationOfText.getText();

        if (expectedVerificationText.equals(actualVerificationText)){
            result = "TEXT VERIFICATION PASSED";
        }else
            result = "TEXT VERIFICATION FAILED";

        System.out.println("result = " + result);

        //QUIT FROM DRIVERS
        driver.quit();

    }
}
