package com.metlife.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickOnPatientMenu(){
        driver.findElement(By.xpath("")).click();
    }
    public void clickOnNewSearchMenu(){
        driver.findElement(By.xpath("")).click();
    }
}
