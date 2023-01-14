package org.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageLogin extends MainPage {
    public PageLogin(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "loginusername")
    WebElement UsernameLogin;

    @FindBy(id = "loginpassword")
    WebElement PasswordLogin;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement LoginBtn;


    public void login(String username, String password) {
        sendText(UsernameLogin, username);
        sendText(PasswordLogin, password);
        clickElement(LoginBtn);
    }
}
