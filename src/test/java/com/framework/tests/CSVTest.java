package com.framework.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.framework.datautility.CsvUtil;
import com.framework.datautility.TestData;

public class CSVTest {

	CsvUtil csv = new CsvUtil();
	String filePath = System.getProperty("user.dir")+ "/DataProvider/TestData.csv";
	
	
	@Test(enabled=false)
	public void testCSV() throws IOException{
		csv.setCsvFile(filePath);
		String str = csv.getCSVCellData(4, 2);
		System.out.println(str);
		
	}
	
	
	@Test(dataProvider = "test", dataProviderClass=TestData.class)
	public void testDataProvider(String firstName, String lastName, String age, String mobile, String email) throws FileNotFoundException{
		
		String fName = firstName;
		System.out.print(fName);
		
		
		
//		System.out.println("Last Name=" + lastName.toString());
//		System.out.println("Age=" + age.toString());
//		System.out.println("Mobile Number=" + mobile.toString());
//		System.out.println("Email Address=" + email.toString());
	}
	
	
	@Test(enabled=false)
	public void csvDataFectchingTest() throws IOException{
		String[][] arr = csv.assignCSVRowToDataProvider(filePath);
		
		for(int i=0; i < arr.length; i++){
			
			for(int j=0; j< arr[i].length; j++){
				
				System.out.println("Value of 2D Array:= " +arr[i][j].toString());
			}
		}
	}
	
	
	
	/*@DataProvider(name ="test")
	public String[][] loginData() throws IOException{
		
		String[][] arrayObject = csv.assignCSVRowToDataProvider(filePath);
		
		return arrayObject;
		
	}*/
}
