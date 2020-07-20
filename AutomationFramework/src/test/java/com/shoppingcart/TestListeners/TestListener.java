package com.shoppingcart.TestListeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;
import com.shoppingcart.test.BaseTests.BaseClass;

public class TestListener extends BaseClass implements ITestListener {

	//Absolute path for ScreenShots folder location
    
	
	String filePath = "./src/test/resources/ScreenShots";   
	
	//In case of any test case fail,respective screenshot will be taken 
	public void onTestFailure(ITestResult result) {
		String methodName=result.getName().toString();
       takeScreenShot(methodName, driver);
	}
	
	//A method to capture screeshots for failed test cases
	private void takeScreenShot(String methodName, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("ScreenShot function called");
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 System.out.println("Screenshot taken");
         //The below method will save the screen shot in d drive with test method name 
            try {
				Files.copy(scrFile, new File(filePath+methodName+".png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
	}

	
	
	
}
