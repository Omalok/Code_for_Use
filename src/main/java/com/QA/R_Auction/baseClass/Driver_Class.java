package com.QA.R_Auction.baseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver_Class {
	
	public static final Logger log = Logger.getLogger(Driver_Class.class.getName());
	public static Properties prop; 
	public static WebDriver driver;

	public Driver_Class()	
	{
		try {
			// ConfigProperty file use to send keys values..Ex dataType & webElements.
			prop = new Properties(); 
			FileInputStream file = new FileInputStream("D:\\MySeleniumProject\\p1109\\src\\main\\java\\com\\QA\\R_Auction\\configProp\\config.Properties");
			prop.load(file);

		} catch (Exception e) {

			e.printStackTrace();
		} 
	}

	public static void launcher()  
	{
		selectBrowser("chrome");		
		manageDriver();
		enterUrl(prop.getProperty("url"));
		String log4jConfigPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfigPath);
		
	}
	
	public static void selectBrowser(String browser) 
	{
		
		/*switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			return	driver = new ChromeDriver();
		}*/
		if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\MySeleniumProject\\p1109\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Creating Object Of : "+browser);
		}
		else if (browser.equalsIgnoreCase("fireFox"))
		{
			//System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", "D:\\MySeleniumProject\\p1109\\drivers\\geckodriver.exe");			
			driver = new FirefoxDriver();
		}
		else 
		{
			System.out.println("No such browser available : "+browser);
		}
	}

	public static void manageDriver() {

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public static void enterUrl(String url) {

		driver.get(url);
		log.info("Launching Project Url !!");
	}
}
