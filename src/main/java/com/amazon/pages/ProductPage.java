package com.amazon.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class ProductPage extends TestBase {
		
	@FindBy(id="bylineInfo")
	WebElement MagformersName;
	
	@FindBy(xpath="//i[@class='a-icon a-icon-dropdown']")
	WebElement qtyDropDown;
	
	@FindBy(id="quantity_2")
	WebElement selectionTwo;
	
	@FindBy(id="add-to-cart-button")
	WebElement addToCart;
	
	@FindBy(id="attachSiNoCoverage-announce")
	WebElement protectionPlan;
	
	@FindBy(xpath="//span[@class='nav-sprite nav-logo-base']")
	WebElement logo;
	
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
		
	 public String validateMagformersname() {
		 return MagformersName.getText();
	 }
	 
	 public CheckOutPage validateAddCart() {
		 //qtyDropDown.click();
		
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", qtyDropDown);
		  selectionTwo.click();
		 
		 addToCart.click();
		 protectionPlan.click();
		 return new CheckOutPage();
	 }

}
