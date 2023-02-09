package com.cydeo.tests.day_05_testNGIntro_dropdowns;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class TestNG_Selenium {
    WebDriver driver;
    @BeforeMethod
    public void setUP(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3 , TimeUnit.SECONDS);
    }
    @Test
    public void seleniumTest(){
        driver.get("https://www.google.com");

        //VERIFY TITLE AS EXPECTED : "Google" - w/ASSERT
        String expectedTitle = "Google"
                ,actualTile = driver.getTitle();

        Assert.assertEquals(actualTile , expectedTitle , "TITLE VERIFICATION FAILED");
                            //WE CAN ADD OPTIONAL MASSAGE IF IT IS FAILED...
    }
    @AfterMethod
    public void tearsDown(){
        driver.quit();
    }
}
