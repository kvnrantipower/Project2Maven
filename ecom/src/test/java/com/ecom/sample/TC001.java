package com.ecom.sample;

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class TC001 extends BaseTest{
	
	@Test
	public void Test1()
	{
		driver.findElement(By.name("q")).sendKeys("Test1");
		try 
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{}
	}
	
	@Test(description="")
	public void Test2()
	{
		driver.findElement(By.name("q")).sendKeys("Test2");
		try 
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{}
	}
}
