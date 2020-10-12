package com.ecom.scripts;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;


import com.ecom.generic.AutoConstants;
import com.ecom.generic.WebActionUtil;
import com.ecom.pages.HomePage;
import com.ecom.pages.LoginPage;

public class BaseTest implements AutoConstants {
	public WebDriver driver;
	public WebActionUtil webaction;
	@Parameters({"brow","implicit","explicit"})
	@BeforeClass(alwaysRun=true)
	public  void setProperty(@Optional("firefox") String browser,@Optional(IT) String it,@Optional(ET) String et)
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
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty(IE_KEY, IE_PATH);
			driver=new InternetExplorerDriver();
		}
		webaction=new WebActionUtil(driver, Long.parseLong(et));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(it), TimeUnit.SECONDS);
		driver.get(DEFAULT_URL);
		driver.findElement(By.partialLinkText("Sign in"));
	}
	
	@BeforeMethod(alwaysRun=true)
	public void befMethod()
	{
		LoginPage lp=new LoginPage(driver, webaction);
		lp.login(DEFAULT_USERNAME, DEFAULT_PASSWORD);
	}
	
	@AfterMethod(alwaysRun=true)
	public void aftMethod()
	{
		driver.navigate().to("http://automationpractice.com/index.php?controller=my-account");
		HomePage hp=new HomePage(driver, webaction);
		hp.logOut();
	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowsers()
	{
		driver.quit();
	}
}
