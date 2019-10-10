package com.inetbanking.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.Reporter;


public class ReadConfig 
{
	Properties pro;
	public  ReadConfig()
	{
		File src = new File("./Configuration/config.properties"); // Path of config.properties
		try
		{
			FileInputStream fis = new FileInputStream(src);	// To read the file
			pro = new Properties();	// Creating object of properties class
			pro.load(fis);	// load is a method which will load complete cong.properties file 
			
		} 
		catch (Exception e) 
		{
			Reporter.log("Exception is :" + e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String Url = pro.getProperty("BaseUrl");
		return Url;
	}
	
	public String getusername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getpassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getfirefoxpath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getiepath()
	{
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
}