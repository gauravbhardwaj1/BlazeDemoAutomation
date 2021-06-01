package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;


public class FlightOptions {
	
	public WebDriver driver;

	
	By headings= By.xpath("//*[contains(text(), 'Flights from')]") ;
	
	
	By chooseFlightButton = By.xpath("//tbody/tr[1]/td[1]/input");
	
	By flightPrice = By.xpath("//tbody/tr[1]/td[6]/input");
	
	
	
	public FlightOptions(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getHeading() 
	{
		
		return driver.findElement(headings);
	}
	
	public WebElement getPrice()
	{
		return driver.findElement(flightPrice);
	}
	
	
	public WebElement finalFlightButton()
	{
		return driver.findElement(chooseFlightButton);
	}

}
