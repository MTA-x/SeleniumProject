package com.cydeo.tests.day_02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {

        //OPEN A CHROME BROWSER
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //GO TO : https://www.google.com
        driver.get("https://www.google.com");

        //WRITE APPLE IN SEARCH BOX
        WebElement googleSearchBox = driver.findElement(By.name("q"));

        //PRESS ENTER USING KEYS
        Thread.sleep(2000);
        googleSearchBox.sendKeys("apple" + Keys.ENTER);

        //VERIFY TITLE
        String expectedInTitle = "apple";
        String actualInTitle = driver.getTitle();

        System.out.println( (expectedInTitle.equals(actualInTitle))
                ? "TITLE VERIFICATION PASSED"
                : "TITLE VERIFICATION FAILED"
        + "\nTITLE IS : " +actualInTitle);

        Thread.sleep(3000);
        driver.quit();

    }
}
