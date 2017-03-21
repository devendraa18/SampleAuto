package com.framework.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by roopalN on 3/3/2017.
 */
public enum SeleniumLocator implements ILocator {
    ID{
        //@Override
        public By getLocator(String locator) {
            return By.id(locator);
        }
    },
    CSS {
        //@Override
        public By getLocator(String locator) {
            return By.cssSelector(locator);
        }},
    XPATH {
        //@Override
        public By getLocator(String locator) {
            return By.xpath(locator);
        }},
    NAME {
        //@Override
        public By getLocator(String locator) {
            return By.name(locator);
        }},
    LINK {
        //@Override
        public By getLocator(String locator) {
            return By.linkText(locator);
        }},
    CLASS {
        //@Override
        public By getLocator(String locator) {
            return By.className(locator);
        }}
}

