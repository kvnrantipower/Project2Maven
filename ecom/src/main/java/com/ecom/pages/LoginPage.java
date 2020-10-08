package com.ecom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ecom.generic.WebActionUtil;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver, WebActionUtil webaction) {
		super(driver, webaction);
	}
	
	//Elements
	@FindBy(partialLinkText="Sign in")
	private WebElement signInLink;
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="SubmitLogin")
	private WebElement login;
	
	@FindBy(xpath="//div[@class='alert alert-danger' and not(@id='create_account_error')]")
	private WebElement errorMessage;
	
	@FindBy(linkText="Forgot your password?")
	private WebElement forgotPassword;
	
	//Methods
	public HomePage login(String user,String pwd)
	{
		webaction.click(signInLink);
		webaction.sendKeys(userName, user);
		webaction.sendKeys(password, pwd);
		webaction.click(login);
		return new HomePage(driver, webaction);
	}
	
	public boolean verifyErrorMsg()
	{
		return webaction.verifyElement(errorMessage);
	}
	
}
