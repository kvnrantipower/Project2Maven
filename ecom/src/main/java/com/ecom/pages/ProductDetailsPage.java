package com.ecom.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.ecom.generic.WebActionUtil;

public class ProductDetailsPage extends BasePage {

	public ProductDetailsPage(WebDriver driver,WebActionUtil webaction)
	{
		super(driver,webaction);
	}
	
	@FindBy(xpath="//i[@class='icon-plus']")
	private WebElement quantityPlus;
	
	@FindBy(xpath="//i[@class='icon-minus']")
	private WebElement quantityMinus;
	
	@FindBy(id="quantity_wanted")
	private WebElement quantityInput;
	
	@FindBy(id="group_1")
	private WebElement sizeListBox;
	
	@FindBy(xpath="//ul[@id='color_to_pick_list']/li/a")
	private List<WebElement> colorListBox;
	
	@FindBy(id="add_to_cart")
	private WebElement addToCart;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckout;
	
	
	public void increaseQuantityTo(int quantity)
	{
		for(int i=1;i<quantity-1;i++)
		{
			webaction.click(quantityPlus);
		}
	}
	
	public void decreaseQuantityBy(int quantityDecreaseBy)
	{
		for(int i=1;i<=quantityDecreaseBy-1;i++)
		{
			webaction.click(quantityMinus);
		}
	}
	
	public void setQuantity(String quantity)
	{
		
		webaction.sendKeys(quantityInput, quantity);
	}
	
	public void selectSize(String size)
	{
		Select sizeSelect=new Select(sizeListBox);
		size=size.toUpperCase();
		sizeSelect.selectByVisibleText(size);
	}
	
	public void selectColor(String color)
	{
		for(WebElement colorElem:colorListBox)
		{
			if(colorElem.getAttribute("name").equals(color))
			{
				webaction.click(colorElem);
				break;
			}
		}
	}
	
	public OrderDetailsPage addProductToCart(String quantity,String size,String color)
	{
		setQuantity(quantity);
		selectSize(size);
		selectColor(color);
		webaction.click(addToCart);
		webaction.click(proceedToCheckout);
		return new OrderDetailsPage(driver,webaction);
	}
	
	
}


























