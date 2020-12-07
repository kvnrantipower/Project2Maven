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
	
	@FindBy(id="email_create")
	WebElement eMailReg;
	
	@FindBy(id="SubmitCreate")
	WebElement createAnAccount;
	
	@FindBy(id="create_account_error")
	WebElement createAccountError;
	
	//Methods
	public HomePage login(String user,String pwd)
	{
		webaction.click(signInLink);
		webaction.sendKeys(userName, user);
		webaction.sendKeys(password, pwd);
		webaction.click(login);
		return new HomePage(driver, webaction);
	}
	
	public void enterRegMail(String email)
	{
		webaction.sendKeys(eMailReg, email); 
	}
	
	
	public boolean verifyErrorMsg()
	{
		return webaction.verifyElement(errorMessage);
	}
	
	public RegistrationPage clickCreateAnAccount()
	{
		webaction.click(createAnAccount);
		return new RegistrationPage(driver, webaction);
	}
	
	public boolean verifyCreateAccountErrorDisplayed()
	{
		return webaction.verifyElement(createAccountError);
	}
	
	public boolean verifyCreateAccountErrorNotDisplayed()
	{
		return webaction.verifyNoElement(createAccountError);
	}
	
}
