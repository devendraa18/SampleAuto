/**
 * 
 */
package com.framework.core;

/**
 * @author surendrane
 *
 */
public abstract class ToolElementProvider {
	
	public ToolElementProvider()
	{		
	}
	
	//public abstract Object getElementByID(String id);
	//public abstract Object getElementByName(String name);
    public abstract Object getElementByLocatorType(String locatorTypes, String locator);
    public abstract Object getElementListByLocatorType(String locatorTypes, String locator);
}
