package com.metlife.springboot.pages;

import com.metlife.springboot.base.WebDriverKeywords;
import org.openqa.selenium.By;

public class MainPage extends WebDriverKeywords {

//    private WebDriver driver;

//    public MainPage(WebDriver driver)
//    {
//        super(driver);
//        this.driver=driver;
//    }

    public void clickOnPatientMenu(){
        driver.findElement(By.xpath("")).click();
    }
    public void clickOnNewSearchMenu(){
        driver.findElement(By.xpath("")).click();
    }

    public String getMainPageTitle()
    {
        return driver.getTitle();
    }
}
