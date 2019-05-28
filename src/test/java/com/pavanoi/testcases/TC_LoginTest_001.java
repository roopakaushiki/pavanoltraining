package com.pavanoi.testcases;

import org.testng.annotations.Test;

import com.pavanoi.pageobjects.BaseClass;
import com.pavanoi.pageobjects.LoginPage;

import freemarker.template.utility.CaptureOutput;
import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() {
		driver.get(baseURL);
		logger.info("URL opened");
		
		LoginPage login = new LoginPage(driver);
		login.setUserName(username);
		logger.info("Enter Username");
		
		login.setPassword(password);
		logger.info("Enter Password");
		login.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else 
		{
			//captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
	
	

}
