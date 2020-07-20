package com.shoppingcart.test.SearchElementTest;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Test;

import com.shoppingcart.pageobjects.homepage.SearchPage;
import com.shoppingcart.pageobjects.login.LoginPage;
import com.shoppingcart.test.BaseTests.BaseClass;


public class CheckOutTest extends BaseClass {
	
    static Logger log = LogManager.getLogger(CheckOutTest.class);
	
   //Please check my loginTest class, there have used data provider with Excel Reader.. Here passing arguments thru methods
	@Test
	public void checkOut()
	{
		driver.get("http://mysite.com/");
		log.info("User successfully navigated to the desired website");
		LoginPage loginOb= new  LoginPage(driver);
		loginOb.sendUsername("user1");
		log.info("User name have been provided successfully");
		loginOb.sendPassword("Password");
		log.info("Password have been provided successfully");
		loginOb.storeCaptcha();
		log.info("Generated captcha have been entered successfully");
		loginOb.SignIN();	
		log.info("Sign button clicked");
		SearchPage sp = new SearchPage(driver);
		sp.searchItem();
		log.info("Item Have Been searched and selected");
		sp.addElement();
		log.info("Add a particular Item");
		sp.checkout();
		log.info("added item have been checked out");	
	}
	

}
