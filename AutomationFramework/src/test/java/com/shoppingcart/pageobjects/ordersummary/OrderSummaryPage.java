package com.shoppingcart.pageobjects.ordersummary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class OrderSummaryPage {

	WebDriver driver;

	// Initiate the driver
	public OrderSummaryPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);		
	}
	
	// Using FindBy-ID locator for locating name field
		@FindBy(how = How.ID, using = "name")
		WebElement name;
		
	// Using FindBy-ID locator for locating mobile number field
		@FindBy(how = How.ID, using = "number")
		WebElement mobileNumber;	
	
		
	// Using FindBy-ID locator for locating mobile number field
		@FindBy(how = How.ID, using = "address")
		WebElement address;	
			
	// Using FindBy-ID locator for locating submit button
		@FindBy(how = How.ID, using = "SUBMIT")
		WebElement submit;	
				
	
	// Using FindBy-ID locator for locating OTP button
		@FindBy(how = How.ID, using = "OTP")
		WebElement otp;	
		
	// Using FindBy-ID locator for locating OTP button
		@FindBy(how = How.ID, using = "PAY")
		WebElement pay;	
  
}
