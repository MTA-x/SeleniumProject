package com.cydeo.tests.day_04_findElements_checkbox_radioButton;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_chechkboxes {
    public static void main(String[] args) throws InterruptedException {
        //OPEN CHROME BROWSER
        WebDriver driver = WebDriverFactory.getDriver("CHROME");

        //GO TO : "http://practice.cydeo.com/checkboxes"
        driver.get("http://practice.cydeo.com/checkboxes");

        //MAXIMIZE THE SCREEN
        driver.manage().window().maximize();

        //CONFIRM CHECKBOX#1 IS NOT SELECTED BY DEFAULT
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='box1']"));

        //CONFIRM CHECKBOX#2 IS  SELECTED BY DEFAULT
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='box2']"));

        //CLICK CHECKBOX#1 IS SELECTED
        System.out.println("CHECKBOX#1 : " + checkBox1.isSelected());
        checkBox1.click();

        //WAIT 3 SEC
        Thread.sleep(3000);
        //CLICK CHECKBOX#2 DESELECTED
        System.out.println("CHECKBOX#2 : " + checkBox2.isSelected());
        checkBox2.click();

        //CONFIRM CHECKBOX#1 IS SELECTED
        System.out.println("CHECKBOX#1 : " + checkBox1.isSelected());

        //CONFIRM CHECKBOX#2  DESELECTED
        System.out.println("CHECKBOX#2 : " + checkBox2.isSelected());

    }
}
