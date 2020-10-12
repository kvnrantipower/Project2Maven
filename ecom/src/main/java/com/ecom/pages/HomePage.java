package com.ecom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ecom.generic.WebActionUtil;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver, WebActionUtil webaction) {
		super(driver, webaction);
	}
	
	@FindBy(partialLinkText="Sign out")
	private WebElement signOut;
	
	@FindBy(linkText="Women")
	private WebElement womenMenu;
	
	@FindBy(xpath="(//a[text()='Dresses'])[2]")
	private WebElement dressesMenu;
	
	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	private WebElement tshirtMenu;
	
	
	public LoginPage logOut()
	{
		webaction.click(signOut);
		return new LoginPage(driver, webaction);
	}
	
	public boolean verifyPresenseOfSignOut()
	{
		 return webaction.verifyElement(signOut);
	}
	
	public CategoryPage selectMenu(String menuName)
	{
		menuName=menuName.toLowerCase();
		
		switch(menuName)
		{
			case "women":webaction.click(womenMenu);	
							break;
			case "dresses":webaction.click(dressesMenu);
							break;
			case "t-shirts":webaction.click(tshirtMenu);
							break;
		}
		return new CategoryPage(driver,webaction);
	}

	

}
