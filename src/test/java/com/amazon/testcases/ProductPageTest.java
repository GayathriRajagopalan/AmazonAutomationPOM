package com.amazon.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.amazon.base.TestBase;
import com.amazon.pages.HomePage;
import com.amazon.pages.LandingPage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.SearchPage;

public class ProductPageTest extends TestBase{
	
	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	SearchPage searchpage;
	ProductPage productpage;
	SearchpageTest searchpagetest;
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		landingpage=new LandingPage(driver);
		landingpage.validateSignIn();
		loginpage=new LoginPage(driver);
		loginpage.validateLogin();
		homepage=new HomePage(driver);
		homepage.validateSearchFn();
		searchpage=new SearchPage(driver);
		searchpage.validateSelectingBrand();
		searchpage.validateSelectOption();
		productpage=new ProductPage(driver);
			
	}
	/*
	 * @Test(priority=1) public void verifyAmazonLogo() { boolean
	 * flag=productpage.validateLogo(); Assert.assertTrue(flag);
	 * 
	 * }
	 * 
	 * @Test(priority=2) public void verifyMagformerName() { String
	 * title=productpage.validateMagformersname(); Assert.assertEquals(title,
	 * "Magformers"); }
	 */
	
		
	@Test(priority=1)
	public void verifyAddCartOption() {
		productpage.validateAddCart();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
