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

        LoginPage.enterUsername(driver, "admin");
        LoginPage.enterPassword(driver, "pass");
        LoginPage.clickOnLogin(driver);

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "OpenEMR");
    }

    @Test
    public void invalidLoginTest() {
        LoginPage.enterUsername(driver, "john");
        LoginPage.enterPassword(driver, "john123");
        LoginPage.clickOnLogin(driver);

        String actualError = driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
        Assert.assertEquals(actualError, "Invalid Username and Password");
    }

}
