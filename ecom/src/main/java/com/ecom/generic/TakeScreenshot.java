package com.ecom.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	
	public static String getScreenshot(WebDriver driver,String folderPath,String testCaseName)
	{
		
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationPath=folderPath+Utilities.getDate()+testCaseName+".png";
		
		File dest=new File(destinationPath);
		try {
			FileUtils.copyFile(src, dest);
			return destinationPath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
