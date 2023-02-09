package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        // Settinh up the driver
        WebDriverManager.chromedriver().setup();

        //This th eline opening an empty browser
        WebDriver driver = new ChromeDriver();

        //Maximize the current browser
        driver.manage().window().maximize();


        //driver.manage().window().fullscreen();


        //3- Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        // Use selenium to navigate back
        driver.navigate().back();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate forward
        driver.navigate().forward();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate refresh
        driver.navigate().refresh();

        //use navigate.to
        driver.navigate().to("https://www.google.com");

        //get the title of the page
        //System.out.println(driver.getTitle());
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);

        // Get the current URL with using Selenium
        String currentURL  = driver.getCurrentUrl();
        System.out.println(currentTitle);

        // This will close the currently opened tab/window
        driver.close();

        // This will close all of thr opened tab/windows
        driver.quit();

    }
}
