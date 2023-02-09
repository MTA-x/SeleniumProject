package com.cydeo.tests.day_03_cssSelector_xpath;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {

    //STATIC STRING TO DISPLAY RESULTS OF TESTS
    static String result;

    public static void main(String[] args) {
        //OPEN CHROME BROWSER
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //MAXIMIZE THE BROWSER
        driver.manage().window().maximize();

        //GO TO : "https://login1.nextbasecrm.com/"
        driver.get("https://login1.nextbasecrm.com/");

        //VERIFY THE LOGIN BUTTON TEXT
        //EXPECTED : "Log in"


        /////////////////////// < LOCATION SAME ELEMENT WITH DIFFERENT METHODS > ///////////////////////

        //                                          input[class='value']
        //                                          input[class='login-btn']

        // LOCATION USING CLASS ATTRIBUTE
        //WebElement singInButton = driver.findElement(By.cssSelector("input[class='login-btn']"));

        // LOCATION USING TYPE ATTRIBUTE
        //WebElement singInButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // LOCATION USING VALUE ATTRIBUTE
        WebElement singInButton = driver.findElement(By.cssSelector("input[value='Log In']"));

        String expectedButtonText = "Log In", actualButtonText = singInButton.getAttribute("value");

        if (expectedButtonText.equals(actualButtonText)) {
            result = "BUTTON TEXT VERIFICATION PASSED";
        } else result = "BUTTON TEST VERIFICATION FAILED";

        System.out.println(result); // SHOW THE RESULT OF THE EQUATION

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //QUIT FROM THE DRIVER(S)
        driver.quit();

    }
}
