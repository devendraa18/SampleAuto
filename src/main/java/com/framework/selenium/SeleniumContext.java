/**
 * 
 */
package com.framework.selenium;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.common.Utility;
import com.framework.core.ITestContext;

/**
 * @author surendrane
 *
 */
public class SeleniumContext implements ITestContext {
	
	WebDriver driver;


    public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


    public WebElement getWebElementFromObject(Object pageElement){
        return (WebElement)pageElement;

    }
    public List<WebElement> getWebElementListFromObject(Object pageElement){
        return (List<WebElement>)pageElement;

    }

    public SeleniumWebElement getSeleniumWebElementFromObject(Object pageElement){
        return (SeleniumWebElement)pageElement;

    }


    //@Override
    public void navigateTo(String url) {
		// TODO Auto-generated method stub
		
		driver.get(url);
	}

    //@Override
	public void enterTextIn(Object pageElement, String text) {
		// TODO Auto-generated method stub

        getSeleniumWebElementFromObject(pageElement).getWebElement().sendKeys(text);
	}

    //@Override
	public void clickButton(Object pageElement) {
		// TODO Auto-generated method stub

        getSeleniumWebElementFromObject(pageElement).getWebElement().click();
	}
    //@Override
	public void waitFor(long ms) {
		// TODO Auto-generated method stub

	}

    //@Override
    public void close() {
		// TODO Auto-generated method stub
		driver.close();
	}

	public void takeScreenShot(String pageTitle) {
		// TODO Auto-generated method stub
		try
		{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(pageTitle));

		}catch(Exception e){}
	}

    //@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

    //@Override
    public String getText(Object pageElement) {
		// TODO Auto-generated method stub
		return getSeleniumWebElementFromObject(pageElement).getWebElement().getText();
	}

    //@Override
	public void clearTextBox(Object pageElement) {
        getSeleniumWebElementFromObject(pageElement).getWebElement().clear();
	}

    //@Override
    public String getAttributeValue(Object pageElement, String attributeName) {
		return getSeleniumWebElementFromObject(pageElement).getWebElement().getAttribute(attributeName);
	}

    //@Override
	public void click(Object pageElement) {
        getSeleniumWebElementFromObject(pageElement).getWebElement().click();
	}

    //@Override
	public void clear(Object pageElement) {
        getSeleniumWebElementFromObject(pageElement).getWebElement().clear();
	}



    public void waitUntilElementPresent(Object pageElement) {
        Utility.waitForElementByLocatorToLoad(getSeleniumWebElementFromObject(pageElement).getLocator(), getDriver());
    }

    public void waitUntilElementPresentAndClick(Object pageElement) {
        Utility.waitForElementByLocatorToLoadAndClick(getSeleniumWebElementFromObject(pageElement).getLocator(), getDriver());
    }

    public void hardWaitUntilElementPresent(Object pageElement,int sleepFor, int numberOfAttempts) {
        Utility.hardWaitForElement(getSeleniumWebElementFromObject(pageElement).getLocator(), sleepFor, numberOfAttempts);
    }

    public void hardWaitUntilElementPresentAndClick(Object pageElement,int sleepFor, int numberOfAttempts) {
        hardWaitUntilElementPresent(pageElement,sleepFor, numberOfAttempts);
        getSeleniumWebElementFromObject(pageElement).getWebElement().click();
    }

    public boolean isElementPresent(Object pageElement) {
        return Utility.areElementsPresent(getSeleniumWebElementFromObject(pageElement).getLocator());
    }



}
