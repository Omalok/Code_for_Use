package com.QA.R_Auction.ObjectRepo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

	public static final Logger log = Logger.getLogger(HomePage.class.getName());
 WebDriver driver;
	
	// Page Objects
	@FindBy(xpath="//a[@href='http://182.72.79.154/p1109/login']")
	WebElement login_Btn;

	
	
	// Page Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions 
	public void login_btn() 
	{
		login_Btn.click();
		log.info("Clicked on LOGIN button.");
	}
	
	
}
