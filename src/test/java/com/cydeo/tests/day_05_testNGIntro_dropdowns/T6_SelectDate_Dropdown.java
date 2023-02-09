package com.cydeo.tests.day_05_testNGIntro_dropdowns;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class T6_SelectDate_Dropdown {
    List<String> expectedDates = new ArrayList<>(Arrays.asList("1932", "December", "1"));
    static WebDriver driver;

    @BeforeClass
    public void setUpMethod() {
        //Open chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //Go to : "https://practice.cydeo.com/dropdown"
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void setDate() throws InterruptedException {
        String actualYear = "", acutalMonth = "", acutalDay = "";

        List<String> idOfTags = new ArrayList<>(Arrays.asList("year", "month", "day"));
        List<String> actualSelectedDates = new ArrayList<>(Arrays.asList(actualYear , acutalMonth , actualYear));

        WebElement currentlySelectedDate;


        for (int i = 0; i < idOfTags.size(); i++) {
            Select selectDropdown = new Select(driver.findElement(By.id(idOfTags.get(i))));

            selectDropdown.selectByValue(expectedDates.get(i));
            currentlySelectedDate = selectDropdown.getFirstSelectedOption();
            actualSelectedDates.set(i , currentlySelectedDate.getText());
        }

       verification(actualYear  , acutalMonth , acutalDay);
    }

    public void verification(String actualYear, String acutalMonth, String acutalDay){
        List<String> takenDates = new ArrayList<>(Arrays.asList(actualYear , acutalMonth , acutalDay));

        for (int i = 0; i < expectedDates.size(); i++){
            Assert.assertEquals(takenDates.get(i) , expectedDates.get(i));
        }
    }
}


