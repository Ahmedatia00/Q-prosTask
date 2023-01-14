package org.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class MainPage {
    public WebDriver driver;
    public WebDriverWait wait;

    MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
    }

    public void WaitTillAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void acceptAlert() {
        alertWait();
        driver.switchTo().alert().accept();
    }
    public void alertWait() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public String AlertMessage() {
        alertWait();
        return driver.switchTo().alert().getText();
    }
    
    public void sendText(WebElement element, String text) {
        WaitTillAppear(element);
        element.clear();
        element.sendKeys(text);
    }

}
