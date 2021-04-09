package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	
	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
		
		
	}
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "pass")
	WebElement password;
	
	@FindBy(name = "login")
	WebElement login;
	
	public void logintofacebook(String uname, String pwd) {
		try {
			
			username.sendKeys(uname);
			password.sendKeys(pwd);
			login.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
