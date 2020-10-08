package com.ecom.scripts;

import com.ecom.generic.AutoConstants;
import com.ecom.generic.ExcelLibrary;

public class VerifyingDataProvider implements AutoConstants {

	public static void main(String[] args) {
		
		Object[][] obj = ExcelLibrary.getAllData(path, "up");
		
		for(int i=0;i<obj.length;i++)
		{
			for(int j=0;j<obj[i].length;j++)
			{
				System.out.print(obj[i][j]+" ");
			}
			System.out.println();
		}
//		String val=ExcelLibrary.getCellData(EXCEL_PATH, "TC001", 1, 0);
//		System.out.println(val);

	}

}
