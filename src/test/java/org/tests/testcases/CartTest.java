package org.tests.testcases;

import org.page.pages.PageCart;
import org.page.pages.PageHome;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PropertyReader;

public class CartTest extends BaseTestClass {
    private PageCart pageCart;
    private PageHome pageHome;

    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        pageCart = homepage.SelectItemAndGoCart();

    }
;
   // this test case cover point 3,4 at the requirement
    @Test(priority = 2)
    public void cartSelectItemAndDelete() throws InterruptedException {
        pageCart.deleteProduct();
        Assert.assertTrue(pageCart.CheckDelete());
    }
    //this test case cover point 5 at the requirement
    @Test(priority = 1)
    public void checkoutWithItem() throws InterruptedException {

        pageCart.PlaceOrder();
        pageCart.InsertUserData("AhmedAtia", "Egypt" ,"Cairo",
               "testCard", "Jan", "2023");
        pageCart.Purchase();
        softAssert.assertEquals(pageCart.getSuccessMessage(), PropertyReader.getAlertMessage("SUCCESSFUL.PURCHASE"));
        pageHome = pageCart.clickOnOk();
        softAssert.assertAll();
    }
}
