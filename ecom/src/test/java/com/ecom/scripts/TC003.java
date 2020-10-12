package com.ecom.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecom.generic.ExcelLibrary;
import com.ecom.generic.Utilities;
import com.ecom.pages.CategoryPage;
import com.ecom.pages.HomePage;
import com.ecom.pages.OrderDetailsPage;
import com.ecom.pages.ProductDetailsPage;

public class TC003 extends BaseTest {

	@Test(description = "Test case to add a product in the cart by selecting quantity,size,color")
	public void addToCartMethod()
	{
		String menuName=ExcelLibrary.getCellData(EXCEL_PATH, "TC003", 1,0);
		String productId=Utilities.doubleToIntString(ExcelLibrary.getCellData(EXCEL_PATH, "TC003", 1,1));
		String quantity=Utilities.doubleToIntString(ExcelLibrary.getCellData(EXCEL_PATH, "TC003", 1,2));
		String size=ExcelLibrary.getCellData(EXCEL_PATH, "TC003", 1,3);
		String color=ExcelLibrary.getCellData(EXCEL_PATH, "TC003", 1,4);
		
		HomePage hp=new HomePage(driver,webaction);
		CategoryPage cp = hp.selectMenu(menuName);
		ProductDetailsPage pdp = cp.selectProduct(productId);
		OrderDetailsPage odp = pdp.addProductToCart(quantity, size, color);
		Assert.assertEquals(odp.verifyProductAddedToCart(productId), true);
	}
}
