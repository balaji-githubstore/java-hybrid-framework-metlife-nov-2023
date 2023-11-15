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

public class LoginUITest extends AutomationWrapper {
    @Test
    public void titleTest()
    {
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,"OpenEMR Login");
    }

    @Test
    public void applicationDescriptionTest()
    {
        String actualDesc=driver.findElement(By.xpath("//p[contains(text(),'most')]")).getText();
        Assert.assertEquals(actualDesc,
                "The most popular open-source Electronic Health Record and Medical Practice Management solution.");
    }

}
