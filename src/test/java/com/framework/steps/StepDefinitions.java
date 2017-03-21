package com.framework.steps;

import org.junit.After;

import com.framework.application.pageobjects.SearchPage;
import com.framework.core.TestApplication;
import com.framework.core.TestEngine;
import com.framework.selenium.SeleniumTestEngine;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	SearchPage page;
	TestEngine testEngine;
	TestApplication testApp;
	
	@Before
	public void before()
	{
		testEngine = new SeleniumTestEngine();		
	}
	
	@After
	public void after()
	{
		testEngine.stop();
	}
	
	@Given("I Navgiate to Google.com")
	public void iNavigateTo()
	{	
		testApp = testEngine.start();
		page = testApp.getInstance(SearchPage.class);		
	}
	
	@When("I Search for 'Selenium'")
	public void iSearchFor() throws InterruptedException
	{
		page.searchText("selenium");
		page.takeScreenShot("SearchScreenshot.png");
	}
	
	@Then("I am able to Click 'Downloads - Selenium'")
	public void iAmableToSeeALink()
	{		
		page.clickDownloadsLink();
	}
}
