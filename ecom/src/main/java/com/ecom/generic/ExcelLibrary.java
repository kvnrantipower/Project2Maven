package com.ecom.generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {

	public static  String getCellData(String excelFilePath,String sheetName,int rowNumber,int colNumber)
	{
		try {
		File path=new File(excelFilePath);
		Workbook wb = WorkbookFactory.create(path);
		Sheet sh = wb.getSheet(sheetName);
		return sh.getRow(rowNumber).getCell(colNumber).toString();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object[][] getAllData(String excelFilePath,String sheetName)
	{
		Object obj[][]=null;
		try {
			FileInputStream path=new FileInputStream(excelFilePath);
			Workbook wb = WorkbookFactory.create(path);
			Sheet sh = wb.getSheet(sheetName);
			int rowCount = sh.getPhysicalNumberOfRows();
			obj=new Object[rowCount-1][];
			for(int i=1,k=0;i<rowCount;i++,k++)
			{
				int cellCount = sh.getRow(i).getPhysicalNumberOfCells();
				obj[k]=new Object[cellCount];
				for(int j=0;j<cellCount;j++)
				{
					obj[k][j]=sh.getRow(i).getCell(j).toString();
				}
			}
		}catch(Exception e)
		{e.printStackTrace();}
		return obj;
	}
	public static Object[] getAllSingleColoumnData(String excelFilePath,String sheetName,int startingRow)
	{
		
		try {
			FileInputStream path=new FileInputStream(excelFilePath);
			Workbook wb=WorkbookFactory.create(path);
			Sheet sh=wb.getSheet(sheetName);
			Object[] obj=new Object[sh.getPhysicalNumberOfRows()-startingRow];
			for(int i=0,j=startingRow;j<sh.getPhysicalNumberOfRows();i++,j++)
			{
				obj[i]=sh.getRow(j).getCell(0).toString();
				
			}
			
			return obj;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	public static Object[] getAllSingleRowData(String excelFilePath,String sheetName,int startingCell)
	{
		
		try {
		FileInputStream fis = new FileInputStream(excelFilePath); 
		Sheet sh=WorkbookFactory.create(fis).getSheet(sheetName);
		Object[] obj=new Object[sh.getRow(1).getPhysicalNumberOfCells()-startingCell];
		for(int i=0,j=startingCell;i<sh.getRow(0).getPhysicalNumberOfCells();i++)
		{
			obj[i]=sh.getRow(0).getCell(j).toString();
			
		}
		return obj;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

}
