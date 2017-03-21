/**
 * 
 */
package com.framework.selenium.elementproviders;

import com.framework.core.ITestContext;
import com.framework.core.PageElementProvider;
import com.framework.selenium.SeleniumElementProvider;
import com.framework.selenium.SeleniumLocatorTypes;

/**
 * @author surendrane
 *
 */
public class SearchElementProvider extends PageElementProvider{

    SeleniumElementProvider _localElementProvider;

	public SearchElementProvider(ITestContext context) {
		super(context);
        System.out.println("Inside SearchElementProvider constructor");
		// TODO Auto-generated constructor stub

		_localElementProvider = new SeleniumElementProvider(context);
        if(_localElementProvider==null){
            System.out.println("_localElementProvider is null");
        }
	}

  //  Object searchTextBox=_localElementProvider.getElementByLocatorType(SeleniumLocatorTypes.ID, "lst-ib");
            //new SeleniumWebElement(SeleniumLocatorTypes.ID, "lst-ib");
   /* SeleniumWebElement searchButton=new SeleniumWebElement(SeleniumLocatorTypes.NAME, "btnG");
    SeleniumWebElement downloadLink=new SeleniumWebElement(SeleniumLocatorTypes.LINK, "Downloads - Selenium");*/


	
	public Object SearchTextBox() 
	{

		// TODO Auto-generated method stub
		return _localElementProvider.getElementByLocatorType2("ID", "lst-ib");
                //searchTextBox.getWebElement();
                //_localElementProvider.getElementByID("lst-ib");
	}

	
	public Object SearchButton()
	{
		return _localElementProvider.getElementByLocatorType2("NAME", "btnG");
                //searchButton.getWebElement();
                //_localElementProvider.getElementByName("btnG");
	}
	
	public Object DownloadsLink()
	{
		return _localElementProvider.getElementByLocatorType2("LINK", "Downloads - Selenium");
                //downloadLink.getWebElement();
                //_localElementProvider.getElementByLocatorType(SeleniumLocatorTypes.LINK, "Downloads - Selenium");
	}
}
