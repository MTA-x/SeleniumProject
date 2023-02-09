package com.cydeo.tests.day_10_upload_actions_jsexecutor;
import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

@SuppressWarnings("ALL")
public class T1_Registration_Form extends TestBase{

    @Test
    public void registration_form_test() {
        //1. Open browser
        //2. Go to website:https://practice.cydeo.com/registration_form
        //Driver.getDriver() --> driver
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        //Create a JavaFaker object
        Faker faker = new Faker();

        //4. Enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());

        //5. Enter username
        //inputUsername.sendKeys(faker.name().username().replaceAll(".", ""));
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));

        String user = faker.bothify("helpdesk###");
        inputUsername.sendKeys(user);

        //6. Enter email address
        WebElement inputEmail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys(user + "@email.com");

        //Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys(faker.numerify("########"));
        //System.out.println("faker.internet().password() = " + faker.internet().password());

        //8. Enter phone number
        WebElement inputPhone = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhone.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        WebElement inputGender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        inputGender.click();

        //10.Enter date of birth
        WebElement inputBirthday = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        //faker.number().numberBetween(2004, 1920)
        inputBirthday.sendKeys("03/08/2000");

        //11.Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));
        //break until 1.05pm cst

        //Select job title
        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(2);

        //Select programming language from checkboxes
        WebElement selectProgrammingLanguage = driver.findElement(By.xpath("input[@id='inlineCheckbox2']"));
        selectProgrammingLanguage.click();

        //Click to sign up button
        WebElement singupButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        singupButton.click();

        //Verify success message “You’ve successfully completed registration.” is displayed.
        WebElement verificationMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']//p"));

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String expectedMessage = "You’ve successfully completed registration."
                , acutalMessage = verificationMessage.getText();

        Assert.assertEquals(expectedMessage
                , acutalMessage
                , "MESSAGE VERIFICATION FAILED");

    }
}
