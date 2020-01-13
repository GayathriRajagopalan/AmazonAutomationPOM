package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class SearchPage extends TestBase {
	

	@FindBy(xpath="//span[contains(text(),'HLAOLA Magnetic Blocks Upgrade')]")
	WebElement mySearch;
	
	@FindBy(xpath="//ul[@aria-labelledby='p_89-title']")
	WebElement brandsTable;
	
	@FindBy(xpath="//span[contains(text(),'Magformers Vehicle Transform')]")
	WebElement selectOption;
	
	@FindBy(xpath="//span[text()='Magformers']/preceding-sibling::div")
	WebElement SelectingMagformers;
	
	
	public SearchPage(WebDriver driver) {
	PageFactory.initElements(driver, this); 
	}
	
	public boolean validateSelectingBrand() {
		 SelectingMagformers.click();
		 return SelectingMagformers.isSelected();
	}
	
	public ProductPage validateSelectOption() {
		selectOption.click();
		return new ProductPage(driver);
	}

}
