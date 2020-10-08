package com.ecom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ecom.generic.WebActionUtil;

public class BasePage {

	public WebDriver driver;
	public WebActionUtil webaction;
	
	public BasePage(WebDriver driver,WebActionUtil webaction)
	{
		this.driver=driver;
		this.webaction=webaction;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPresenseOfElement(WebElement elem)
	{
		 return webaction.verifyElement(elem);
	}
}
