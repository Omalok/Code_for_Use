package com.QA.R_Auction.ObjectRepo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
 WebDriver driver;
		
	// Page Objects
	@FindBy(xpath="html/body/section/div/div/div[1]/h1")
	WebElement loginPageLabel;
	
	@FindBy(name="email")
	WebElement email;
	
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="remember")
	WebElement remember;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login_Btn;
	
	@FindBy(xpath=".//*[@id='toast-container']/div/div[2]")
	WebElement invalidLogin_ErrorMesssage;
	
	@FindBy(xpath="//a[@href='http://182.72.79.154/p1109/login']")
	WebElement loginBtnAtHomePage;
	
	
	// Page Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public void invalidLoginTest(String uEmail,String Upwd) throws Exception 
	{
		login_Btn.click();
		log.info("click on Login Btton !!"+" and object/locator is: "+login_Btn.toString());
		Thread.sleep(3000);
		email.sendKeys(uEmail);
		log.info("entered user email: "+uEmail+" and object/locator is: "+email.toString());
		password.sendKeys(Upwd);
		log.info("entered user password: "+Upwd+" and object/locator is: "+password.toString());
		remember.click();
		log.info("click on remember me !!"+" and object/locator is: "+remember.toString());
		login_Btn.click();
		log.info("click on Login Btton !!"+" and object/locator is: "+login_Btn.toString());
	}
	
	
	public String loginPageLabel() 
	{
		return loginPageLabel.getText();
	}
	
	
	public String invalidLogin_ErrorMesssage() 
	{
		return invalidLogin_ErrorMesssage.getText();
	} 
	
	
	
}
