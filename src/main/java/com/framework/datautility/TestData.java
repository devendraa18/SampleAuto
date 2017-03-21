package com.framework.datautility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestData {
	
	CsvUtil csv = new CsvUtil();
	String filePath = null;

	@DataProvider(name ="test")
	public String[][] loginData() throws IOException{
		
		String[][] arrayObject = csv.assignCSVRowToDataProvider(filePath);
		
		return arrayObject;
		
	}

}
