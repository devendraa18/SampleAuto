/**
 * 
 */
package com.framework.selenium;

import org.openqa.selenium.WebDriver;

import com.framework.common.WebDriverBase;
import com.framework.core.TestApplication;
import com.framework.core.TestEngine;
import org.testng.Reporter;

/**
 * @author surendrane
 *
 */
public class SeleniumTestEngine extends TestEngine{
	
	WebDriver driver;
	
	@Override
	public TestApplication start() {
		// TODO Auto-generated method stub
        TestApplication testApp = new TestApplication();
		driver = WebDriverBase.getDriverInstance();
        if(driver!=null) {
            SeleniumContext seleniumContext = new SeleniumContext();
            seleniumContext.setDriver(driver);
            testApp.setiTestContext(seleniumContext);
            /*if (application != null && !application.isEmpty()) {
                driver.get(application);
            }*/
        }else{
            Reporter.log("Undefined WebDriver.");
        }
				
		return testApp;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		driver.quit();
	}
}
