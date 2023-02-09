package com.cydeo.tests.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtilities {

    public static String returnOrderName(WebDriver driver, String customerName) {
        return driver.findElement(By.xpath("//table[@class='SampleTable']//tbody//td[." +
                "=" + "'" + customerName + "'" + "]")).getText();
    }

    public static String returnOrderDate(WebDriver driver, String orderDate) {
        return driver.findElement(By.xpath("//table[@class='SampleTable']//tbody//td[." +
                "=" + "'" + orderDate + "'" + "]/following-sibling::td[3]")).getText();
    }

    public static void orderVerify(WebDriver driver, String customerName, String expectedOrderDate) {

        WebElement customerDateCell = driver.findElement(By.xpath("//table[@class='SampleTable']//tbody//td[." +
                "=" + "'" + customerName + "'" + "]/following-sibling::td[3]"));

        //preceding-siblings::[index]

        String actualOrderDate =  customerDateCell.getText();

        Assert.assertEquals(actualOrderDate , expectedOrderDate);
    }
}
