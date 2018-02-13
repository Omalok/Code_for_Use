package com.QA.R_Auction.UtilityClass;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReadCompleteRowNCol {

	//HSSF support all file formats.
	static HSSFWorkbook workBook;
	static HSSFSheet sheet;
	static HSSFRow row;
	static HSSFCell cell;

	public static void main(String[] args) {

		try {
			
			File file = new File("D:\\MySeleniumProject\\p1109\\ExcelData\\TestDataxlsFormat.xls");
			File file1 = new File("D:\\MySeleniumProject\\p1109\\ExcelData\\TestData.xlsx");
			FileInputStream fis = new FileInputStream(file);

			workBook = new HSSFWorkbook(fis);
			System.out.println("Total no of sheets: "+workBook.getNumberOfSheets());
			System.out.println("Sheet name of index 2: "+workBook.getSheetName(2));
			String sheetname = workBook.getSheetName(0);		
		
			//Method
			getCellData(1, 1,sheetname);
			
		}catch(Exception e)

		{
			System.out.println("Error"+e);
		}
	}
	
	public static void getCellData(int irow, int icol, String stname) 
	{
		sheet = workBook.getSheet(stname);
		System.out.println("SheetName: "+stname);
		row = sheet.getRow(irow);
		int rowcount = row.getLastCellNum();
		System.out.println("No of rows: "+rowcount);
		cell = row.getCell(icol);
		cell.setCellType(1);
		String cellValue = sheet.getRow(irow).getCell(icol).getStringCellValue();
		System.out.println("row: "+irow +" colmn: "+icol+" - "+"value: "+cellValue);
	}
}



