package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;


public class SuccessPage {
	
	public WebDriver driver;

	
	//By headings= By.xpath("//h1[contains(text(),'Thank you for your purchase today!')]") ;
	By headings = By.xpath("//*[contains(text(), 'Thank you')]") ;
	
	By confirmId = By.xpath("//tbody/tr[1]/td[2]");
	
	By status = By.xpath("//tbody/tr[2]/td[2]");
	
	By amount = By.xpath("//tbody/tr[3]/td[2]");
	
	By cardNumber = By.xpath("//tbody/tr[4]/td[2]");
	
	By expiration = By.xpath("//tbody/tr[5]/td[2]");
	
	By authCode = By.xpath("//tbody/tr[6]/td[2]");
	
	By date_val = By.xpath("//tbody/tr[7]/td[2]");
	
	
	
	public SuccessPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getHeading() 
	{
		
		return driver.findElement(headings);
	}
	
	public WebElement findConfirmId()
	{
		return driver.findElement(confirmId);
	}
	
	
	public WebElement findStatus()
	{
		return driver.findElement(status);
	}
	
	public WebElement findCardNumber()
	{
		return driver.findElement(cardNumber);
	}
	
	public WebElement findExpiration()
	{
		return driver.findElement(expiration);
	}
	
	public WebElement findAuthCode()
	{
		return driver.findElement(authCode);
	}
	
	public WebElement findDate_val()
	{
		return driver.findElement(date_val);
	}
	
	

}
