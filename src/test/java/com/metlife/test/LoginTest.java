package com.metlife.test;

import com.metlife.base.AutomationWrapper;
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
    public void validLoginTest(){
        driver.findElement(By.id("authUser")).sendKeys("admin");
        driver.findElement(By.cssSelector("#clearPass")).sendKeys("pass");
        driver.findElement(By.id("login-button")).click();

        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,"OpenEMR");
    }

    @Test
    public void invalidLoginTest()
    {
        driver.findElement(By.id("authUser")).sendKeys("john");
        driver.findElement(By.cssSelector("#clearPass")).sendKeys("john123");
        driver.findElement(By.id("login-button")).click();

        String actualError=driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
        Assert.assertEquals(actualError,"Invalid Username and Password");
    }

}
