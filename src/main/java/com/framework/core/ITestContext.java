/**
 * Interface for common methods
 */
package com.framework.core;

/**
 * @author surendrane
 *
 */
public interface ITestContext {
	
	void navigateTo(String url);
	void enterTextIn(Object pageElement, String text);
    void clickButton(Object pageElement);
    void waitFor(long ms);
    void close();
    void takeScreenShot(String pageTitle);
    String getPageTitle();
    String getText(Object pageElement);
    void clearTextBox(Object pageElement);
    String getAttributeValue(Object pageElement, String attributeName);
    void click(Object pageElement);
    void clear(Object pageElement);
}
