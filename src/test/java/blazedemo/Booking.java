package blazedemo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import allUtilities.Utilities;
import pageObjects.CustomerInfo;
import pageObjects.FlightOptions;
import pageObjects.LandingPage;
import pageObjects.SuccessPage;
import resources.Base;

public class Booking extends Base{
	
	WebDriver driver ;
	
	String  filePath = "src/main/java/resources/data.properties" ;
	String findSite = "site" ;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(Utilities.findPropAttrVal(filePath, findSite));
	}
	
	
	@Test
	public void verifyBasePageNavigation() throws IOException 
	{
		
		String heading = "firstHeading" ;
		
		
		LandingPage lp = new LandingPage(driver);
		
		String actualHeading = lp.getHeading().getText();
		
		String expectedHeading = Utilities.findPropAttrVal(filePath, heading);
		
		// Assert Heading
		AssertJUnit.assertEquals(actualHeading, expectedHeading);
		
	
	}
	
	@Test (dependsOnMethods={"verifyBasePageNavigation"})
	public void verifyCitySelection() throws IOException
	{
		String fromCity= Utilities.findPropAttrVal(filePath, "city1");
		
		String toCity = Utilities.findPropAttrVal(filePath, "city2") ;
		
		LandingPage lp = new LandingPage(driver);
		// Select From Port
		Select fPort = new Select(lp.getFromPort());
				
		//Select first City
		fPort.selectByValue(fromCity); ;
				
				
		// Select To Port
		Select tPort = new Select(lp.getToPort());
						
		//Select To City
		tPort.selectByValue(toCity); ;
				
		// Click on button and verify heading
		String secondPageHeading = lp.findFlightButton().getHeading().getText();
				
		String expectedSecondHeading = "Flights from " + fromCity + " to "+ toCity + ":" ;
				
		System.out.println(expectedSecondHeading);

				
		AssertJUnit.assertEquals(secondPageHeading, expectedSecondHeading);
		
		
		
	}
	
	@Test (dependsOnMethods={"verifyCitySelection"})
	public void verifyFlightSelection() throws IOException 
	{
		FlightOptions fo = new FlightOptions(driver);
		
		fo.finalFlightButton().click();
		
		String expectedHeading = Utilities.findPropAttrVal(filePath, "heading2");
		
		CustomerInfo ci = new CustomerInfo(driver);
		
		String actualHeading = ci.getHeading().getText();
		
		// Assert Heading
		AssertJUnit.assertTrue(actualHeading.contains(expectedHeading));
		
		
	
	}
	
	@Test (dependsOnMethods={"verifyFlightSelection"})
	public void verifyBooking() throws IOException
	{
		CustomerInfo ci = new CustomerInfo(driver);
		
		String name = Utilities.findPropAttrVal(filePath, "name") ; 
		
		String address = Utilities.findPropAttrVal(filePath, "address") ;
		
		String city = Utilities.findPropAttrVal(filePath, "city") ;
		
		String state = Utilities.findPropAttrVal(filePath, "state") ;
		
		String zip = Utilities.findPropAttrVal(filePath, "zip") ;
		
		String cardType = Utilities.findPropAttrVal(filePath, "cardType") ;
		
		String CcNumber = Utilities.findPropAttrVal(filePath, "CcNumber") ;
		
		String month = Utilities.findPropAttrVal(filePath, "month") ; 
		
		String yr = Utilities.findPropAttrVal(filePath, "yr") ;
		
		String nameOncard = Utilities.findPropAttrVal(filePath, "nameOncard") ;
		
		String expectedSuccMsg = Utilities.findPropAttrVal(filePath, "finalThanks") ;
		
		String expectedCfId = Utilities.findPropAttrVal(filePath, "cfId") ;
		
		String expectedStatus = Utilities.findPropAttrVal(filePath, "status") ;
		
		
		ci.custName().sendKeys(name);
		ci.custAddress().sendKeys(address);
		ci.custCity().sendKeys(city);
		ci.custState().sendKeys(state);
		ci.custZipCode().sendKeys(zip); 
		
		Select typ = new Select(ci.selectType()) ;
		typ.selectByVisibleText(cardType);  
		ci.ccNumber().sendKeys(CcNumber);
		ci.cMonth().sendKeys(month);
		ci.cYear().sendKeys(yr);
		ci.nameOnCard().sendKeys(nameOncard);
		
		ci.purchase().click();
		
		SuccessPage sp = new SuccessPage(driver);
		
		// Assert Heading
		String actualHeading = sp.getHeading().getText();
		
		AssertJUnit.assertTrue(actualHeading.contains(expectedSuccMsg));
		
		// Assert Confirmation ID
		String actualConfirmId = sp.findConfirmId().getText();
				
		AssertJUnit.assertTrue(actualConfirmId.contains(expectedCfId));
		
		// Assert Status
		String actualStatus = sp.findStatus().getText();
						
		AssertJUnit.assertTrue(actualStatus.contains(expectedStatus));
		
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
