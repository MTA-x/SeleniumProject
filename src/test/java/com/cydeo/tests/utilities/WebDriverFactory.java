package com.cydeo.tests.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

@SuppressWarnings("ALL")
public class WebDriverFactory {
    public static WebDriver getDriver(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserType.equals("safari")) {
            WebDriverManager.safaridriver();
            return new SafariDriver();
        }else {
            System.out.println("GIVEN BROWSER TYPE DOES NOT EXIST OR CURRENTLY DOES NOT SUPPORT : " + browserType
                    + "\nDriver : " + null);
            return null;
        }
    }
}
