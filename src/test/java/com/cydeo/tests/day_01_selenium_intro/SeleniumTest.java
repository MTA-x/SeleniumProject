package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        //1 - Setting Up The Web Driver Manager
        WebDriverManager.chromedriver().setup();

        //2 - Create Instance Of The Chrome Driver
        WebDriver driver = new ChromeDriver();

        //3 - Test If Driver Is Working As Expected
        driver.get("https://longline.com.tr/");

    }
}
