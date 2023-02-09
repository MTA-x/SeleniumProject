package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {
    public static void main(String[] args) {

        //TC #1 : Yahoo Title Verification

        /**
         * 1) OPEN CHROME BROWSER
         * 2) DO THE SETUP OF THE BROWSER
         * 3) GO TO "https://www.yahoo.com"
         * 4) Verify Title
         * EXPECTED : Yahoo
         * **/

        String expectedTitle = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

        // Setting up the web driver
        WebDriverManager.chromedriver().setup();

        // Define The web driver
        WebDriver driver = new ChromeDriver();

        // TURN THE FULL SCREEN OF THE CURRENT WINDOW
        driver.manage().window().maximize();

        // GO TO THE PAGE OF GIVEN URL
        driver.get("https://www.yahoo.com");

        // GET TITLE OF URL
        String actualTitle = driver.getTitle();

        driver.close();

        // Compare the titles
        String result = (expectedTitle.equals(actualTitle))
                ? "Titles are equal"
                : "Titles Are Not Equal";

        //Show the result
        System.out.println(result);


    }
}
