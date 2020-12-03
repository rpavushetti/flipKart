package com.flipkart.testCases;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pageObjects.HomePage;
import com.flipkart.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass
{
	
	
	@Test (priority=0)
	public void loginTest() throws IOException, InterruptedException 
	{
		
		LoginPage lp=new LoginPage(driver);
			
		logger.info("URL is opened");
		
		
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
		
		Thread.sleep(30);
		
		
		
		if(driver.getTitle().equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}
	

	
	
}
