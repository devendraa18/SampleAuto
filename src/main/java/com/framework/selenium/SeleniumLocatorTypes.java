package com.framework.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by roopalN on 3/1/2017.
 */
public enum SeleniumLocatorTypes implements IElementLocator {
    ID {
    //@Override
    public Object getElementByLocator(WebDriver webDriver,String locator, boolean isList) {
        if(isList)
            return webDriver.findElements(By.id(locator));
        else
            return webDriver.findElement(By.id(locator));
    }
    },
    CSS {
        //@Override
        public Object getElementByLocator(WebDriver webDriver,String locator, boolean isList) {
            if(isList)
                return webDriver.findElements(By.cssSelector(locator));
            else
                return webDriver.findElement(By.cssSelector(locator));
        }
    },
    XPATH {
        //@Override
        public Object getElementByLocator(WebDriver webDriver,String locator, boolean isList) {
            if(isList)
                return webDriver.findElements(By.xpath(locator));
            else
                return webDriver.findElement(By.xpath(locator));
        }
    },
    NAME {
        //@Override
        public Object getElementByLocator(WebDriver webDriver,String locator, boolean isList) {
            if(isList)
                return webDriver.findElements(By.name(locator));
            else
                return webDriver.findElement(By.name(locator));
        }
    },
    LINK {
        //@Override
        public Object getElementByLocator(WebDriver webDriver,String locator, boolean isList) {
            if(isList)
                return webDriver.findElements(By.linkText(locator));
            else
                return webDriver.findElement(By.linkText(locator));
        }
    },
    CLASS {
        //@Override
        public Object getElementByLocator(WebDriver webDriver,String locator, boolean isList) {
            if(isList)
                return webDriver.findElements(By.className(locator));
            else
                return webDriver.findElement(By.className(locator));
        }
    }
}
