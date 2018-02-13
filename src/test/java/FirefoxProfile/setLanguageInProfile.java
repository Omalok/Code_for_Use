package FirefoxProfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class setLanguageInProfile {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\MySeleniumProject\\p1109\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("–lang= en");
		 driver = new ChromeDriver(options);
		 
		 driver.get("http://4moov.com/");
		
	}
	
}
	