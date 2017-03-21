package com.framework.datautility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class CsvUtil {

	CSVReader reader;
	// String filePath = System.getProperty("user.dir")+
	// "/DataProvider.TestData.csv";

	public void setCsvFile(String filePath) throws FileNotFoundException {
		reader = new CSVReader(new FileReader(filePath));
	}

	public String[] getCSVRow(int rowNum) throws IOException {

		int rowId = 0;
		String[] value = null;
		List<String[]> list = reader.readAll();

		for (rowId = 0; rowId < list.size(); rowId++) {
			value = list.get(rowNum);
			if (rowId == rowNum) {
				return value;
			}
		}
		return null;
	}
	
	
	public String getCSVCellData(int rowNum, int colNum) throws IOException {

		int colId = 0;
		String[] row = getCSVRow(rowNum);
		String data = null;

		for (colId = 0; colId < row.length; colId++) {
			
			if (colId == colNum) {
				data = row[colNum];
				return data;
			}
		}

		return null;
	}
	
	
	public String[][] assignCSVRowToDataProvider(String filePath) throws IOException {

		setCsvFile(filePath);
		
		String[][] arrayCSVData = null;
		String[] row = null;
		List<String[]> list = reader.readAll();
		
		row = list.get(0);

		int totalNumberOfRows = list.size();
		int totalNumberOfCols = row.length;
		
		arrayCSVData = new String[totalNumberOfRows-1][totalNumberOfCols];
		
		for (int i = 1; i< totalNumberOfRows; i++) {
			row = list.get(i);
			
			for(int j = 0; j < row.length; j++){
				arrayCSVData[i-1][j] = row[j];
			}
			
		}
		return arrayCSVData;
	}

	

}
