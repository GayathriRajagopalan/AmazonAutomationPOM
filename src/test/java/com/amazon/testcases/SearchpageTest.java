package com.amazon.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.HomePage;
import com.amazon.pages.LandingPage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.SearchPage;

public class SearchpageTest extends TestBase {

	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	SearchPage searchpage;

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		landingpage = new LandingPage(driver);
		landingpage.validateSignIn();
		loginpage = new LoginPage(driver);
		loginpage.validateLogin();
		homepage = new HomePage(driver);
		homepage.validateSearchFn();
		searchpage = new SearchPage(driver);

	}

	@Test(priority = 1)
	public void validateSelectingBrands() {
		boolean flag = searchpage.validateSelectingBrand();
		Assert.assertTrue(flag);

	}

	@Test(priority = 2)
	public void validateSelection() {
		searchpage.validateSelectOption();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
