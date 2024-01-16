package com.nopcommerce.utilities;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReports implements ITestListener  {
	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentTest tests;
	ExtentReports extent;
	
	@BeforeTest
   public void report() {
		ReadConfig readConfig = new ReadConfig();
		reporter = new ExtentHtmlReporter("./Reports/myreports.html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Test Report");
		reporter.config().setTestViewChartLocation(ChartLocation.TOP);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("host", "local host");
		extent.setSystemInfo("os", "windows");
		extent.setSystemInfo("browser", readConfig.getBrowser());
		extent.setSystemInfo("tester name", "Anu");
	}
	public void onStart(ITestContext Result)					
	{		
		report();
		System.out.println("On Start method invoked....");  		
	}	

	//onFinish method is called after all Tests are executed
	public void onFinish(ITestContext Result) 					
	{		
		System.out.println("On Finished method invoked....");  	
		extent.flush();//it is mandatory to call flush method to ensure information is written to the started reporter.

	}		



	public void onTestFailure(ITestResult Result) 					
	{		
		System.out.println("Name of test method failed:" + Result.getName() );  		
		tests = extent.createTest(Result.getName());//create entry in html report
		tests.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED));
	
	String screenShotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + Result.getName() + ".png";
	
	File screenShotFile = new File(screenShotPath);
	
	if(screenShotFile.exists())
	{
		try {
			tests.fail("Captured Screenshot is below:" + tests.addScreenCaptureFromPath(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//	test.addScreenCaptureFromPath(null)
		
	}		
	

		
			

	// When Test case get Skipped, this method is called.		

	public void onTestSkipped(ITestResult Result)					
	{		
		System.out.println("Name of test method skipped:" + Result.getName() );  		

		tests = extent.createTest(Result.getName());
		tests.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName() ,ExtentColor.YELLOW));
	}			

	// When Test case get Started, this method is called.		

	public void onTestStart(ITestResult Result)					
	{		
		System.out.println("Name of test method started:" + Result.getName() );  		

	}		

	// When Test case get passed, this method is called.		

	public void onTestSuccess(ITestResult Result)					
	{		
		System.out.println("Name of test method sucessfully executed:" + Result.getName() );  		

		tests = extent.createTest(Result.getName());
		tests.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
	}		


	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	{		

	}		


	
}