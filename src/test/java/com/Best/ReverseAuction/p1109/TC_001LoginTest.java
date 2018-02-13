package com.Best.ReverseAuction.p1109;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.QA.R_Auction.ObjectRepo.HomePage;
import com.QA.R_Auction.ObjectRepo.LoginPage;
import com.QA.R_Auction.baseClass.Driver_Class;

public class TC_001LoginTest extends Driver_Class {

	public static final Logger log = Logger.getLogger(TC_001LoginTest.class.getName());
	public TC_001LoginTest()
	{
		super();
	}
	 LoginPage loginPage;
	 HomePage homePage;

	@BeforeTest
	public void setUp() 
	{
		launcher();
		homePage =new HomePage(driver);
		loginPage= new LoginPage(driver); 	
		//click on login from home.

	}


	@Test
	public void verify_InvalidLoginTest() 
	{
		log.info("<***********>Starting verify_InvalidLoginTest <***********>");
		homePage.login_btn();
		Assert.assertEquals(loginPage.loginPageLabel(), "User Login");		
		//loginPage.invalidLoginTest("alokr@gmail.com", "1234567");
		Assert.assertEquals(loginPage.invalidLogin_ErrorMesssage(), "Incorrect email address or password"," Error Message doesnot matched ");
		log.info("<***********>Finish verify_InvalidLoginTest <***********>");
	}
	

	@AfterClass
	public void tearDown() throws Exception 
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
