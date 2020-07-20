package com.shoppingcart.pageobjects.login;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

	WebDriver driver;

	// Initiate the driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}

	// Using FindBy-ID locator for locating username field
	@FindBy(how = How.ID, using = "username")
	WebElement userName;

	//Using FindBy-ID locator for locating password field
	@FindBy(how = How.ID, using = "password")
	WebElement password;

	//Using FindBy-ID locator for locating enterCaptcha field
	@FindBy(how=How.ID, using ="storeCaptcha")
	WebElement enterCaptcha;
	
	//Using FindBy-ID locator for locating SignIn Button
	@FindBy(how = How.ID, using = "signInButton")
	WebElement signIn;

	
	//This will be called from the login testClass
	public void sendUsername(String UserName) {
		userName.click();
		userName.clear();
		userName.sendKeys(UserName);
	}

	//This will be called from the login testClass
	public void sendPassword(String Password) {
		password.click();
		password.clear();
		password.sendKeys(Password);

	}
	
	//This will be called from the login testClass
	public void storeCaptcha()
	{
		//prompting user to enter captcha
		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
		//Type the entered captcha to the text box
		enterCaptcha.clear();
		enterCaptcha.click();
		enterCaptcha.sendKeys(captchaVal);
	}

	//This will be called from the login testClass
	public void SignIN() {
		signIn.click();
	}

}
