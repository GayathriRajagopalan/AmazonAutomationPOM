package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Hello')]")
	WebElement Text;
	
		
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(xpath="//input[@type='submit'][@value='Go']")
	WebElement go;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	public String validateText() {
		return Text.getText();
	}
	
	public int validateMenuInNewTabs() {
		return driver.findElements(By.id("nav-xshop")).size();
	}
	
	public SearchPage validateSearchFn() {
		searchBox.sendKeys("Magnetic Blocks");
		searchBox.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	    go.click();
	    return new SearchPage(driver);
	}

}
