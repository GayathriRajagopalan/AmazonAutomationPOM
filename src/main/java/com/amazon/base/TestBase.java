package com.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.utility.TestUtility;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public void initialization() throws IOException {
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\gay3v\\eclipse-workspaceNew1\\AmazonAutomation\\src\\main\\java\\com\\amazon\\config\\config.properties");
		prop.load(fis);
		String BrowserName=prop.getProperty("browser");
		if(BrowserName.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\auto\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(BrowserName.contentEquals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\auto\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtility.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	

}
