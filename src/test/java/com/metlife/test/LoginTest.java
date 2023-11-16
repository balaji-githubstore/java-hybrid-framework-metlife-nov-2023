package com.metlife.test;

import com.metlife.base.AutomationWrapper;
import com.metlife.pages.LoginPage;
import com.metlife.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends AutomationWrapper {

    @Test
    public void validLoginTest() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername("admin");
        loginPage.enterPassword("pass");
        loginPage.clickOnLogin();

        MainPage mainPage=new MainPage(driver);
        String actualTitle = mainPage.getMainPageTitle();
        Assert.assertEquals(actualTitle, "OpenEMR");
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername("john");
        loginPage.enterPassword("pass");
        loginPage.clickOnLogin();

        String actualError = loginPage.getInvalidErrorMessage();
        Assert.assertEquals(actualError, "Invalid username or password");
    }

}
