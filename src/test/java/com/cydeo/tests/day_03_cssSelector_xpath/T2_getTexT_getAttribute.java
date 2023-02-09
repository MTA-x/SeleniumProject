package com.cydeo.tests.day_03_cssSelector_xpath;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@SuppressWarnings("ALL")
public class T2_getTexT_getAttribute {

    static String result = "";

    public static void main(String[] args) {
        //OPEN A CHROME BROWSER
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //MAXIMIZE THE SCREEN
        driver.manage().window().maximize();

        //GO TO : "https://login1.nextbasecrm.com/"
        driver.get("https://login1.nextbasecrm.com/");

        //VERIFY "remember me" label text is expected
        //Expected : Remember me on this computer
        WebElement rememberMeLaber = driver.findElement(By.className("login-item-chechbox-label"));

        String expectedRememberMeLabel = "Remember me on this computer"
                , actualRememberMeLabel = rememberMeLaber.getText();

        if (actualRememberMeLabel.equals(expectedRememberMeLabel)){result = "LABEL VERIFICATION PASSED";}
        else result = "LABEL VERIFICATION FAILED";
        System.out.println(result); //DISLAY THE VERIFICARTION OF REMEMBER ME LABEL

        //VERIFY "forgot password" href attribute's value contains expected
        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String expectedForgotPasswordLink = "Forgot your password?"
                , actualForgotPasswordLink = forgotPasswordLink.getText();

        if (actualForgotPasswordLink.equals(expectedForgotPasswordLink)){result = "FORGOT PASSWORD LINK VERIFICATION PASSED";}
        else result = "FORGOT PASSWORD LINK VERIFICATION FAILED";
        System.out.println(result); //DISLAY THE VERIFICARTION OF PASSWORD

        //Expected : forgot_password=yes
        String expectedInHref = "forgot_password=yes"
                , actualInHref = forgotPasswordLink.getAttribute("href");
        if (actualInHref.equals(expectedInHref)){result = "HREF ATTRIBUTE VERIFICATION PASSED";}
        else result = "HREF ATTRIBUTE VERIFICATION FAILED";



    }
}
