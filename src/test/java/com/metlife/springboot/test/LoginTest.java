package com.metlife.springboot.test;

import com.aventstack.extentreports.Status;
import com.metlife.springboot.base.AutomationWrapper;
import com.metlife.springboot.pages.LoginPage;
import com.metlife.springboot.pages.MainPage;
import com.metlife.springboot.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest extends AutomationWrapper {
    @Autowired
    private LoginPage loginPage;
    @Autowired
    private MainPage mainPage;

    @Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class,
            groups = {"login","smoke"})
    public void validLoginTest(String username,String password,String expectedValue) {
//        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername(username);
        test.log(Status.INFO,"Entered Username: "+username);
        loginPage.enterPassword(password);
        test.log(Status.INFO,"Entered Password: "+password);
        loginPage.clickOnLogin();
        test.log(Status.INFO,"Clicked on login");
//        MainPage mainPage=new MainPage(driver);
        String actualTitle = mainPage.getMainPageTitle();
        test.log(Status.INFO,"Actual Title: "+actualTitle);
        Assert.assertEquals(actualTitle, expectedValue);
    }

    @Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class,groups = {"login"})
    public void invalidLoginTest(String username,String password,String expectedError) {
//        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLogin();

        String actualError = loginPage.getInvalidErrorMessage();
        Assert.assertEquals(actualError, expectedError);
    }

}
