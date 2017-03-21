package com.framework.common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Utility {

    public static boolean isNotNull(String property) {
        if (property != null && !property.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isStringInt(String inputString) {
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    public static boolean isStringFloat(String inputString) {
        try {
            Float.parseFloat(inputString);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static String[] createDTOList(String property){
        String[] propertyArray=null;
        if(Utility.isNotNull(property)) {
            propertyArray = property.split(",");
        }
        return propertyArray;
    }

    /**
     * To generate random number fromm the given range.
     * @param min
     * @param max
     * @return
     */
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * To get the string as number
     *
     * @param number
     * @return
     */
    public static int getStringAsNumber(String number) {
        Assert.assertNotNull(number);
        number = number.replace("(", "").replace(")", "").replace(",", "").replace("$", "");
        number = number.replaceAll("[a-zA-Z]", "").trim();
        Assert.assertTrue(number.length() > 0);
        Assert.assertTrue(Utility.isStringInt(number), "Input value is not an integer");
        return Integer.parseInt(number);
    }
    
    /**
     *
     * @param element
     * @return
     */
    public static boolean isElementPresent(WebElement element) {
    	try {
    		element.isDisplayed();
    	} catch (NoSuchElementException e) {
    		return false;
    	}
    	return true;
    }

    /**
     * Check if element is present by using findElements that is
     * safe to use and returns empty list if element is not found.
     * 
     * @param locator By locator can be By.xpath(yourPathHere)
     * @return true if element or elements are found, false if not
     */
    public static boolean areElementsPresent(By locator) {
    	List<WebElement> elementsList = WebDriverBase.getDriverInstance().findElements(locator);
    	if (elementsList.isEmpty()) {
    		Reporter.log("<p>Could not find elements with a By: " + locator.toString() + "</p>" );
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    /**
     * Formats message for sysout and reporter.log and outputs them.
     * @param message String to output
     */
    public static void logMessageSysoutAndReporter(String message) {
    	System.out.println(message);
    	Reporter.log("<p>" + message + "<p>");
    }
    
    /**
     * Assert True message is: pageName + " page '" + verifyUrl + "' did not load" and
     * 
     * Report log gets: pageName + " page '" + verifyUrl + "' loaded"
     * 
     * @param verifyUrl partial url to string compare to (is case insensitive)
     * @param pageName Name of the page we expect to load (message appends 'page') to the name
     */
    public static void verifyPageByPartialUrl(String verifyUrl, String pageName, WebDriver webDriver) {
        handledThreadSleep(Constants.MINOR_WAIT_HANDLED_TIME_MS);
        Assert.assertTrue(isCurrentUrlContainPartialUrl(verifyUrl, webDriver), pageName + " page '" + verifyUrl + "' did not load");
    	logMessageSysoutAndReporter(pageName + " page '" + verifyUrl + "' loaded");
    }
    
    public static boolean isCurrentUrlContainPartialUrl(String partialUrl, WebDriver webDriver) {
//    	return getDriverInstance().getCurrentUrl().toLowerCase().contains(partialUrl.toLowerCase());
    	return webDriver.getCurrentUrl().toLowerCase().contains(partialUrl.toLowerCase());
    }
    
    /**
     * Select dropdown of element selectElement option at index
     * @param selectElement
     * @param index
     * @return WebElement with selected values
     */
    public static WebElement selectDropDown(WebElement selectElement, int index) {
		Select varIdDropDown = new Select(selectElement);
		varIdDropDown.selectByIndex(index);
		return varIdDropDown.getFirstSelectedOption();
	}
    
    /**
     * Select dropdown of element selectElement by Value
     * @param selectElement
     * @param value
     * @return WebElement with selected values
     */
    public static WebElement selectDropDownValue(WebElement selectElement, String value) {
		Select varIdDropDown = new Select(selectElement);
		varIdDropDown.selectByValue(value);
		return varIdDropDown.getFirstSelectedOption();
	}
    
    public static HashMap<String, String> getSelectValues(WebElement selectWebElement) {
    	HashMap<String, String> textToValues = new HashMap<String, String>();
    	Select selectElement = new Select(selectWebElement);
    	ArrayList<WebElement> selectOptions = new ArrayList<WebElement>(selectElement.getOptions());
    	
    	for(WebElement selectOption : selectOptions) {
    		textToValues.put(selectOption.getText(), selectOption.getAttribute("value"));
    	}
    	
    	return textToValues;
    }
    
    /**
     * @param element
     * @param webDriver
     * @return
     */
    public static void waitForElementToLoad(WebElement element, WebDriver webDriver) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Constants.PAGE_ITEM_LOAD_TIME_S);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (org.openqa.selenium.WebDriverException e) {
            Assert.fail("Element is not visible or loaded on UI.");
        }

    }

    /**
     * @param element
     * @param webDriver
     * @return
     */
    public static boolean waitForElementToClickable(WebElement element, WebDriver webDriver) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Constants.PAGE_ITEM_LOAD_TIME_S);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (org.openqa.selenium.WebDriverException e) {
            return false;
        }

    }
    
    public static void waitForElementByLocatorToLoad(By locator, WebDriver webDriver) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Constants.PAGE_ITEM_LOAD_TIME_S);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (org.openqa.selenium.WebDriverException e) {
            Assert.fail("Element is not visible or loaded on UI.");
        }
    }
    
    public static void waitForElementByLocatorToLoadAndClick(By locator, WebDriver webDriver) {
    	waitForElementByLocatorToLoad(locator, webDriver);
    	webDriver.findElement(locator).click();
    }
    
    public static void waitForPageToLoad(int timeOut) {
        if (timeOut > 0) {
            WebDriverBase.getDriverInstance().manage().timeouts().pageLoadTimeout((long) timeOut, TimeUnit.SECONDS);
        }
    }
    
    public static void clickElement(WebElement element) {
        element.click();
        waitForPageToLoad(Constants.PAGE_ITEM_LOAD_TIME_S);
    }

    public static void waitForElementToLoadAndClick(WebElement element, WebDriver webDriver) {
        if(waitForElementToClickable(element,webDriver)) {
            clickElement(element);
            waitForPageToLoad(Constants.PAGE_ITEM_LOAD_TIME_S);
        }else{
            Assert.fail("Element not found on UI.");
        }
    }
    
    /**
     * Try/Catch thread.sleep
     * @param milliseconds The amount of milliseconds the thread will sleep.
     */
    public static void handledThreadSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean hardWaitForElement(By locator, int sleepFor, int numberOfAttempts) {
    	for (int i = 1; i <= numberOfAttempts; i++) {
    		handledThreadSleep(sleepFor);
    		if (areElementsPresent(locator)) {
    			return true;
    		}
    	}
    	return false;
    }

    public static String[] splitParams(String str) {
        if (str != null) {
            return str.split("\\s*,\\s*");
        }
        return null;
    }
    public static Enum getEnumValue(Class enumClass, String input) {
        Enum enumType=null;
        try {
            enumType= Enum.valueOf(enumClass, input);
        }catch (IllegalArgumentException e){
            Assert.fail("Input should match to one of the enums present in class:" + enumClass.getClass().getName());
        }
        return enumType;
    }

}


