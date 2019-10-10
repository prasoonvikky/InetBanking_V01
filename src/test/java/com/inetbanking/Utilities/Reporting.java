package com.inetbanking.Utilities;

// Listener Class used to generate Extent Reports

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void ontart(ITestContext TestContext)
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		String repName = "Test-report-" +timestamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName","LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User","Singh");
		
		htmlReporter.config().setDocumentTitle("InetBanking Test Project"); // Title of Report
		htmlReporter.config().setReportName("Functional Test report");	//name of report
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void OnTestSuccess(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());	// Create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void OnTestFailure(ITestResult tr)
	{
		logger = extent.createTest(tr.getName()); // Create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	
	
	String screenshotpath = System.getProperty("user.dir")+"\\ScreenShots\\" +tr.getName()+".png";
	
	File f = new File(screenshotpath);
	
	if(f.exists())
	{
		try
		{
			logger.fail("Screenshot is below :"+ logger.addScreencastFromPath(screenshotpath));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}

	public void onTestSkipped(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());	// create new entry in the table
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onfinish(ITestContext TestContext)
	{
		extent.flush();
	}
}
