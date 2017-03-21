package com.framework.application.pageobjects;

import com.framework.core.ITestContext;
import com.framework.core.TestPage;
import com.framework.selenium.SeleniumElementProvider;
import com.framework.selenium.elementproviders.SearchElementProvider;
import com.framework.selenium.elementproviders.WpLoginElementProvider;

public class WordpressLoginPage extends TestPage{
	
	ITestContext _context;
	SearchElementProvider _localElementProvider;
	WpLoginElementProvider localElementProvider;
    SeleniumElementProvider elementProvider;
	

	public WordpressLoginPage(ITestContext context) {
		super(context);
		System.out.println("Inside WordpressLoginPage constructor");
		this._context = context;
	}

	@Override
	public void initializeElementProvider() {
		//_localElementProvider = new SearchElementProvider(_context);
		localElementProvider = new WpLoginElementProvider(_context);
        elementProvider=new SeleniumElementProvider(_context);
		
	}
	
	public void enterCredentials(String username, String password){
		_context.enterTextIn(localElementProvider.usernameTextBox(), username);
		_context.enterTextIn(localElementProvider.passwordTextBox(), password);
	}
	
	public void clickLoginButton(){
		_context.click(localElementProvider.loginButton());
	}
	
	

}
