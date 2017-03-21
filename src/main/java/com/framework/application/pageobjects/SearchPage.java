/**
 * 
 */
package com.framework.application.pageobjects;
import com.framework.core.ITestContext;
import com.framework.core.TestPage;
import com.framework.selenium.SeleniumElementProvider;
import com.framework.selenium.elementproviders.SearchElementProvider;
import org.testng.Assert;

/**
 * @author surendrane
 *
 */
public class SearchPage extends TestPage {
	
	ITestContext _context;
	SearchElementProvider _localElementProvider;
    SeleniumElementProvider elementProvider;
	
	public SearchPage(ITestContext context) {
		super(context);
        System.out.println("Inside SearchPage constructor");
		this._context = context;
	}


    //By button = By.cssSelector("");

	@Override
	public void initializeElementProvider() {
		_localElementProvider = new SearchElementProvider(_context);
        elementProvider=new SeleniumElementProvider(_context);
	}
	
	public void searchText(String txt)
	{
        _context.enterTextIn(elementProvider.getElementByLocatorType2("ID", "lst-ib"),txt);
		//_context.enterTextIn(_localElementProvider.SearchTextBox(),txt);
		_context.clickButton(_localElementProvider.SearchButton());
        
	}
	
	public void clickDownloadsLink()
	{
		_context.clickButton(_localElementProvider.DownloadsLink());
	}
}
