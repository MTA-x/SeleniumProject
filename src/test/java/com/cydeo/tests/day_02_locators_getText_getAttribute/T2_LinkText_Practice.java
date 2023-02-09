package com.cydeo.tests.day_02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkText_Practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // GO TO CYDEO WEB PAGE
        driver.get("https://www.cydeo.com");

        //CLICK THE A/B TESTING FROM THE TOP LIST
        //driver.findElement(By.linkText("Programs")).click();
        WebElement abTesting = driver.findElement(By.linkText("Programs"));
        abTesting.click();

        //VERIFY THE TITLE
        String expectedTitle = "Programs";
        String actualTitle = driver.getTitle();

        System.out.println((expectedTitle.equals(actualTitle)
                ? "TITLE VERIFICATION PASSED"
                : "TITLE VERIFICATION NOT PASSED"));

        //GO BACK TO PREVIOUS PAGE
        driver.navigate().back();

        //VERIFY THE TITLE
        String expectedTitle2 = "Cydeo";
        actualTitle = driver.getTitle();

        System.out.println((expectedTitle2.equals(actualTitle)
                ? "TITLE VERIFICATION PASSED"
                : "TITLE VERIFICATION NOT PASSED"));

        Thread.sleep(3000);
        driver.quit();



    }
}
