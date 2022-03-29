package appHooks;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader config;

	@Before(order = 0)
	public void launchApplication() {

		config = new ConfigReader();
		String browserName = config.getBrowser();
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}

	@After(order = 0)
	public void quitBrowser() {

		driver.quit();
	}

	@After(order=1)
	public void takeFailedScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {

			String scenarioName = scenario.getName().replaceAll(" ", "_");

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] sourcePath = ts.getScreenshotAs(OutputType.BYTES);

			scenario.attach(sourcePath, "image/png", scenarioName);
		}
	}

}
