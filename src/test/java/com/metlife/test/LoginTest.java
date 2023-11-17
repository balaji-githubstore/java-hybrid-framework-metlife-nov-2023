package com.metlife.test;

import com.aventstack.extentreports.Status;
import com.metlife.base.AutomationWrapper;
import com.metlife.pages.LoginPage;
import com.metlife.pages.MainPage;
import com.metlife.utils.DataUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends AutomationWrapper {

    @Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class,
            groups = {"login","smoke"})
    public void validLoginTest(String username,String password,String expectedValue) {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername(username);
        test.log(Status.INFO,"Entered Username: "+username);
        loginPage.enterPassword(password);
        test.log(Status.INFO,"Entered Password: "+password);
        loginPage.clickOnLogin();
        test.log(Status.INFO,"Clicked on login");
        MainPage mainPage=new MainPage(driver);
        String actualTitle = mainPage.getMainPageTitle();
        test.log(Status.INFO,"Actual Title: "+actualTitle);
        Assert.assertEquals(actualTitle, expectedValue);
    }

    @Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class,groups = {"login"})
    public void invalidLoginTest(String username,String password,String expectedError) {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLogin();

        String actualError = loginPage.getInvalidErrorMessage();
        Assert.assertEquals(actualError, expectedError);
    }

}
