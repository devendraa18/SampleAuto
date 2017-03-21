/**
 * 
 */
package com.framework.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.application.pageobjects.SearchPage;
import com.framework.application.pageobjects.WordpressLoginPage;
import com.framework.reporter.BaseTest;

/**
 * @author surendrane
 *
 */
public class SampleTest extends BaseTest {

	SearchPage page;
	WordpressLoginPage wpPage;

	@BeforeMethod
	public void setUp2() {
		System.out.println("Inside SampleTest beforeMethod");
		getDriverInstance().get("https://login.wordpress.org/");
		//page = testApp.getInstance(SearchPage.class);
		wpPage = testApp.getInstance(WordpressLoginPage.class);
		// "https://www.google.co.in/")
	}

	/*
	 * @Test(enabled=true) public void testCase1() { if(page==null){
	 * System.out.println("page is null"); } page.searchText("selenium");
	 * page.takeScreenShot("SearchScreenshot.png"); test.log(LogStatus.INFO,
	 * "Snapshot below: " + test.addScreenCapture("SearchScreenshot.png")); //
	 * page.clickDownloadsLink(); // page.takeScreenShot("DownloadsPage.png");
	 * test.log(LogStatus.INFO, "Downloads Page : " +
	 * test.addScreenCapture("DownloadsPage.png")); test.log(LogStatus.PASS,
	 * "Sample test completed"); }
	 */

	/*
	 * @Test(enabled=true) public void testCase2() { //test =
	 * extent.startTest("Failure Test"); page.searchText("Winnium");
	 * page.takeScreenShot("SearchScreenshot1.png"); test.log(LogStatus.INFO,
	 * "Snapshot below: " + test.addScreenCapture("SearchScreenshot1.png"));
	 * page.clickDownloadsLink(); page.takeScreenShot("Failure.png");
	 * test.log(LogStatus.INFO, "Downloads Page : " +
	 * test.addScreenCapture("Failure.png")); test.log(LogStatus.FAIL,
	 * "Sample test completed"); }
	 * 
	 * @Test(enabled=false) public void testCase3() { //test =
	 * extent.startTest("Cloud Test"); page.searchText("selenium");
	 * page.clickDownloadsLink(); test.log(LogStatus.PASS,
	 * "Sample test completed"); }
	 */

	@Test(enabled = true, priority = 0)
	public void wordPressLogin() {
		{
			if (wpPage == null) {
				System.out.println("page is null");
			}
			//page.get("https://login.wordpress.org/");
			wpPage.enterCredentials("devendraa18", "devendra@9099");
			wpPage.clickLoginButton();
			
//			page.findElement(By.id("user_login")).sendKeys("devendraa18");
//			page.findElement(By.id("user_pass")).sendKeys("devendra@9099");
//			page.findElement(By.id("wp-submit")).click();
//			page.findElement(By.linkText("Log Out")).click();
		}
	}

}
