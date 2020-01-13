package com.amazon.testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.HomePage;
import com.amazon.pages.LandingPage;
import com.amazon.pages.LoginPage;

public class HomePageTest extends TestBase {
	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		landingpage=new LandingPage(driver);
		landingpage.validateSignIn();
		loginpage=new LoginPage(driver);
		loginpage.validateLogin();
		homepage=new HomePage(driver);
	}
	
	@Test
	public void verifyText() {
		String text=homepage.validateText();
		Assert.assertEquals(text, "Hello, Ravi");
	}
	@Test
	public void verifyTopMenus() throws InterruptedException {
		WebElement menus=driver.findElement(By.id("nav-xshop"));
		List<WebElement>list=menus.findElements(By.className("nav-a"));
		int count=list.size();
		for(int i=0;i<count;i++) {
			list.get(i).sendKeys(Keys.CONTROL,Keys.ENTER);
			Thread.sleep(2000);
		}
		
		Set<String>id=driver.getWindowHandles();
		Iterator<String>it=id.iterator();
	    while(it.hasNext()) {
	    	driver.switchTo().window(it.next());
	    	System.out.println(driver.getTitle());
	    }

	}
	@Test
	public void verifySearchFn() {
		homepage.validateSearchFn();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
