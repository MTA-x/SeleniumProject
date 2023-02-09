package com.cydeo.tests.day_05_testNGIntro_dropdowns;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro{
    @Test (priority = 1)
    public void test1(){
        System.out.println("TEST 1 IS RUNNING");
        String actual = "cydeo"
                , expected = "cydeo";

        Assert.assertEquals(actual , expected);
    }
    @Test (priority = 2)
    public void test2(){
        System.out.println("TEST 1 IS RUNNING");

        String expected = "apple",
                actual = "apple2";

        Assert.assertTrue(actual.equals(expected));
    }
    @BeforeClass
    public void setUp(){
        System.out.println("Setting UP");
    }
    @AfterClass
    public void tearsDown(){
        System.out.println("Tears are DOWN");
    }
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("------> BEFORE METHOD IS RUNNING < ------");
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("------> AFTER METHOD IS RUNNING < ------");
    }
}
