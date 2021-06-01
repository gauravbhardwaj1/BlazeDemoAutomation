package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import allUtilities.Utilities;

public class Base {
	
	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException
	{
		String  filePath = "src/main/java/resources/data.properties" ;
		String attribut = "browser" ;
	
		
		String browserName = Utilities.findPropAttrVal(filePath, attribut) ;
		
		String os = Utilities.findPropAttrVal(filePath, "os") ;
		
		System.out.println("Current browser - " + browserName);
		
		// Setting browser for execution of test cases
		if(browserName.equals("chrome"))
		{
			if(os.equalsIgnoreCase("windows"))
			{
				System.setProperty("webdriver.chrome.driver", "src/main/java/blazedemo/drivers/windows/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else {
			System.setProperty("webdriver.chrome.driver", "src/main/java/blazedemo/drivers/chromedriver");
			driver = new ChromeDriver();
			}
		}
		
		if(browserName.equals("firefox"))
		{
			if(os.equalsIgnoreCase("windows"))
			{
				System.setProperty("webdriver.chrome.driver", "src/main/java/blazedemo/drivers/windows/geckodriver.exe");
				driver = new FirefoxDriver();
				
			}else {
			System.setProperty("webdriver.chrome.driver", "src/main/java/blazedemo/drivers/geckodriver");
			driver = new FirefoxDriver();
			}
		}
		
		// Setting timeouts for all test cases
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
}
