package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import resources.Base;


public class LandingPage {
	
	public WebDriver driver;

	
	By headings= By.xpath("//*[contains(text(), 'Welcome to')]") ;
	
	
	By fromPort = By.name("fromPort") ;
	
	By toPort = By.name("toPort") ;
	
	By findFlight = By.xpath("/html/body/div[3]/form/div/input") ;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getHeading() 
	{
		
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(headings));
		return driver.findElement(headings);
	}
	
	public WebElement getFromPort()
	{
		WebElement fPort1 = driver.findElement(fromPort);
		
		return fPort1 ;
	}
	
	public WebElement getToPort()
	{
		WebElement tPort1 = driver.findElement(toPort);
		
		return tPort1;
	}
	
	public FlightOptions findFlightButton()
	{
		driver.findElement(findFlight).click()  ;
		
		return new FlightOptions(driver);
	}

}
