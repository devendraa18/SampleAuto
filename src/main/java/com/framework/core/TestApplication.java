/**
 * Test Application class would
 * initialize context and return page object
 */
package com.framework.core;

import org.testng.Assert;

import java.lang.reflect.InvocationTargetException;


/**
 * @author surendrane
 *
 */
public class TestApplication {
	
	private ITestContext iTestContext;

    public ITestContext getITestContext() {
        return iTestContext;
    }

    public void setiTestContext(ITestContext iTestContext) {
        this.iTestContext = iTestContext;
    }

    @SuppressWarnings("unchecked")
	public <T extends TestPage> T getInstance(Class<?> TestPage)
	{
		T page = null;

		try {
            Assert.assertNotNull(iTestContext, "Actions shouldn't be null.");
			page = (T) TestPage.getConstructor(ITestContext.class).newInstance(iTestContext);
            Assert.assertNotNull(page, "page shouldn't be null.");
            page.initializeElementProvider();
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return page;
	}
	
}
