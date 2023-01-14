package org.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHome extends MainPage {
    public PageHome(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Cart")
    WebElement CartLink;

    @FindBy(linkText = "Log in")
    WebElement LoginLink;

    @FindBy(linkText = "Sign up")
    WebElement RegisterLink;

    @FindBy(linkText = "Log out")
    WebElement LogoutLink;

    @FindBy(id = "nameofuser")
    WebElement WelcomeLink;

    @FindBy(linkText = "Samsung galaxy s6")
    WebElement SamsungMobileLink;

    @FindBy(linkText = "Add to cart")
    WebElement AddLink;

    public PageLogin clickOnLogin() {
        clickElement(LoginLink);
        return new PageLogin(driver);
    }

    public PageRegister clickOnRegister() {
        clickElement(RegisterLink);
        return new PageRegister(driver);
    }

    public void clickOnLogout() {
        clickElement(LogoutLink);
    }

    public PageCart SelectItemAndGoCart() {
        clickElement(SamsungMobileLink);
        clickElement(AddLink);
        acceptAlert();
        clickElement(CartLink);
        return new PageCart(driver);
    }

    public boolean WelcomeUser() {
        WaitTillAppear(WelcomeLink);
        return WelcomeLink.isDisplayed();
    }

    public boolean LoginMessage() {
        WaitTillAppear(LoginLink);
        return LoginLink.isDisplayed();
    }

    public boolean RegisterMessage() {
        WaitTillAppear(RegisterLink);
        return RegisterLink.isDisplayed();
    }

    public boolean LogoutMessage() {
        WaitTillAppear(LogoutLink);
        return LogoutLink.isDisplayed();
    }

}
