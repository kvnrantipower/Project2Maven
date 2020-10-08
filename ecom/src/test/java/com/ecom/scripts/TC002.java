package com.ecom.scripts;

import org.testng.annotations.*;

import com.ecom.generic.ExcelLibrary;
import com.ecom.pages.HomePage;
import com.ecom.pages.LoginPage;

import junit.framework.Assert;

public class TC002 extends BaseTest{
	
	@BeforeMethod(alwaysRun=true)
	public void befMethod()
	{
		
	}
	
	@DataProvider(name="credentials")
	public Object[][] loginCredentials()
	{
		return ExcelLibrary.getAllData(EXCEL_PATH, "Sheet1");
	}
	
	@Test(dataProvider="credentials",description="Verifying invalid login")
	public void invaldLogin(String user,String pwd)
	{
		LoginPage lp=new LoginPage(driver, webaction);
		lp.login(user, pwd);
		Assert.assertEquals(true, lp.verifyErrorMsg());
	}
	
	@AfterMethod(alwaysRun=true)
	public void aftMethod()
	{
		driver.navigate().to(DEFAULT_URL);
	}
	
}
