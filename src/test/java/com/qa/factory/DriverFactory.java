package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is used to initialize the thread local driver on the basis of
	 * given browser
	 * 
	 * 
	 * @param browser
	 * @return tlocal
	 */

	public WebDriver init_driver(String browser) {

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			tdriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver());
		} else {

			System.out.println("Pass a valid browser name " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	/**
	 * 
	 * This is used to get the driver with threadlocal
	 * 
	 * @return driver
	 */

	public static synchronized WebDriver getDriver() {

		return tdriver.get();
	}

}
