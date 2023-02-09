package com.cydeo.tests.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class Driver {
    //Creating a private constructor
    //Closing access to the object of this class from outside the class
    private Driver() {
    }

    //Make Webdriver private because we want to close access from outside of the class
    //We make it static we will use it in a static method
    private static WebDriver driver;

    //Create re-usable utility method which will return same driver instance when we call it
    public static WebDriver getDriver() {

        if (driver == null) {
            //We read our browserType from configuration.properties
            // This way , we can control which browser is opened from outside of our code
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit(); //terminate existing sections
            driver = null;
        }
    }

}
