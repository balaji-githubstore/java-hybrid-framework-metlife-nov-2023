package com.metlife.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ZDemo3Extent {

    public static void main(String[] args) {

        //runs only once in the before all test methods - @BeforeSuite
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);

        //just before each @Test method - @BeforeMethod
        ExtentTest test= extent.createTest("MyFirstTest-Balaji Dinakaran");

        //@Test method runs

        //run after each @Test method - @AfterMethod
        test.log(Status.FAIL, "This is a logging event for MyFirstTest, and it passed!");

        //runs after executing all the @Test methods - @AfterSuite
        extent.flush();

    }
}
