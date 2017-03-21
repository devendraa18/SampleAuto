/**
 * Core for Generic Pages
 */
package com.framework.core;

/**
 * @author surendrane
 *
 */
public abstract class TestPage {
	
	protected ITestContext iTestContext;


    public ITestContext getiTestContext() {
        return iTestContext;
    }
	public void setiTestContext(ITestContext iTestContext) {
		this.iTestContext = iTestContext;
	}


    public TestPage(ITestContext context)
	{
		this.iTestContext = context;
        //code to initialise webElements
        //initializeElementProvider();
	}

	public void takeScreenShot(String title)
	{
		getiTestContext().takeScreenShot(title);
	}


    public abstract void initializeElementProvider();
	
}
