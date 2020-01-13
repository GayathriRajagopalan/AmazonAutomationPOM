package com.amazon.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.LandingPage;
import com.amazon.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LandingPage landingpage;
	LoginPage loginpage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		landingpage=new LandingPage(driver);
		landingpage.validateSignIn();
		loginpage=new LoginPage(driver);
	}
	
	@Test
	public void verifyLoginFn() {
		loginpage.validateLogin();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
