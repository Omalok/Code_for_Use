package BuckUpTestScripts;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import FirefoxProfile.setLanguageInProfile;

public class JavaScriptExecuter {

	static WebDriver driver;
	
	@BeforeTest
	public static void loginToAdmin_Account() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "D:\\MySeleniumProject\\p1109\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://182.72.79.154/p1118/admin");
		
		
		// Code to close the associated unwanted windows !!
	
		String parent = driver.getWindowHandle();
		Set<String> handle = driver.getWindowHandles();
		for(String window : handle) 
		{
			if(!window.equals(parent)) 
			{
				driver.switchTo().window(window);
				driver.close();
			}
		}
		
		driver.switchTo().window(parent);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String sText =  js.executeScript("return document.domain;").toString();
		System.out.println(sText);
		
	
		//document.evaluate('XPATH HERE', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
		//js.document.evaluate('//input[@name= "email"]', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.innerHTML;		
		//js.executeScript("alert('hello world');");	
		//js.executeScript("return window.innerWidth;");
		//js.executeScript("document.getElementByXpath('//input[@name= 'email'').value='someValue';");
		driver.findElement(By.xpath("//input[@name= 'email']")).sendKeys("hancy@panaceatek.com");
		
		WebElement pwd = driver.findElement(By.xpath("//input[contains(@name,'password')]"));	
		js.executeScript("arguments[0].style.border='3px solid red'", pwd);
		pwd.sendKeys("Pass@12345");	
		js.executeScript("window.alert('hello sir wait a min ')");
		driver.findElement(By.xpath("//input[contains(@id,'remember')]")).click();	
		driver.findElement(By.xpath("//button")).click();
		Thread.sleep(2000);
		// When to directly click on sub menu button.
		WebElement city = driver.findElement(By.xpath("//a[@href='http://182.72.79.154/p1118/admin/cities/list']"));
		js.executeScript("arguments[0].click();", city);
		
	
	}
	
 
	
	@Test(enabled=false)
	public static void javaScriptExecuter() 
	{

		//js.executeScript("document.getElementById('some id').value='someValue';");

	}
	
	@Test(enabled=false)
	public static void Test1() 
	{
		int a=0;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		driver.findElement(By.xpath("//a[@href='http://182.72.79.154/p1118/admin/faqs']")).click();
		//driver.findElement(By.className("checkboxes")).click();
		
		List<WebElement> elements = driver.findElements(By.className("cust-chqs"));
		WebElement firstDiv = elements.get(0); 
		
		List<WebElement> firstCheckBox = firstDiv.findElements(By.className("checkboxes"));
		
		for(WebElement ele : firstCheckBox) 
		{
			if(a<3)
			{
				executor.executeScript("arguments[0].click();", ele);
			
			}else {
				
			    throw new IllegalStateException("This driver does not support JavaScript!");
			}
			
			a++;
		}
		
		
		
		
		
		/*WebElement element = driver.findElement(By.className("checkboxes"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);*/
	}
	
	
	public static void selectDropDown(WebElement element , int indexNum) 
	{
		Select dropdown = new Select(element);
		dropdown.selectByIndex(indexNum);
	}
	
	
	@AfterTest
	public static void tearDown() 
	{
		System.out.println("Don't close Yet !! ");
		/*WebElement profile = driver.findElement(By.xpath("//a[contains(@class, 'dropdown-toggle')]"));
		moveToElement(driver, profile);
		driver.findElement(By.xpath("//a[@href='http://182.72.79.154/p1118/admin/logout']")).click();*/

	}
	public static void moveToElement(WebDriver driver , WebElement element) 
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
}
