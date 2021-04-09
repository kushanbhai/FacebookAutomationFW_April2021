package com.qa.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browsername, String appurl) {
		if (browsername.equals("Chrome")) {
			ChromeOptions options = new ChromeOptions();

			// Add chrome switch to disable notification - "**--disable-notifications**"
			options.addArguments("--disable-notifications");

			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver(options);

		}

		else if (browsername.equals("Firefox")) {

		}

		else if (browsername.equals("IE")) {

		}

		else {
			System.out.println("We dont support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appurl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
