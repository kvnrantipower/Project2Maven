package com.ecom.scripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecom.generic.ExcelLibrary;
import com.ecom.pages.LoginPage;

import junit.framework.Assert;

public class TC007 extends BaseTest {
	
	@BeforeMethod(alwaysRun=true)
	public void befMethod()
	{
		
	}
	
	@Test(description="Functional tests on registration email text field")
	public void ftOnRegEmail() throws InterruptedException 
	{
		LoginPage lp = new LoginPage(driver, webaction);
		String email= ExcelLibrary.getCellData(EXCEL_PATH, "TC007", 1, 0);
		lp.enterRegMail(email);
		
		lp.clickCreateAnAccount();
		Assert.assertEquals(true,lp.verifyCreateAccountErrorNotDisplayed());
	}
	
	@AfterMethod(alwaysRun=true)
	public void aftMethod()
	{
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
	
	@DataProvider(name="negativeInputs")
	public Object[] invalidInputs()
	{
		return ExcelLibrary.getAllSingleColoumnData(EXCEL_PATH, "TC007", 2);
	}
	
	@Test(dataProvider="negativeInputs",description="Negative Functional tests on registration email text field")
	public void negativeFtOnRegEmail(String email) 
	{
		LoginPage lp = new LoginPage(driver, webaction);
		lp.enterRegMail(email);
		lp.clickCreateAnAccount();
		Assert.assertEquals(true,lp.verifyCreateAccountErrorDisplayed());
	}
}
