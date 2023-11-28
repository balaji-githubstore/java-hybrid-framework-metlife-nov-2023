package com.metlife.test;


import com.metlife.pages.LoginPage1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest(classes = {LoginPage1.class})
public class Demo1SpringBootHybridApplicationTests extends AbstractTestNGSpringContextTests {

	@Autowired
	private LoginPage1 loginPage;

	@Value("${app.browser}")
	private String browserName;

	@Value("${app.url1}")
	private String appUrl;

	@Test
	public void titleTest() {
		System.out.println("hello test1");
		System.out.println(browserName);
		System.out.println(appUrl);

//		LoginPage loginPage=new LoginPage();
		loginPage.enterUsername("jack");
	}

}
