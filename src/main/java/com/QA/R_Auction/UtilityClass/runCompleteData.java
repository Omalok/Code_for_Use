package com.QA.R_Auction.UtilityClass;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class runCompleteData {
	static HSSFWorkbook workbook;
	static HSSFSheet sheet;
	static HSSFRow row;
	static HSSFCell cell;
	static int count=0;
	public static void main(String[] args) {
		try {
			File file1 = new File("D:\\MySeleniumProject\\p1109\\ExcelData\\TestData.xlsx");
			File file = new File("D:\\MySeleniumProject\\p1109\\ExcelData\\TestDataxlsFormat.xls");
			FileInputStream fis = new FileInputStream(file);		
			workbook = new HSSFWorkbook(fis);
			String sheetName = workbook.getSheetName(0);
			System.out.println("SheetName: "+sheetName);
		}catch(Exception e)
		{
			System.out.println("Error: "+e);
		}
		System.out.println("Total no of sheets: "+workbook.getNumberOfSheets());
		String sheetName = workbook.getSheetName(0);
		sheet=workbook.getSheet(sheetName);
	
		int rowCount= sheet.getRow(0).getLastCellNum();
		System.out.println("rowCount: "+rowCount);		
	/*	If Excel sheet has multiple rows and columns, in that time how can I take 
		particular row and column
		
		for(int i=0;i< =rowCount;i++)
		{ 
			for(int i=0;i<=colCount;i++)
			{ } 
			}*/	
		for (int i = 0; i < rowCount; i++) {			
			for (int j = 0; j <sheet.getRow(i).getLastCellNum(); j++) {
				
				
				cell= sheet.getRow(i).getCell(j);
				cell.setCellType(1);
				String cellValue = cell.getStringCellValue();
				System.out.println(cellValue);
			}
			count++;
			System.out.println("\n"+count);
		}
	}
}