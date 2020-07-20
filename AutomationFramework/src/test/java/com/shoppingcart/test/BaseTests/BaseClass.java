package com.shoppingcart.test.BaseTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {

	protected static WebDriver driver;
	static Logger log = LogManager.getLogger(BaseClass.class);
	
	@BeforeMethod
	public static void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Chrome/chromedriver.exe");
		log.info("Chrome browser properties have been set");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		log.info("Window have been maximized");
	}
	
	
	@AfterMethod
	public static void tearDown()
	{
		driver.close();
		log.info("Driver is closed");
	}
	
	
	
}
