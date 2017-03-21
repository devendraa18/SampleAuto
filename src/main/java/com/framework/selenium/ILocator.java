package com.framework.selenium;

import org.openqa.selenium.By;

/**
 * Created by roopalN on 3/3/2017.
 */
public interface ILocator {

    public By getLocator(String locatorType);
}
