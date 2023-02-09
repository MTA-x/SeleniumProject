package com.cydeo.tests.day_04_findElements_checkbox_radioButton;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("ALL")
public class T1_xpath_cssSelector_practice {

    static ArrayList<WebElement> displayWebElements = new ArrayList<>();

    public static void main(String[] args) {
        //OPEN CHROME BROWSER
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //GO TO : "https://practice.cydeo.com/forgot_password"
        driver.get("https://practice.cydeo.com/forgot_password");

        /////////////////////////////////////// < "Home" LINK (W/ CSS-SELECTOR) > ///////////////////////////////////////

        // - LOCATE HOMEMLINK USING CSS-SELECTOR ACCORDING TO CLASS VALUE
        WebElement homeLink_exp1 = driver.findElement(By.cssSelector("a[class='nav-link']"));

        // - LOCATE HOMEMLINK USING CSS-SELECTOR ACCORDING SYNTAX
        WebElement homeLink_exp2 = driver.findElement(By.cssSelector("a.nav-link")); //

        // - LOCATE USING CSS-SELECTOR ACCORDING TO HREF
        WebElement homeLink_exp3 = driver.findElement(By.cssSelector("a[href='/']"));

        ///////////////////////////////////////  < "Forgot Password" HEADER >  ///////////////////////////////////////

        // - LOCATE HEADER USING CSS-SELECTOR -> LOCATE PARENT ELEMENT AND MOVE DOWN TO H2
        WebElement forgotPasswordHeader_exp1 = driver.findElement(By.cssSelector("div.example > h2"));

        // - LOCATE HEADER USING XPATH AND USING WEB ELEMENTS TEXT -> "Forgot Password"
        WebElement forgotPasswordHeader_exp2 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        WebElement forgotPasswordHeader_exp3 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        /////////////////////////////////////// < "e-mail" TEXT > ///////////////////////////////////////
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));

        /////////////////////////////////////// < "e-mail" INPUT-BOX > ///////////////////////////////////////

        // - USING XPATH CONTAINS METHOD
        WebElement inputBox_ex1 = driver.findElement(By.xpath("//input[@name='email']"));

        // - SELECT PATTERN OF INPUT BOX BY USING XPATH
        WebElement inputBox_ex2 = driver.findElement(By.xpath("//input[contains(@pattern , '[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$' )]"));

        /////////////////////////////////////// < "Retrieve password" BUTTON > ///////////////////////////////////////
        WebElement retrivePasswordButton = driver.findElement(By.xpath("//button[@id='form_submit']"));

        /////////////////////////////////////// <  "Powered by Cydeo" TEXT > ///////////////////////////////////////
        WebElement poweredByCydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        /////////////////////////////////////// < VERIFY ALL THE ELEMENTS ARE DISPLAYED > ///////////////////////////////////////

        displayWebElements.addAll(Arrays.asList(homeLink_exp1
                , forgotPasswordHeader_exp1
                , emailLabel
                , inputBox_ex1
                , retrivePasswordButton
                , poweredByCydeoText));

        for (int i = 0 , num = 1; i < displayWebElements.size() && num <= displayWebElements.size(); i++){
            System.out.println("< " + (num++) + ") " + displayWebElements.get(i));
        }

        //QUIT FROM DRIVERS
        driver.quit();
    }
}
