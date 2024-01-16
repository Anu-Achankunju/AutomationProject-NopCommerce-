package com.nopcommerce.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.nopcommerce.utilities.ReadConfig;

public class BaseClass {
	ReadConfig  readConfig= new ReadConfig();
	String urls= readConfig.getBaseUrl();
	String browser= readConfig.getBrowser();
	public static WebDriver driver;
	@BeforeClass
	public void setup() {

		if(browser.equalsIgnoreCase("Chrome")) {
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			driver= new EdgeDriver();
		}
		else {
			driver= new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		FileUtils.copyFile(src, dest);
	}
	
//	@AfterMethod
//	public void afterMethod() {
//		driver.close();
//		driver.quit();
//	}
}
