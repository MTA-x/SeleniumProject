package com.cydeo.tests.day_08_properties_config_reader;

import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class T4_ConfigPractice {

    static WebDriver driver;

    @BeforeClass
    public void setUpMethod(){
        //Getting the browser type dynamically from our configuration.properties file
        String browser = ConfigurationReader.getProperty("chrome");

        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        driver.get("http://www.google.com");
    }

    @AfterClass
    public void tearsDown(){
        driver.quit();
    }

    @Test
    public void google_search_text(){
        // xpathOfGoogleSearchBox = "input[@class='gLFyf']"

        //Locate Google search-box
        WebElement googleSearchBox = driver.findElement(By.xpath("//input[@class='gLFyf']"));

        //Write "apple" on search-box
        googleSearchBox.sendKeys("apple" + Keys.ENTER);

        //Verify title : "apple - Google Search"

        String expectedTitle = "apple"
                , actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle , actualTitle , "TITLE VERIFICATION FAILED");


    }
}
