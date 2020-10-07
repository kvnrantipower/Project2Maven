package com.ecom.scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC002 extends BaseTest {

	@Test
	public void Test3()
	{
		driver.findElement(By.name("q")).sendKeys("Test3");
		try 
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{}
	}
	
	@Test
	public void Test4()
	{
		driver.findElement(By.name("q")).sendKeys("Test4");
		try 
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{}
	}

}
