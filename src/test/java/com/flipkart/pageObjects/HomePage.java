package com.flipkart.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='q']")
	@CacheLookup
	public 	WebElement searchMobiles;
	
	
	
	@FindBy(xpath="//button[@class='L0Z3Pu']")
	@CacheLookup
	public 	WebElement searchButton;

	@FindBy(xpath="//div[contains(text(),'2 GB')]")
	@CacheLookup
	public WebElement select2GB;
	
	@FindBy(xpath="//input[@placeholder ='Search Brand']")
	@CacheLookup
	public WebElement searchBrand;
	
	
	@FindBy(xpath="//div[contains(text(),'Gionee')]")
	@CacheLookup
	public WebElement selectBrand;
	
	
	
	
	
	@FindAll({@FindBy(xpath="//div[@class='_2kHMtA']//div[@class='_4rR01T']")})
	@CacheLookup
	public List<WebElement> resultsNameList;
	

	@FindAll({@FindBy(xpath="//div[@class='fMghEO']//li[@class='rgWa7D' and contains(text(),'RAM')]")})
	@CacheLookup
	public List<WebElement> resultsRAMList;

	


	public void enterSearchText(String searchText) throws InterruptedException {
		searchMobiles.click();
		Thread.sleep(2000);
		searchMobiles.sendKeys(searchText);
		
		
	}
	
	public void clickSearch() {
		searchButton.click();
	}
	
	
	public void clickRAM() {
		select2GB.click();
	}

	public void enterBrand(String brand) {
		searchBrand.sendKeys(brand);
				
	}
	
	public void selectBrand() {
		selectBrand.click();
	}
	
	public boolean validateNameResultList(String mobileBrand) {
		
		boolean containText = false;
		int resultSize = resultsNameList.size();
		for(int i=0;i<resultSize;i++) {
			String mobileName = resultsNameList.get(i).getText();
			containText =mobileName.contains(mobileBrand);
			if(containText==false) {
				break;
			}
			
		}
		
		return containText;
		
		
	}
	
	public boolean validateRAMResultList(String mobileRAM) {
		
		boolean containsRAM = false;
		int resultRAMSize = resultsRAMList.size();
		for(int i=0;i<resultRAMSize;i++) {
			String mobileName = resultsRAMList.get(i).getText();
			containsRAM =mobileName.contains(mobileRAM);
			if(containsRAM==false) {
				break;
			}
			
		}
		return containsRAM;
		
		
		
	}

	public void waitforElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}


	



}