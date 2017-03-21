package com.framework.selenium;

import com.framework.common.Utility;
import com.framework.common.WebDriverBase;
import com.framework.core.ITestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by roopalN on 3/1/2017.
 */
public class SeleniumWebElement{

    private SeleniumContext seleniumContext;
    private By locator = null;
    private WebElement webElement = null;

    public SeleniumWebElement(ITestContext context,String locatorType, String locator) {
        //super(context);
        seleniumContext = (SeleniumContext) context;
        setLocator(locatorType,locator);
    }


    public By getLocator() {
        return locator;
    }

    public void setLocator(String locatorType, String locator) {
        SeleniumLocator seleniumLocator=(SeleniumLocator) Utility.getEnumValue(SeleniumLocator.class, locatorType);
        this.locator = seleniumLocator.getLocator(locator);
    }

    public WebElement getWebElement() {
        if (webElement == null) {
            setWebElement();
        }
        return webElement;
    }

    public void setWebElement() {
        webElement = seleniumContext.getDriver().findElement(locator);
    }

    public List<WebElement> getListWebElements() {
        return seleniumContext.getDriver().findElements(locator);
    }

}
