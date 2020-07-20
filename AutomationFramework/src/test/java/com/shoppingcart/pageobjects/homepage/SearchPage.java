package com.shoppingcart.pageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	WebDriver driver;

	// Initiate the driver
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}

	// Using FindBy-ID locator for locating searchBox
	@FindBy(how = How.ID, using = "search")
	WebElement searchBox;

	//Using FindBy-xpath locator for locating and adding an element
	@FindBy(how = How.XPATH, using = "*[@text='C']/div[1]/span/")
	WebElement elementAdd;
	
	//Using FindBy-ID locator for locating the CheckOut button
	@FindBy(how = How.ID, using = "checkout")
	WebElement checkOut;
   
	//search an item
	public void searchItem() {
		searchBox.click();
		searchBox.clear();
		searchBox.sendKeys("Mobile");
		searchBox.sendKeys(Keys.ENTER);
		//defining explicit wait 
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Mobile Holder")));
		driver.findElement(By.linkText("Mobile Holder")).click();
		
	}
	
	//Click on element to add
	public void addElement()
	{
		elementAdd.click();
	}
	
	//click on checkout button
	public void checkout()
	{
		checkOut.click();
	}
	

}
