package com.metlife.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class AutomationWrapper {
    protected WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.openemr.io/b/openemr");
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}
