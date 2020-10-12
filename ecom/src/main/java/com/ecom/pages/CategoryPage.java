package com.ecom.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ecom.generic.WebActionUtil;

public class CategoryPage extends BasePage {
	
	public CategoryPage(WebDriver driver,WebActionUtil webaction)
	{
		super(driver,webaction);
	}
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li/div//a[@class='product_img_link']")
	private List<WebElement> productsList;
	
	public ProductDetailsPage selectProduct(String productId)
	{
		productId="id_product="+productId;
		for(WebElement product:productsList)
		{
			if(product.getAttribute("href").contains(productId))
			{
				webaction.jsClick(product);
				return new ProductDetailsPage(driver,webaction);
			}
		}
		return null;
	}
}
