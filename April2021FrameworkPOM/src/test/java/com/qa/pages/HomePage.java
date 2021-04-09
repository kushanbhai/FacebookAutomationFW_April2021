package com.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utilities.TestUtil;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//span[contains(text(),\"What's on your mind\")]")
	WebElement postamessage;

	@FindBy(xpath = "//div[@class='taijpn5t j83agx80']//div[@class='_5rp7']")
	WebElement message;

	@FindBy(xpath = "//span//div//span//span[text()='Post']")
	WebElement btn_post;

	// span[text()='Add Picture']
	@FindBy(xpath = "//span[text()='Add Picture']")
	WebElement btn_addpicture;

	@FindBy(xpath = "//span[text()='Upload Photo']")
	WebElement btn_uploadphoto;

	// span[text()='Save']

	@FindBy(xpath = "//span[text()='Save']")
	WebElement btn_save;

	@FindBy(xpath = "//a[@aria-label='Facebook']")
	WebElement label_facebook;

	@FindBy(xpath = "//div[text()='Create a Text Story']")
	WebElement label_createatextstory;

	@FindBy(xpath = "//span[text()='Share a photo or write something.']")
	WebElement label_createStory;

	@FindBy(xpath = "//span[text()='Start typing']//ancestor::div[@class='j83agx80 k4urcfbm']")
	WebElement txt_startTyping;

	@FindBy(xpath = "//label[@aria-label='Text']")
	WebElement txt_startTyping1;

	@FindBy(xpath = "//span[text()='Share to Story']")
	WebElement btn_sharetostory;

	//span[text()='Your Story']
	@FindBy(xpath = "//span[text()='Your Story']")
	WebElement label_YourStory;
	public WebElement clickName(String name) {
		// String locator = "xpath=//div//span//following::span[text()='"+name+"']";
		WebElement locator = driver.findElement(By.xpath("//div//span//following::span[text()='" + name + "']"));
		return locator;

	}

	public void postMessage(String name, String msg) {
		try {
			clickName(name).click();
			Thread.sleep(3000);
			label_facebook.click();
			label_createStory.click();
			label_createatextstory.click();
			Actions action1 = new Actions(driver);
			action1.moveToElement(txt_startTyping).click().perform();
			txt_startTyping1.sendKeys(msg);
			Thread.sleep(3000);
			btn_sharetostory.click();
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			boolean displayed = label_YourStory.isDisplayed();
			System.out.println("Your story is displayed : "+displayed);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void uploadPhoto(String filename) throws InterruptedException {
		btn_addpicture.click();
		btn_uploadphoto.click();
		TestUtil.uploadFile(filename);
		btn_save.click();
		Thread.sleep(5000);
	}

}
