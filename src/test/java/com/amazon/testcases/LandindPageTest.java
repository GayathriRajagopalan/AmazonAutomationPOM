package com.amazon.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.LandingPage;


public class LandindPageTest extends TestBase {
	LandingPage landingpage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		landingpage=new LandingPage(driver);
		
	}
	@Test
	public void verifySigninLink() {
		landingpage.validateSignIn();
	}
	
	
	
	@AfterMethod
	public void teatDown() {
		driver.quit();
	}

}
