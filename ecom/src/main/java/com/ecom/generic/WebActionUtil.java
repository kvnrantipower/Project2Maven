package com.ecom.generic;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtil {
		
		public WebDriver driver;
		public WebDriverWait wait;
		public Actions action;
		public JavascriptExecutor js;
		
		public WebActionUtil(WebDriver driver,long explicitWait)
		{
			this.driver=driver;
			wait=new WebDriverWait(driver, explicitWait);
			action=new Actions(driver);
			js=(JavascriptExecutor)driver;
		}
		
		//SendKeys Method
		public void sendKeys(WebElement elem,String value)
		{
			try {
			elem.clear();
			elem.sendKeys(value);
			}catch (Exception e)
			{
				js.executeScript("arguments[0].value='arguments[1]'", elem,value);
			}
		}
		
		//Click Method
		public void click(WebElement elem)
		{
			try {
				wait.until(ExpectedConditions.elementToBeClickable(elem)).click();
			}catch(Exception e)
			{
				js.executeScript("arguments[0].click();", elem);
			}
		}
		
		//To verify Presense of Element
		public boolean verifyElement(WebElement elem)
		{
			try {
			wait.until(ExpectedConditions.visibilityOf(elem));
			return elem.isDisplayed();
			}catch (Exception e) {
				
			}
			return false;
		}
		
		public boolean verifyNoElement(WebElement elem)
		{
			try {
				return wait.until(ExpectedConditions.invisibilityOf(elem));
		 
			}catch (Exception e) {
				
			}
			return false;
		}
		
		

	

}
