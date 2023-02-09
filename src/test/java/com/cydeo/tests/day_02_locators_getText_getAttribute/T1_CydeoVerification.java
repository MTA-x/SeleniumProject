package com.cydeo.tests.day_02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerification {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String expectedTitle = "Cydeo";
        String expectedUrl = "https://cydeo.com";

        driver.get("https://www.cydeo.com");
        //driver.navigate().to("https://www.cydeo.com");

        System.out.println((expectedTitle.equals(driver.getTitle())
                ? "TITLE VERIFICATION PASSED"
                : "TITLE VERIFICATION FAILED")

        + "\n< -------------------------------------- > ");

        System.out.println((expectedUrl.equals(driver.getCurrentUrl())
                ? "URL VERIFICATION PASSED"
                : "URL VERIFICATION FAILED"));

        Thread.sleep(3000);
        driver.quit();


    }
}
