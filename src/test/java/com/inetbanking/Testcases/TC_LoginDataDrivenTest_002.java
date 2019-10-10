package com.inetbanking.Testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;
import com.inetbanking.Utilities.XlUtiles;

import junit.framework.Assert;

public class TC_LoginDataDrivenTest_002 extends BaseClass
{
	@Test(dataProvider = "LoginData")
	public void LoginDDT(String user, String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.SetUserName(user);
		logger.info("Username provided");
		lp.SetPassword(pwd);
		logger.info("Password provided");
		lp.ClickSubmit();
		Thread.sleep(3000);
		
		if (isAlertPresent()== true)
		{
			driver.switchTo().alert().accept(); // To close the alert
			driver.switchTo().defaultContent(); 	// To switch to main page
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();		// To close Logout alert
			driver.switchTo().defaultContent();		// To switch to main page
		}
	}
	
	public boolean isAlertPresent()	// User defined method to verify if alert is present or not
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e)
		{
			return false;
		}
		
	}
	@DataProvider(name="LoginData")
	String [][] getdata() throws IOException
	{
		String path ="./src/test/java/com/inetbanking/TestDatas/Automation.xlsx";
		int rownum = XlUtiles.getRowCount(path, "Sheet1");
		int colcount = XlUtiles.getcellcount(path, "Sheet1",1);
		
		// To get the value from the excel sheet and store in the Array
		String Logindata [][] = new String [rownum][colcount];
		
		for (int i = 1; i <= rownum; i++)		// To copy the value of row and column(Excel) to i & j of Array
		{
			for (int j = 0; j <colcount; j++)
			{
				Logindata[i-1][j] = XlUtiles.getcelldata(path, "Sheet1", i,j);	// 1 0
			}
		}
		return Logindata;
	}
}