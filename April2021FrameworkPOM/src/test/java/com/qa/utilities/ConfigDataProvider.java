package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;
	public ConfigDataProvider() {
		File src = new File("./Configuration/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to load the config file >>"+e.getMessage());
		}
		
	}
	
	public String getDatafromConfig(String keytosearch) {
		return pro.getProperty(keytosearch);
	}
	
public String getBrowser() {
		return pro.getProperty("Browser");
	}

public String getStagingURL() {
	return pro.getProperty("qaurl");
}
}
