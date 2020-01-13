package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(id="ap_email")
	WebElement emailField;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(id="ap_password")
	WebElement pwdField;
	
	@FindBy(id="signInSubmit")
	WebElement submitBtn;
	
	@FindBy(id="auth-fpp-link-bottom")
	WebElement forgotPwdLink;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	public HomePage validateLogin() {
		emailField.sendKeys(prop.getProperty("username"));
		continueBtn.click();
		pwdField.sendKeys(prop.getProperty("password"));
		submitBtn.click();
		return new HomePage(driver);
	}
	
	public boolean validateForgorPwdLink() {
		return forgotPwdLink.isDisplayed();
	}

}
