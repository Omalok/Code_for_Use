package com.QA.R_Auction.UtilityClass;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataXSSF {


	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static int count=0;

	public static void main(String[] args) {

		try {
			File file = new File("D:\\MySeleniumProject\\p1109\\ExcelData\\TestDataxlsFormat.xls");
			File file1 = new File("D:\\MySeleniumProject\\p1109\\ExcelData\\TestData.xlsx");
			FileInputStream fis = new FileInputStream(file1);	
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			String sheetName = workbook.getSheetName(0);
			
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);	
		}catch(Exception e) 
		{
			System.out.println("Error"+e);
		}


	}
}
