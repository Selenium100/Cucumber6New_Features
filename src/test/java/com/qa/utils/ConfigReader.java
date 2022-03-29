package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties pro;
	FileInputStream fis;

	public ConfigReader() {

		pro = new Properties();
		try {

			fis = new FileInputStream(".\\src\\test\\resources\\com\\config\\config.properties");
			pro.load(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}catch (IOException e) {

			e.printStackTrace();

	}
		
		

}
	
	public String getBrowser() {
		
		return pro.getProperty("browser");
	}
	
	
	
	
	
	
	
}
