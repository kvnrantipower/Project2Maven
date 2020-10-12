package com.ecom.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ecom.generic.WebActionUtil;

public class OrderDetailsPage extends BasePage {

	public OrderDetailsPage(WebDriver driver,WebActionUtil webaction)
	{
		super(driver,webaction);
	}
	
	String xpathForQuantity="//table[@id='cart_summary']/tbody/tr[contains(@id,'product_pid')]"
			                 + "/td[@class='cart_quantity text-center']/input[@type='hidden']";
	
	@FindBy(xpath="//table[@id='cart_summary']/tbody/tr")
	private List<WebElement> productList;
	
	@FindBy(xpath="//table[@id='cart_summary']/tbody/tr/td[@class='cart_description']/small/a")
	private List<WebElement> propertyList;
	
	public boolean verifyProductAddedToCart(String productId)
	{
		productId="product_"+productId;
		for(WebElement product:productList)
		{
			if(product.getAttribute("id").contains(productId))
			{
				return true;
			}
		}
		return false;
	}
	
	public int countAddedProducts()
	{
		return productList.size();
	}
	public String getProperties(String productId)
	{
		productId="id_product="+productId;
		for(WebElement property:propertyList)
		{
			if(property.getAttribute("href").contains(productId))
			{
				return property.getText();
			}
		}
		return null;
	}
	public String getQuantity(String productId)
	{
		xpathForQuantity=xpathForQuantity.replace("pid", productId);
		return driver.findElement(By.xpath(xpathForQuantity)).getAttribute("value");
	}
}







