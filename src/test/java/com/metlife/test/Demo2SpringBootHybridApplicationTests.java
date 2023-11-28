package com.metlife.test;


import com.metlife.base.WebDriverLibrary;
import com.metlife.pages.LoginPage1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
@Configuration
@ComponentScan({"com.metlife"})
public class Demo2SpringBootHybridApplicationTests extends AbstractTestNGSpringContextTests {
	@Autowired
	private WebDriver driver;

	@Autowired
	private LoginPage1 loginPage;


	@Value("${app.browser}")
	private String browserName;

	@Value("${app.url}")
	private String appUrl;

	@Test
	public void titleTest() {
		System.out.println("hello test1");
		System.out.println(browserName);
		System.out.println(appUrl);

//		LoginPage loginPage=new LoginPage(); //object is created through bean- can get using autowired
		loginPage.enterUsername("jack");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.id("authUser")).sendKeys("hello1");
//		driver.findElement(By.id("login-button")).click();
		loginPage.clickOnLogin();
	}

	@Test
	public void headerTest() {
		System.out.println("hello test1");
		System.out.println(browserName);
		System.out.println(appUrl);

//		LoginPage loginPage=new LoginPage(); //object is created through bean- can get using autowired
		loginPage.enterUsername("killbeggan");
//		System.out.println(driver.getCurrentUrl());
//		driver.findElement(By.id("authUser")).sendKeys("hello2");
//		driver.findElement(By.id("login-button")).click();
		loginPage.clickOnLogin();
	}

}
