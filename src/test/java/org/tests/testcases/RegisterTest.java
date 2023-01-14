package org.tests.testcases;

import org.page.pages.PageRegister;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PropertyReader;
import java.time.LocalDateTime;

public class RegisterTest extends BaseTestClass {
    private PageRegister pageRegister;
    LocalDateTime dateTime = LocalDateTime.now();


    @Override
    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        pageRegister = homepage.clickOnRegister();
    }
    //this test case cover point 1 at the requirement
    @Test
    public void ValidRegister() {
        pageRegister.Register("New+user"+dateTime, "test123");
        softAssert.assertEquals(pageRegister.AlertMessage(), PropertyReader.getAlertMessage("VALID.SIGN.UP"));
        pageRegister.acceptAlert();
        softAssert.assertAll();
    }


    //this test case cover point 1 at the requirement
    @Test
    public void RegisterWithEmptyFields() {
        pageRegister.Register("", "");
        softAssert.assertEquals(pageRegister.AlertMessage(), PropertyReader.getAlertMessage("EMPTY.SIGN.UP"));
        pageRegister.acceptAlert();
        pageRegister.closeRegister();
        softAssert.assertAll();
    }

}
