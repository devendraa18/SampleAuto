/**
 * 
 */
package com.framework.selenium;

import com.framework.common.Utility;
import com.framework.core.ToolElementProvider;
import org.openqa.selenium.By;

import com.framework.core.ITestContext;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * @author surendrane
 *
 */
public class SeleniumElementProvider extends ToolElementProvider{

	private SeleniumContext seleniumContext;


    public SeleniumElementProvider(ITestContext context) {
        //super(context);
        seleniumContext = (SeleniumContext) context;
    }



    public SeleniumContext getSeleniumContext() {
        return seleniumContext;
    }

    public void setSeleniumContext(SeleniumContext seleniumContext) {
        this.seleniumContext = seleniumContext;
    }


    //@Override
	public Object getElementByID(String id) {
		// TODO Auto-generated method stub	
		return seleniumContext.getDriver().findElement(By.id(id));
	}

	//@Override
	public Object getElementByName(String name) {
		// TODO Auto-generated method stub
		return seleniumContext.getDriver().findElement(By.name(name));
	}

    @Override
    public Object getElementListByLocatorType(String locatorTypes, String locator) {
        SeleniumLocatorTypes seleniumLocatorTypes = SeleniumLocatorTypes.valueOf(locatorTypes);
       return seleniumLocatorTypes.getElementByLocator(seleniumContext.getDriver(),locator, true);
    }
    @Override
    public Object getElementByLocatorType(String locatorTypes, String locator) {
            SeleniumLocatorTypes seleniumLocatorTypes = SeleniumLocatorTypes.valueOf(locatorTypes);
            return  seleniumLocatorTypes.getElementByLocator(seleniumContext.getDriver(),locator, false);

        }

    public Object getElementByLocatorType2(String locatorType, String locator) {
        //seleniumContext.setLocator(locatorType, locator);
        SeleniumWebElement seleniumWebElement= new SeleniumWebElement(seleniumContext,locatorType,locator );
        return seleniumWebElement;

    }

    public Object getElementListByLocatorType2(String locatorType, String locator) {
        SeleniumWebElement seleniumWebElement= new SeleniumWebElement(seleniumContext,locatorType,locator );
        return seleniumWebElement;
    }


}







