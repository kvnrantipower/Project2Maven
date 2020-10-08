package com.ecom.scripts;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.ecom.pages.HomePage;
import com.ecom.pages.LoginPage;

import junit.framework.Assert;

public class TC001 extends BaseTest{
	
	@Test(description="Verifying valid login")
	public void validLogin()
	{
		LoginPage lp=new LoginPage(driver, webaction);
		HomePage hp = lp.login(DEFAULT_USERNAME, DEFAULT_PASSWORD);
		Assert.assertEquals(true, hp.verifyPresenseOfSignOut());
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public void befMethod()
	{
		
	}
	
}
