package com.qa.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.utilities.BrowserFactory;
import com.qa.utilities.ConfigDataProvider;
import com.qa.utilities.TestUtil;

public class BaseClass {
	public WebDriver driver;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setupsuite() {
		Reporter.log("Setting up reports and test is getting ready", true);
		config = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+ "/Reports/Facebook"+TestUtil.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting done- test can be started", true);
	}
	
	
	@BeforeMethod
	public void startApp() {
		Reporter.log("Trying to start browser and get application ready", true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		//String enpwd = "YWlydGVsQDEyMw==";
		loginpage.logintofacebook(config.getDatafromConfig("username"), TestUtil.decodestr(config.getDatafromConfig("encryptedpassword")));
		Reporter.log("Browser and application is up and running", true);
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
		Reporter.log("Test is about to get completed", true);
		if(result.getStatus()== ITestResult.FAILURE) {
			TestUtil.captureScreenshot(driver);
			try {
				logger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			else if(result.getStatus() == ITestResult.SUCCESS) {
				try {
					logger.pass("Test Passed ", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenshot(driver)).build());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		report.flush();
		Reporter.log("Test completed >>> Reports generated", true);
		BrowserFactory.quitBrowser(driver);
	}
}

