package com.metlife.springboot.test;

import com.metlife.springboot.base.AutomationWrapper;
import com.metlife.springboot.pages.LoginPage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginUITest extends AutomationWrapper {

    @Autowired
    private LoginPage loginPage;
    @Test(groups = {"ui","smoke"})
    public void titleTest()
    {
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,"OpenEMR Login");
    }

    @Test(groups = {"ui"})
    public void applicationDescriptionTest()
    {
        String actualDesc=driver.findElement(By.xpath("//p[contains(text(),'most')]")).getText();
        Assert.assertEquals(actualDesc,
                "The most popular open-source Electronic Health Record and Medical Practice Management solution.");
    }

    @Test(groups = {"ui"})
    public void placeholderTest()
    {
//        LoginPage loginPage=new LoginPage(driver);

        Assert.assertEquals(loginPage.getUsernamePlaceholder(),"Username");
        Assert.assertEquals(loginPage.getPasswordPlaceholder(),"Password");
    }
}
