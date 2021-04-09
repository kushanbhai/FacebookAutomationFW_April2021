package com.qa.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.pages.BaseClass;
import com.qa.pages.HomePage;
import com.qa.utilities.TestUtil;

public class FacebookLoginTest extends BaseClass {

	HomePage homepage;

	

	@Test(priority = 1)
	public void UploadPhoto() throws InterruptedException {
		logger = report.createTest("Login to Facebook");
		homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.uploadPhoto(config.getDatafromConfig("filename"));
		//System.out.println("================Photo uploaded successfully==================");
		logger.pass("=============Photo uploaded successfully============");
		Thread.sleep(3000);
		
	}

	@Test(priority = 2)
	public void postMessage() throws InterruptedException {
		logger = report.createTest("Post a message Facebook");
		homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.postMessage("Ravi Kumar", "Hello Friends");
		logger.pass("=============Message posted successfully============");
	}

}
