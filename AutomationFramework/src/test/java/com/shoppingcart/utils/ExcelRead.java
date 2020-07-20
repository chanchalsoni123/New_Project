package com.shoppingcart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

	/**
	 * Instantiates a excel.
	 *
	 * @param path the path
	 */
	public ExcelRead(String path) {
		try {
			File src = new File(path);
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	
	/**
	 * Get Entire Data of Sheet
	 *
	 * @param sheetName the sheet name
	 * @return Object[][] having Map(ColName, Value) within it
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Object[][] readData(String sheetName) {
		int numOfcols = getColumnCount(sheetName);
		Map<String, String> map = null; 
		Object[][] obj = new Object[getRowCount(sheetName)-1][1];
		
		for (int i = 1; i<getRowCount(sheetName); i++) {
			map = new HashMap<String, String>();
			for (int j = 0; j<numOfcols; j++) {
				map.put(readData(sheetName,0, j), readData(sheetName,i, j));
			}
			obj[i-1][0] = map;
		}
		return obj;
	}
	
	
	/**
	 * Gets the row count of sheet
	 *
	 * @param sheetName the sheet name
	 * @return the row count
	 */
	public int getRowCount(String sheetName) {
		sheet = wb.getSheet(sheetName);

		return sheet.getLastRowNum() + 1;
	}

	/**
	 * Gets the column count of sheet.
	 *
	 * @param sheetName the sheet name
	 * @return the columns count
	 */
	public int getColumnCount(String sheetName) {
		sheet = wb.getSheet(sheetName);
		XSSFRow row = sheet.getRow(0);
		return row.getLastCellNum();
	}
	
	
	
	/**
	 * Read data from the sheet
	 *
	 * @param sheetName the sheet name
	 * @param row       the row
	 * @param col       the col
	 * @return the string
	 */
	public String readData(String sheetName, int row, int col) {
		String data="";
		try {
			sheet = wb.getSheet(sheetName);
			data = sheet.getRow(row).getCell(col).getStringCellValue();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}


}
