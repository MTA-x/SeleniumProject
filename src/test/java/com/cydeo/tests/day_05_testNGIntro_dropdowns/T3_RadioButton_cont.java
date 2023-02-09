package com.cydeo.tests.day_05_testNGIntro_dropdowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_RadioButton_cont {
    public static void main(String[] args) throws InterruptedException {
        //Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Go To : "https://practice.cydeo.com/radio_buttons"
        driver.get("https://practice.cydeo.com/radio_buttons");

        //Click to “Hockey” radio button
        WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        Thread.sleep(2000);
        hockeyButton.click();

        //LOCATE THE "name='sport'" RADIO BUTTONS AND STORE THEM IN A LIST OF WEB-ELEMENTS
        clickAndVerifyButton(driver , "sport" , "hockey");
        clickAndVerifyButton(driver , "sport" , "football");
        clickAndVerifyButton(driver , "color" , "yellow");

        // QUIT FROM DRIVERS
        driver.quit();
    }

    private static void clickAndVerifyButton(WebDriver driver , String nameAttributive , String idValue){
        List<WebElement> driverElementsRadioButtons = driver.findElements(By.name(nameAttributive));

        for (WebElement each : driverElementsRadioButtons) {
            String eachId = each.getAttribute("id");
            System.out.println("eachId = " + eachId);

            if (eachId.equals(idValue)) {
                each.click();
                System.out.println( eachId + " isSelected() = " + each.isSelected());
                break;
            }
        }
    }
}
