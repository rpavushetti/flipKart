package com.flipkart.testCases;

import org.testng.Assert;


import org.testng.annotations.Test;

import com.flipkart.pageObjects.HomePage;

public class TC_ResultsValidation_002 extends BaseClass {
	
	@Test 
	public void searchResultValidation() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		
		logger.info("User is navigated to HomePage");
		hp.waitforElement(hp.searchMobiles);
		hp.enterSearchText("mobiles");
		hp.clickSearch();
		hp.clickRAM();
		hp.enterBrand("Gionee");
		hp.selectBrand();
		Thread.sleep(3000);
		Assert.assertTrue(hp.validateNameResultList("Gionee"));
		Assert.assertTrue(hp.validateRAMResultList("2 GB"));
	}
	
	

	
	


}
