package com.qa.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class TestUtil {

	public static void handlewindowPopups(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).build().perform();
	
	}
	
	public static void uploadFile(String filename) {
		try {
			Robot robot = new Robot();
			robot.setAutoDelay(2000);
			StringSelection stringselection = new StringSelection(filename);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
			robot.setAutoDelay(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.setAutoDelay(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static String decodestr(String encodedstr) {
	byte[] decoded = Base64.decodeBase64(encodedstr);
	return new String(decoded);
}

public static String captureScreenshot(WebDriver driver) {
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String screenshotpath = System.getProperty("user.dir")+"//Screenshots/Facebook_"+ getCurrentDateTime() +".png";
	try {
		FileHandler.copy(src, new File(screenshotpath));
		System.out.println("========Screenshot captured========");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Unable to capture screenshot: "+e.getMessage());
	}
	return screenshotpath;
	
	
}

public static String getCurrentDateTime() {
	DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	Date currentdate = new Date();
	return customformat.format(currentdate);
}
}
