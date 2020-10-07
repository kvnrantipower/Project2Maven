package com.ecom.scripts;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import com.ecom.generic.AutoConstants;

public class BaseTest implements AutoConstants {
	WebDriver driver;
	
	@Parameters({"brow"})
	@BeforeClass(alwaysRun=true)
	public  void setProperty(@Optional("chrome") String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_PATH);
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(FIREFOX_KEY, FIREFOX_PATH);
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty(EDGE_KEY, EDGE_PATH);
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void befMethod()
	{
		driver.get("https://www.google.co.in/");
	}
	
	@AfterMethod(alwaysRun=true)
	public void aftMethod()
	{
		driver.navigate().to("https://www.google.co.in/");
	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowsers()
	{
		driver.quit();
	}
}
