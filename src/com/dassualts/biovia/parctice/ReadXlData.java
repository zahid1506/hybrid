package com.dassualts.biovia.parctice;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dassualts.biovia.generic_lib.Xls_Reader;



//import zanmi.hybrid.generic.Xls_Reader;

public class ReadXlData {

	// 2003 --> abc.xls
	// 2007 and above --> abc.xlsx
	
	// class1 --> xls --> HSSFWorkbook
	// class2 --> xlsx --> XSSFWorkbook
	
	
	public static void main(String[] args) throws IOException 
	{
		/*Workbook wb = new XSSFWorkbook("D:\\workspace\\HyBridFramework_Dec12\\src\\com\\dassualts\\biovia\\dataset\\AutomatedTests.xlsx");
			
		Sheet sh = wb.getSheet("Login");
		
		Row row = sh.getRow(1);
		
		Cell cell = row.getCell(3);
		System.out.println(cell.getStringCellValue());*/
		
		
		
		
		
		
		
		String path = "D:\\workspace\\HyBridFramework_Dec12\\src\\com\\dassualts\\biovia\\dataset\\AutomatedTests.xlsx";
		
		Xls_Reader xls = new Xls_Reader(path);
		
		int rows = xls.getRowCount("Login");
		int cols = xls.getColumnCount("Login");
		
		String value = xls.getCellData("Login", 3, 1);
		
		System.out.println("Rows -->" + rows);
		System.out.println("cols -->" + cols);
		
		System.out.println(value);
		
		/*for (int i = 1; i <= rows; i++) 
		{
			System.out.println(i + "-->Row Started=============");
			System.out.println();
			for (int j = 0; j < cols; j++) {
				System.out.print(xls.getCellData("CreateUser", j, i) + "---");
				
			}
			System.out.println();
			System.out.println(i + "-->Row End=============");
			
		}*/
		
	}

}
