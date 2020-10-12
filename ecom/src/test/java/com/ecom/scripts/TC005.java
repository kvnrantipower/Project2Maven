package com.ecom.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.generic.ExcelLibrary;
import com.ecom.generic.Utilities;
import com.ecom.pages.CategoryPage;
import com.ecom.pages.HomePage;
import com.ecom.pages.OrderDetailsPage;
import com.ecom.pages.ProductDetailsPage;

public class TC005 extends BaseTest {
	
	@Test(description="Verifying right product right quantity,right size and color added in the kart")
	public void verifyingRightProductIsInTheKart()
	{
		String menuName=ExcelLibrary.getCellData(EXCEL_PATH, "TC005", 1,0);
		String productId=Utilities.doubleToIntString(ExcelLibrary.getCellData(EXCEL_PATH, "TC005", 1,1));
		String quantity=Utilities.doubleToIntString(ExcelLibrary.getCellData(EXCEL_PATH, "TC005", 1,2));
		String size=ExcelLibrary.getCellData(EXCEL_PATH, "TC005", 1,3);
		String color=ExcelLibrary.getCellData(EXCEL_PATH, "TC005", 1,4);
		
		HomePage hp=new HomePage(driver,webaction);
		CategoryPage cp = hp.selectMenu(menuName);
		ProductDetailsPage pdp = cp.selectProduct(productId);
		OrderDetailsPage odp = pdp.addProductToCart(quantity, size, color);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(odp.verifyProductAddedToCart(productId), true);
		String expectedProperty="Color : "+color+", Size : "+size;
		sa.assertEquals(odp.getProperties(productId), expectedProperty);
		sa.assertEquals(odp.getQuantity(productId), quantity);
		sa.assertAll();
		
	}
}
//Color : Orange, Size : M