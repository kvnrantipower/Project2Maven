package com.ecom.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ecom.generic.WebActionUtil;

public class OrderDetailsPage extends BasePage {

	public OrderDetailsPage(WebDriver driver,WebActionUtil webaction)
	{
		super(driver,webaction);
	}
	
	@FindBy(xpath="//table[@id='cart_summary']/tbody/tr")
	private List<WebElement> productList;
	
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
}
