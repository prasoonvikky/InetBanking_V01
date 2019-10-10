package com.inetbanking.Testcases;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.google.j2objc.annotations.Property;
import freemarker.log.Logger;
import com.inetbanking.Utilities.*;


public class BaseClass
{
	ReadConfig ReadConfig = new ReadConfig();
	public String BaseUrl = ReadConfig.getApplicationUrl() ;
	public String username = ReadConfig.getusername();
	public String password = ReadConfig.getpassword();
	public static WebDriver  driver;
	public static Logger logger;	// making logger as a global bcz each nd every test case we have to use.
	
	@Parameters("browser")	// It will take parameter from "TestNG.xml" file- User created 
	@BeforeClass
	public void Setup(String br) 	// Browser var is "br"
	{
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
		
		logger = logger.getLogger("ebanking");	// ebanking is the domain & Logger is to log the add log to 
		PropertyConfigurator.configure("log4j.properties");										// test caase.
		
		if (br.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ReadConfig.getfirefoxpath());
			driver = new FirefoxDriver();
		} 
		else if (br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", ReadConfig.getiepath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(BaseUrl);
	}
		
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void capturescreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/ScreenShots/"+ tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot taken");
	}
	
	// To generate unique email-id always, we need to create user defined function
	
			public String randomstring()
			{
				// RandomStringUtils : is a class which contains "randomAlphabetic" which will generate random
				// alphanumeric string based on size provided by the USER. (eg. 9)
				
				String generatedString = RandomStringUtils.randomAlphabetic(9);
				return generatedString;
			}
			
			public String randomnum()
			{
				String generatedString2 = RandomStringUtils.randomNumeric(4);
				return generatedString2;
				
			}
}
