package com.cydeo.tests.day_11_actions_jsexecutor_practice;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_N_Drop {

    @Test
    public void drag_and_drop_test() {
        //Go to : "https://demos.telerik.com/kendo-ui/dragdrop/index"
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //Locate "Accept Cookies" button and click
        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();

        //Locate big and small circles
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("droptarget"));

        //Drag and drop the small circle to bigger circle
        Actions actions = new Actions(Driver.getDriver());

        //actions.dragAndDrop(smallCircle, bigCircle).perform();
        actions.clickAndHold(smallCircle)
                .pause(2000)
                .release()
                .perform();

        //Assert : Text in big circle changed to : "You did great!"
        String expectedTitle = "You did great!", actualTitle = bigCircle.getText();

        Assert.assertEquals(expectedTitle, actualTitle, "TITLE VERIFICATION FAILED");
    }
}
