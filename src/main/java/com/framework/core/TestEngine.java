/**
 * Engine Core 
 */
package com.framework.core;

/**
 * @author surendrane
 *
 */
public abstract class TestEngine {
	
	public static TestApplication TestApp = null;
	
	public TestApplication getTestApp() {
		return TestApp;
	}
	public static void setTestApp(TestApplication testApp) {
		TestApp = testApp;
	}
	
	public abstract TestApplication start();
	public abstract void stop();
	
}
