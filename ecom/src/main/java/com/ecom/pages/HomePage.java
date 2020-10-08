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
	
	public LoginPage logOut()
	{
		webaction.click(signOut);
		return new LoginPage(driver, webaction);
	}
	
	public boolean verifyPresenseOfSignOut()
	{
		 return webaction.verifyElement(signOut);
	}

	

}
