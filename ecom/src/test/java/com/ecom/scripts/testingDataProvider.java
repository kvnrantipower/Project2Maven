package com.ecom.scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecom.generic.ExcelLibrary;
import com.ecom.pages.LoginPage;

import junit.framework.Assert;

public class testingDataProvider {
	
	String EXCEL_PATH="C:\\Users\\Dell\\git\\Project2MavenBranch\\ecom\\Resources\\DataPro.xlsx";
	
	@DataProvider(name="negativeInputs")
	public Object[] invalidInputs()
	{
		return ExcelLibrary.getAllSingleColoumnData(EXCEL_PATH, "TC007", 1);
	}
	
	@Test(dataProvider="negativeInputs",description="Negative Functional tests on registration email text field")
	public void negativeFtOnRegEmail(String email) 
	{
		System.out.println(email);
	}
}
