package com.framework.selenium.elementproviders;

import com.framework.core.ITestContext;
import com.framework.core.PageElementProvider;
import com.framework.selenium.SeleniumElementProvider;

public class WpLoginElementProvider extends PageElementProvider{
	
	SeleniumElementProvider _localElementProvider;

	public WpLoginElementProvider(ITestContext context) {
		super(context);
		System.out.println("Inside WpLoginElementProvider constructor");
		
		_localElementProvider = new SeleniumElementProvider(context);
		if(_localElementProvider==null){
			  System.out.println("_localElementProvider is null");
		}
	}
	
	
	public Object usernameTextBox(){
		return _localElementProvider.getElementByLocatorType2("ID", "user_login");
	}
	
	
	public Object passwordTextBox(){
		return _localElementProvider.getElementByLocatorType2("ID", "user_pass");
	}
	
	public Object loginButton(){
		return _localElementProvider.getElementByLocatorType2("ID", "wp-submit");
	}
	

}
