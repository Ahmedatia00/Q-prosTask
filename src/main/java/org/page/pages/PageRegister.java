package org.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageRegister extends MainPage {
    public PageRegister(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sign-username")
    WebElement UserName;

    @FindBy(id = "sign-password")
    WebElement Password;

    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    WebElement RegisterBtn;

    @FindBy(xpath = "(//span[text()='×'])[2]")
    WebElement XBtn;

    public void Register(String username, String password) {
        sendText(UserName, username);
        sendText(Password, password);
        clickElement(RegisterBtn);
    }
    public void closeRegister(){
        clickElement(XBtn);
    }
}
