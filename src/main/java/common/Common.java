package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class Common {
	private WebDriver driver;
	
	   //Constructor
	   public Common(WebDriver driver, String pageUrl){
	       this.driver=driver;
	       driver.manage().window().maximize();
	       driver.get(pageUrl);
	       //Initialize Elements
	       PageFactory.initElements(driver, this);
	   }	
	   
}
