package com.metlife.pages;

import com.metlife.base.WebDriverKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginPage1 extends WebDriverKeywords {

    private By usernameLocator=By.id("authUser");
    private By passwordLocator=By.cssSelector("#clearPass");
    private By loginLocator=By.id("login-button");
    private By errorLocator=By.xpath("//p[contains(text(),'Invalid')]");

    public void enterUsername(String username) {
        //driver.findElement(usernameLocator).sendKeys(username);
        super.typeOnElement(usernameLocator,username);
    }

    public void enterPassword(String password) {
//        driver.findElement(passwordLocator).sendKeys(password);
        typeOnElement(passwordLocator,password);
    }

    public void clickOnLogin() {
//        driver.findElement(loginLocator).click();
        super.clickOnElement(loginLocator);
    }
}
