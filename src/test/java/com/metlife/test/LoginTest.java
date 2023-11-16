package com.metlife.test;

import com.metlife.base.AutomationWrapper;
import com.metlife.pages.LoginPage;
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

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "OpenEMR");
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername("admin");
        loginPage.enterPassword("pass");
        loginPage.clickOnLogin();

        String actualError = driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
        Assert.assertEquals(actualError, "Invalid Username and Password");
    }

}
