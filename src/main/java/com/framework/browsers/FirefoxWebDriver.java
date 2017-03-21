package com.framework.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

public class FirefoxWebDriver extends DriverFactory{
	//boolean isRemote = configProperties.isRemote();
	WebDriver driver;

	public WebDriver getDriver() {
				
		String firefoxPath = System.getProperty("user.dir") + "/Drivers/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", firefoxPath);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		//driver = new FirefoxDriver(capabilities);

        if (isRemote) {
            driver = launchGridDriver(capabilities, configProperties.getNodeUrl());
            Reporter.log("Running test on Grid, in browser 'Firefox'", true);
        } else {
            driver = new FirefoxDriver(capabilities);
            Reporter.log("Running test in browser 'FIREFOX'", true);
        }
		
		return driver;
	}
	
	

}
