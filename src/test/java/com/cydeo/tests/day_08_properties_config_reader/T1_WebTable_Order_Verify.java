package com.cydeo.tests.day_08_properties_config_reader;
import com.cydeo.tests.utilities.WebDriverFactory;
import com.cydeo.tests.utilities.WebTableUtilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    WebDriver driver;
    String expected = "";
    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //GO TO : "https://practice.cydeo.com/web-tables"
        driver.get("https://practice.cydeo.com/web-tables");

    }
    @AfterMethod
    public void tearsDown(){
        driver.quit();
    }

    @Test (priority = 1)
    public void order_name_verify_test(){

        String customerOrderName = WebTableUtilities.returnOrderName(driver , "Bob Martin");
        expected = "Bob Martin";
        verification(customerOrderName , expected);

    }

    @Test (priority = 2)
    public void order_date_verify_test(){
        //Locate The cell that "Bob Martin's Order Date" text
        String customerOrderDate = WebTableUtilities.returnOrderDate(driver , "Bob Martin");
        expected = "12/31/2021";


        verification(customerOrderDate , expected);
    }

    @Test (priority = 3)
    public void test_order_verify(){
        WebTableUtilities.orderVerify(driver , "Bart Fisher" , "01/16/2021");
    }

    public void verification(String expected , String actual){
        Assert.assertEquals(expected , actual , "VERIFICATION IS FAILED");
    }
}
