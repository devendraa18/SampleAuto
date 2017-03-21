package com.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by roopalN on 3/1/2017.
 */
public interface IElementLocator {

    public Object getElementByLocator(WebDriver webDriver,String locator, boolean isList);
}
