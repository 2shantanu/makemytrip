package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gspann.makemytrip.HolidaysInternational;

import common.BrowserFactory;

@Test
public class Test2 
{
	public static void main() throws InterruptedException
    {
		//WebDriver driver = new FirefoxDriver();
        WebDriver driver = BrowserFactory.openBrowser("firefox", "https://makemytrip.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        //driver.get("https://makemytrip.com");
        
        //Common openPage = new Common(driver, "https://makemytrip.com");
        
        String windowHandle1 = driver.getWindowHandle();
        
        driver.findElement(By.className("arrow_downall")).click();
        driver.findElement(By.xpath("//*[contains(text(),'International Holidays')]")).click();
        
		//switch to window
        ArrayList<String> window1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(window1.get(1));
		
        //driver.findElement(By.xpath("//input[@class='typeahead-dep-city input-md form-control field-transparent tt-input']")).click();
		//driver.findElement(By.xpath("//input[@class='typeahead-dep-city input-md form-control field-transparent tt-input']")).sendKeys("Hyderabad");
		
		//Create object of DeveloperPortalPage
		HolidaysInternational holidayInt= new HolidaysInternational(driver);
		holidayInt.selectCity("Hyderabad");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='typeahead-dep-city input-md form-control field-transparent tt-input']")).sendKeys(Keys.ENTER);
		driver.findElement(By.partialLinkText("Search Holidays")).click();
		
		//switch to window
		ArrayList<String> window2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(window2.get(1));
		driver.findElement(By.partialLinkText("Explore")).click();
		Thread.sleep(6000);
		//List<WebElement> elements = driver.findElement(By.partialLinkText("View Details"));
		//elements = elements.get(1).click();
		
		List<WebElement> elements = driver.findElements(By.partialLinkText("View Details"));
		elements.get(1).click();
		Thread.sleep(6000);
		
		//switch to window
		//ArrayList<String> window3 = new ArrayList<String> (driver.getWindowHandles());
		//driver.switchTo().window(window3.get(1));
		//driver.findElement(By.partialLinkText("Book Online")).click();
		//driver.switchTo().window("Phuket Fiesta Land Only - Book Phuket Fiesta Land Only Vacation Package at Budget Prices : MakeMyTrip India");
		//driver.getTitle();
		//Switch to new window and verify the title
		//String windowTitle = driver.getTitle();
		for(String window3 : driver.getWindowHandles()){
		    driver.switchTo().window(window3);
		}
		System.out.println(driver.getTitle());	
		Boolean isPresent = driver.findElements(By.partialLinkText("Book Online")).size() > 0;
		Assert.assertTrue(isPresent, "Book Online button not Present");
		
		if(driver.findElements(By.partialLinkText("Book Online")).size() != 0){
			System.out.println("Element is Present");
			}else{
			System.out.println("Element is Absent");
			}
		
		driver.close();
		driver.switchTo().window(window2.get(1));
		driver.close();
		driver.switchTo().window(windowHandle1);
		driver.findElement(By.xpath("//*[contains(text(),'Domestic Holidays')]")).click();
		
		ArrayList<String> window4 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(window4.get(1));
		String url1 = driver.getCurrentUrl();
		String content = "holidays-india";
		boolean chk = content.toUpperCase().contains(url1.toUpperCase());
		System.out.println(url1);
		Assert.assertTrue(chk);
		
    }
    
}
