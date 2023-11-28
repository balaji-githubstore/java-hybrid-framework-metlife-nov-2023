package com.metlife.springboot.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.metlife.springboot.pages.LoginPage;
import com.metlife.springboot.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.lang.reflect.Method;

//@SpringBootTest(classes = {TestConfig.class})
@SpringBootTest(classes = {WebDriverLibrary.class, LoginPage.class, MainPage.class})
@Configuration
@ComponentScan({"com.metlife.springboot"})
public class AutomationWrapper extends AbstractTestNGSpringContextTests {
    @Autowired
    protected WebDriver driver;
    private static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void init()
    {
        if(extent ==null)
        {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
            extent.attachReporter(spark);
        }
    }

    @AfterSuite
    public void end()
    {
        extent.flush();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setup(@Optional("ch") String browserName, Method mtd) {

         test=extent.createTest(mtd.getName());

//        if (browserName.equalsIgnoreCase("edge")) {
//            driver = new EdgeDriver();
//        } else if (browserName.equalsIgnoreCase("ff")) {
//            driver = new FirefoxDriver();
//        } else {
//            driver = new ChromeDriver();
//        }
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.get("https://demo.openemr.io/b/openemr");
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }

        driver.quit();
    }
}
