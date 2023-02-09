package com.cydeo.tests.day_04_findElements_checkbox_radioButton;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_findElements {
    public static void main(String[] args) {

        //OPEN A CHROME BROWSER
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        //GO TO : "http://practice.cydeo.com/abtest"
        driver.get("http://practice.cydeo.com/abtest");

        //LOCATE ALL THE LINKS IN THE PAGE
        //MAC : option + enter
        List <WebElement> allLinks = driver.findElements(By.tagName("a"));

        //PRINT OUT THE NUMBER OF THE LINK IN THE PAGE
        System.out.println("NUMBER OF LINKS : " + allLinks.size());

        //PRINT OUT THE TEXT OF THE LINKS
        //allLinks.for -> shortcut
        for (WebElement each : allLinks){
            System.out.println("TEXT OF THE LINK " + each
            + "\nTEXT OF THE LINK : " + each.getText());
        }

        //PRINT OUT THE HREF ATTRIBUTES VALUES OF THE LINKS
        for (WebElement eachLink : allLinks){
            System.out.println("HREF VALUES : " + eachLink.getAttribute("href"));
        }
    }
}
