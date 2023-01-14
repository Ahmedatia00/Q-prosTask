package org.tests.testcases;

import org.page.pages.PageHome;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import utilities.PropertyReader;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public  class BaseTestClass {
    static WebDriver driver;
    public SoftAssert softAssert;
    public PageHome homepage;

    @BeforeSuite
    void start() {
        driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to(PropertyReader.getProperty("BASE.URL"));
    }

    @BeforeClass
    void beforeClass() {
        homepage = new PageHome(driver);
    }

    @BeforeMethod
    void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @AfterSuite(alwaysRun = true)
    void Exit() {
        WebDriverFactory.stopDriver();
    }
}
