package com.cydeo.tests.day_02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_LibaryLoginPage {
    public static void main(String[] args) {

        //OPEN CHROME BROWSER
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //GO TO https://library2.cybertekschool.com/login.html
        driver.get("https://library2.cybertekschool.com/login.html");

        //ENTER THE USERNAME : : "incorrect@email.com"
        WebElement inputUserName = driver.findElement(By.className("form-control"));
        inputUserName.sendKeys("incorrect@email.com");

        //ENTER PASSWORD "incorrect password"
        WebElement inputPassword = driver.findElement(By.id("inputPassword"));
        inputPassword.sendKeys("incorrect password");

        //CLICK SIGN-IN BUTTON
        WebElement singInButton = driver.findElement(By.tagName("button"));

    }
}
