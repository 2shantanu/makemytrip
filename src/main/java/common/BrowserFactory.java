package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	static WebDriver driver;
	
	public static WebDriver openBrowser(String browserName, String url){
		
		if(browserName.toLowerCase().equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.toLowerCase().equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.toLowerCase().equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
	}

}
