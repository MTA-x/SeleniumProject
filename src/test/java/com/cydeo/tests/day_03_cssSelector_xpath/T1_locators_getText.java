package com.cydeo.tests.day_03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {
    public static void main(String[] args) {
        //OPEN CHROME BROWSER
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //MAXIMIZE THE SCREEN
        driver.manage().window().maximize();

        //GO TO : "https:login1.nextbasecrm.com/"
        driver.get("https:login1.nextbasecrm.com/");

        //ENTER INCORRECT USERNAME : "username"
        WebElement inputUsername = driver.findElement(By.className("login-inp")); //FILL THE AREA ACCORDING TO CLASS NAME
        inputUsername.sendKeys("username");

        //ENTER INCORRECT PASSWORD : "password"
        WebElement inputPassword = driver.findElement(By.className("USER_PASSWORD")); //FILL THE AREA ACCORDING TO CLASS NAME
        inputUsername.sendKeys("password");

        //CLICK THE LOGIN BUTTON
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        //VERIFY ERROR MESSAGE "Incorrect login or password"
        WebElement errorMessage = driver.findElement(By.className("errortext"));
        String expectedErrorMessage = "Incorrect login or password"
                , actualErrorMessage = errorMessage.getText()
                , result = "VERIFICATION OF ERROR MESSAGE";

        if (errorMessage.equals(actualErrorMessage)){result += " PASSED";}
        else result += " FAILED";



    }
}
