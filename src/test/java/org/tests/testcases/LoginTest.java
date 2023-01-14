package org.tests.testcases;
import org.page.pages.PageLogin;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.PropertyReader;

public class LoginTest extends BaseTestClass {
    private PageLogin pageLogin;

    @Override
    @BeforeClass
    void beforeClass() {
        super.beforeClass();
        pageLogin = homepage.clickOnLogin();
    }
    //this test case cover point 1 at the requirement
    @Test
    public void loginWithEmptyFields() {
        pageLogin.login("","");
        softAssert.assertEquals(pageLogin.AlertMessage(), PropertyReader.getAlertMessage("EMPTY.LOGIN"));
        pageLogin.acceptAlert();
        softAssert.assertAll();
    }
    //this test case cover point 1 at the requirement
    @Test
    public void loginWithInvalidUsername() {
        pageLogin.login("test123", "test");
        softAssert.assertEquals(pageLogin.AlertMessage(), PropertyReader.getAlertMessage("WRONG.PASSWORD.LOGIN"));
        pageLogin.acceptAlert();
        softAssert.assertAll();
    }
    //this test case cover point 1 at the requirement
    @Test
    public void validLogin() {
        pageLogin.login("ahmed009", "ahmed009!");
        softAssert.assertTrue(homepage.WelcomeUser());
        softAssert.assertTrue(homepage.LogoutMessage());
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "validLogin")
    public void logout() {
        homepage.clickOnLogout();
        softAssert.assertTrue(homepage.LoginMessage());
        softAssert.assertTrue(homepage.RegisterMessage());
        softAssert.assertAll();
    }
}
