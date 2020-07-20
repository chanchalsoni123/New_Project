package com.shoppingcart.test.LoginTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.shoppingcart.pageobjects.login.LoginPage;
import com.shoppingcart.test.BaseTests.BaseClass;
import com.shoppingcart.utils.ExcelRead;

public class LoginTest extends BaseClass {
	
	static Logger log = LogManager.getLogger(LoginTest.class);
	
	@Test (dataProvider ="Login")
	public void login(Map<String, String> formInput)
	
	{
		driver.get("http://mysite.com/");
		log.info("User successfully navigated to the desired website");
		LoginPage loginOb= new  LoginPage(driver);
		loginOb.sendUsername(formInput.get("UserName"));
		log.info("User name have been provided successfully");
		loginOb.sendPassword(formInput.get("Password"));
		log.info("Password have been provided successfully");
		loginOb.storeCaptcha();
		log.info("Generated captcha have been entered successfully");
		loginOb.SignIN();		
		log.info("Signin Button clicked");
		
		//To assert whether user has successfully navigated to the HomePage/Search page
		//this is the sample code 
		String expected="search";
		String actual = driver.findElement(By.id("search")).getText();
		try {
		Assert.assertEquals(actual, expected);
		log.info("test case is passed");
		}
		catch(ElementNotVisibleException e) {
			
			log.error("test case failed");
		}
		
	}

	//Reading username and password thru excel sheet
	@DataProvider(name="Login")
	public static Object[][] testData() {

	    File file = new File("./src/main/resources/project.properties");
	    FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		//load properties file
				try {
					prop.load(fileInput);
				} catch (IOException e) {
					e.printStackTrace();
				}

		ExcelRead excel = new ExcelRead(prop.getProperty("ExcelPathForTestData"));
		Object[][] testArray = excel.readData("LoginData");
		return testArray;
	
	}
	
}
