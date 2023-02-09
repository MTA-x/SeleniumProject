package com.cydeo.tests.day_07_webtables_utilities_javafaker;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.BrowserUtilities;
import com.cydeo.tests.utilities.CRM_Utilities;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T3_crmLogin extends TestBase {

    @Test(priority = 1)
    public void crm_login_test() {


        driver.get("https://login1.nextbasecrm.com/");
        CRM_Utilities.crm_login(driver, "helpdesk1@cybertekschool.com", "UserUser");

        //VERIFY TITLE AS EXPECTED
        //EXPECTED TITLE IS : My tasks
        BrowserUtilities.verifyTitle(driver, "My tasks");
    }

    @Test
    public void crm_login_test2() {
        CRM_Utilities.crm_login(driver);

        //VERIFY TITLE AS EXPECTED
        //EXPECTED TITLE IS : My tasks
        BrowserUtilities.verifyTitle(driver, "My tasks");
    }
}
