package com.metlife.base;

import com.metlife.pages.LoginPage;
import com.metlife.pages.MainPage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootTest(classes = {WebDriverLibrary.class, LoginPage.class, MainPage.class})
@Configuration
@ComponentScan({"com.metlife.base","com.metlife.pages","com.metlife"})
public class TestConfig {
}
