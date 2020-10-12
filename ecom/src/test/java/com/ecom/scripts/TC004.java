package com.ecom.scripts;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecom.generic.ExcelLibrary;
import com.ecom.generic.Utilities;
import com.ecom.pages.CategoryPage;
import com.ecom.pages.HomePage;
import com.ecom.pages.OrderDetailsPage;
import com.ecom.pages.ProductDetailsPage;

public class TC004 extends BaseTest {

	@Test(description = "Verify Multiple Products Count Added to the cart ")
	public void multipleProductCount()
	{
		String menuName=ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 1,0);
		String productId=Utilities.doubleToIntString(ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 1,1));
		String quantity=Utilities.doubleToIntString(ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 1,2));
		String size=ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 1,3);
		String color=ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 1,4);
		
		HomePage hp=new HomePage(driver,webaction);
		CategoryPage cp = hp.selectMenu(menuName);
		ProductDetailsPage pdp = cp.selectProduct(productId);
		OrderDetailsPage odp = pdp.addProductToCart(quantity, size, color);
		
		menuName=ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 2,0);
		productId=Utilities.doubleToIntString(ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 2,1));
		quantity=Utilities.doubleToIntString(ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 2,2));
		size=ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 2,3);
		color=ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 2,4);
		
		cp = hp.selectMenu(menuName);
		pdp = cp.selectProduct(productId);
		odp = pdp.addProductToCart(quantity, size, color);
		
		menuName=ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 3,0);
		productId=Utilities.doubleToIntString(ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 3,1));
		quantity=Utilities.doubleToIntString(ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 3,2));
		size=ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 3,3);
		color=ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 3,4);
		
		cp = hp.selectMenu(menuName);
		pdp = cp.selectProduct(productId);
		odp = pdp.addProductToCart(quantity, size, color);
		
		Assert.assertEquals(odp.countAddedProducts(),Utilities.stringToInt(ExcelLibrary.getCellData(EXCEL_PATH, "TC004", 5,1)));
	}
}
