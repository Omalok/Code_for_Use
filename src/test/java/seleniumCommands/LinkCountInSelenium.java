package seleniumCommands;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinkCountInSelenium {

	static WebDriver driver; 
	@BeforeTest
	public static void loginToAdmin_Account() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\MySeleniumProject\\p1109\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://182.72.79.154/p1118");
		
	}
	
	@Test
	public static void linkCount() 
	{
		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement avlLinks : links) 
		{
			
		}
		
	}
	
	
	@AfterTest
	public void shutDown()
	{
		//driver.quit();
		
	}
}