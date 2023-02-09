package com.cydeo.tests.day_03_cssSelector_xpath;

import com.cydeo.tests.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {
    static String result;
    public static void main(String[] args) {
        //OPEN CHROME BROWSER
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //MAXIMIZE THE SCREEN
        driver.manage().window().maximize();

        //GO TO : "https://login1.nextbasecrm.com/?forgot_password=yes"
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //VERIFY "Reset Password" BUTTON TEXT EXPECTED : "Reset Password"
        WebElement resetButtonText = driver.findElement(By.cssSelector("button[value='Reset password']"));
        String expectedResetPasswordButtonText = "Reset password"
                ,actualResetPasswordText = resetButtonText.getText();

        if (expectedResetPasswordButtonText.equals(actualResetPasswordText)){result = "RESET BUTTON TEXT VERIFICATION PASSED";}
        else result = "RESET BUTTON TEXT VERIFICATION FAILED";


        System.out.println(result);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //QUIT FROM DRIVERS
        driver.quit();

    }
}
