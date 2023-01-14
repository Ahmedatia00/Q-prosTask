package org.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PageCart extends MainPage {
    public PageCart(WebDriver driver) {
        super(driver);
    }

    Random random = new Random();
    int numOfProducts;

    @FindBy(linkText = "Delete")
    List<WebElement> DeleteItem;

    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement OrderBtn;

    @FindBy(id = "name")
    WebElement UserNameOrder;

    @FindBy(id = "country")
    WebElement UserCounty;

    @FindBy(id = "city")
    WebElement UserCity;

    @FindBy(id = "card")
    WebElement CardID;

    @FindBy(id = "month")
    WebElement Month;

    @FindBy(id = "year")
    WebElement Year;

    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement PurchaseBtn;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    WebElement SuccessfulPurchase;


    @FindBy(xpath = "//button[text()='OK']")
    WebElement buttonOk;

    public void deleteProduct() {
        numOfProducts = DeleteItem.size();
        int index = random.nextInt(numOfProducts);
        clickElement(DeleteItem.get(index));
    }

    public boolean CheckDelete() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return numOfProducts > DeleteItem.size();
    }
    public void PlaceOrder() {
        clickElement(OrderBtn);
    }

    public void InsertUserData(String name, String country, String city,
                               String card, String month, String year) {
        sendText(UserNameOrder, name);
        sendText(UserCounty, country);
        sendText(UserCity, city);
        sendText(CardID, card);
        sendText(Month, month);
        sendText(Year, year);
    }

    public void Purchase() {
        clickElement(PurchaseBtn);
    }

    public String getSuccessMessage() {
        WaitTillAppear(SuccessfulPurchase);
        return SuccessfulPurchase.getText();
    }

    public PageHome clickOnOk() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        clickElement(buttonOk);
        return new PageHome(driver);
    }



}
