/**
 * 
 */
package com.framework.reporter;

import com.framework.common.WebDriverBase;
import com.framework.core.TestApplication;
import com.framework.core.TestEngine;
import com.framework.selenium.SeleniumTestEngine;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.lang.reflect.Method;

/**
 * @author surendrane
 *
 */
public abstract class BaseTest extends WebDriverBase{
	
	protected ExtentReports extent;
    protected ExtentTest test;
    protected TestEngine testEngine;
    protected TestApplication testApp;

    @BeforeMethod
    public void setUp(Method method ) {
        System.out.println("Inside BaseTest beforeMethod");
        testEngine = new SeleniumTestEngine();
        testApp = testEngine.start();
        test = extent.startTest(method.getName());
    }
    
    final String filePath = "Extent.html";

    @AfterMethod
    protected void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            test.log(LogStatus.PASS, "Test passed");
        }
        
        extent.endTest(test);        
        extent.flush();
    }

    @AfterMethod
    public void tearDown()
    {

        getDriverInstance().quit();
    }
    
    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentManager.getReporter(filePath);
    }
    
    @AfterSuite
    protected void afterSuite() {
        extent.close();
        testEngine.stop();
    }
}
