package com.QA.R_Auction.UtilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.QA.R_Auction.baseClass.Driver_Class;

public class ExcelRederUsingHSSF{

	public static String filePath= "";

	static HSSFWorkbook workBook;
	static HSSFSheet sheet;
	static HSSFRow row;
	static HSSFCell cell;
	public static void main(String[] args) {

		try {
			//To upload a file here.
			File file = new File("D:\\MySeleniumProject\\p1109\\ExcelData\\TestDataxlsFormat.xls");
			
			// To read the file
			FileInputStream fis = new FileInputStream(file);
			
			//To load the workbook
			workBook = new HSSFWorkbook(fis);
			//To load the particular sheet to fetch data.
			sheet = workBook.getSheet("Credentials");
			
			// TO get the specific row
			row = sheet.getRow(1);
			
			// last row count from the given index
			System.out.println(sheet.getRow(0).getLastCellNum());
			
			//to get the cell in a particular row.
			cell = row.getCell(1);
			System.out.println(cell);
			
			//Below statement will give an error(java.lang.IllegalStateException: Cannot get a STRING value from a NUMERIC cell) 
			//System.out.println(cell.getStringCellValue());
			
			//So to convert all type into string we use			
			cell.setCellType(1);
			
			//this statement will get any value now
			//Note:- use apostrophe(') to write a any date formate.
			System.out.println(cell.getStringCellValue());
			
			// to run all the data from the row
			
		} catch (Exception e) {
			e.printStackTrace();
		}








	}

}
