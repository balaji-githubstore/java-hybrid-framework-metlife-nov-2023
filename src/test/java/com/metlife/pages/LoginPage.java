package com.metlife.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private By usernameLocator=By.id("authUser");
    private By passwordLocator=By.cssSelector("#clearPass");
    private By loginLocator=By.id("login-button");
    private By errorLocator=By.xpath("//p[contains(text(),'Invalid')]");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickOnLogin() {
        driver.findElement(loginLocator).click();
    }

    public String getInvalidErrorMessage() {
        return driver.findElement(errorLocator).getText();
    }

    public String getUsernamePlaceholder() {
        return driver.findElement(usernameLocator).getAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        return driver.findElement(passwordLocator).getAttribute("placeholder");
    }

}
