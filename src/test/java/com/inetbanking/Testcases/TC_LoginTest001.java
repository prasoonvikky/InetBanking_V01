package com.inetbanking.Testcases;
import com.inetbanking.PageObjects.*;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_LoginTest001 extends BaseClass
{
	@Test
	public void LoginTest() throws IOException
	{
		
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.SetUserName(username);
		logger.info("Entered UserName");
		
		lp.SetPassword(password);
		logger.info("Entered Password");
		lp.ClickSubmit();
		
		if (driver.getTitle().equals(" Guru99 Bank Manager HomePage "))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			capturescreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
}
 