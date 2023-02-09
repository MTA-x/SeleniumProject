package com.cydeo.tests.day_02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttribute {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //GO TO "https://practice.cydeo.com/registration_form"
        driver.get("https://practice.cydeo.com/registration_form");

        //VERIFY THE HEADER TEXT : "Registration form"
        WebElement headerText = driver.findElement(By.tagName("h2"));
        //EXPECTED REGISTRATION FORM
        String expectedHeaderText = "Registration form"
                , actualHeaderText = headerText.getText();

        System.out.println((expectedHeaderText.equals(actualHeaderText)
                ? "HEADER TEXT VERIFICATION PASSED"
                : "HEADER TEXT VERIFICATION FAILED"));

        //LOCATE “First name” INPUT BOX
        WebElement firstNameInput = driver.findElement(By.name("firstname"));

        //EXPECTED :  first name
        String expectedPlaceHolder = "first name"
                , actualPlaceHolder = firstNameInput.getAttribute("placeholder");

        System.out.println( (expectedPlaceHolder.equals(actualPlaceHolder)
                ? "PLACE HOLDER VERIFICATION PASSED"
                : "PLACE HOLDER VERIFICATION FAILED"));

        //CLOSE THE DRIVER
        driver.quit();


    }
}
