package com.amazon.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class LandingPage extends TestBase {
	
	@FindBy(id="nav-link-accountList")
	WebElement signinLink;
	
	@FindBy(xpath="//a[@data-nav-ref='nav_custrec_signin']")
	WebElement signinBtn;
	
	
	@FindBy(xpath="//a[contains(text(),'Start here.')]")
	WebElement newCustomerLink;
	
	@FindBy(xpath="//i[@class='hm-icon nav-sprite']")
	WebElement menu;
	
    @FindBy(linkText="Last-Minute Deals")
    WebElement lastMinuteDealsLink;
    
    @FindBy(linkText="Best Sellers")
    WebElement bestSellersLink;
    
    public LandingPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    
    public LoginPage validateSignIn() {
    	Actions a=new Actions(driver);
    	a.moveToElement(signinLink).build().perform();
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].click();", signinBtn);
    	//signinBtn.click();
    	return new LoginPage(driver);
    }
    public RegistrationPage validateRegistration() {
    	Actions a=new Actions(driver);
    	a.moveToElement(signinLink).click(newCustomerLink).build().perform();
    	return new RegistrationPage();
    }
}
