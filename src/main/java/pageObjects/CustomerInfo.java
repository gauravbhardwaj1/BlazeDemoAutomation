package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;


public class CustomerInfo {
	
	public WebDriver driver;

	
	//By headings= By.xpath("//h2[contains(text(),'Your flight from TLV to SFO has been reserved.')]") ;
	By headings = By.xpath("//*[contains(text(), 'Your flight from')]") ;
	
	By price = By.xpath("//p[contains(text(),'Price: 400')]") ;
	
	By arbitraryFees = By.xpath("//p[contains(text(),'Arbitrary Fees and Taxes: 514.76')]") ;
	
	By totalCost = By.xpath("//em[contains(text(),'914.76')]") ;
	
	By name = By.xpath("//input[@id='inputName']") ;
	
	By address = By.xpath("//input[@id='address']") ;
	
	By city = By.xpath("//input[@id='city']") ;
	
	By state = By.xpath("//input[@id='state']") ;
	
	By zipCode = By.xpath("//input[@id='zipCode']") ;
	
	By selectCardType = By.xpath("//select[@id='cardType']") ;
	
	By creditCardNumber = By.xpath("//input[@id='creditCardNumber']") ;
	
	By month = By.xpath("//input[@id='creditCardMonth']") ;
	
	By yr = By.xpath("//input[@id='creditCardYear']");
	
	By nameCard = By.xpath("//input[@id='nameOnCard']") ;
	
	By purchaseButton = By.xpath("//form/div[11]/div/input") ;
	
	public CustomerInfo(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getHeading() 
	{
		
		return driver.findElement(headings);
	}
	
	public WebElement getPrice()
	{
		return driver.findElement(price);
	}
	
	
	public WebElement arbFees()
	{
		return driver.findElement(arbitraryFees);
	}

	
	public WebElement totalPrice()
	{
		return driver.findElement(totalCost);
	}
	
	public WebElement custName()
	{
		return driver.findElement(name);
	}
	public WebElement custAddress()
	{
		return driver.findElement(address);
	}
	
	public WebElement custCity()
	{
		return driver.findElement(city);
	}
	
	public WebElement custState()
	{
		return driver.findElement(state);
	}
	
	public WebElement custZipCode()
	{
		return driver.findElement(zipCode);
	}
	
	public WebElement selectType()
	{
		return driver.findElement(selectCardType);
	}
	
	public WebElement ccNumber()
	{
		return driver.findElement(creditCardNumber);
	}
	
	public WebElement cMonth()
	{
		return driver.findElement(month);
	}
	
	public WebElement cYear()
	{
		return driver.findElement(yr);
	}
	
	public WebElement nameOnCard()
	{
		return driver.findElement(nameCard);
	}
	
	
	public WebElement purchase()
	{
		return driver.findElement(purchaseButton);
	}
	
	
}
