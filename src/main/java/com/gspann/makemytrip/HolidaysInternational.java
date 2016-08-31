package com.gspann.makemytrip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HolidaysInternational {
	private WebDriver driver;
	
	@FindBy(how=How.XPATH, using="//input[@class='typeahead-dep-city input-md form-control field-transparent tt-input']")
	private WebElement cityName;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Search Holidays")
	private WebElement searchHolidaysButton;
	
	//Constructor
	  public HolidaysInternational(WebDriver driver){
	       this.driver=driver;

	       //Initialize Elements
	       PageFactory.initElements(driver, this);
	   }
	
	public void selectCity(String enterCity){
		cityName.click();
		cityName.sendKeys(enterCity);
	}

}
