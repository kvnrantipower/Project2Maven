package com.ecom.generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileLibrary {

	public static String getValue(String filePath,String key)
	{
		try {
			FileInputStream propertyFile=new FileInputStream(filePath);
			Properties prop=new Properties();
			prop.load(propertyFile);
			return prop.getProperty(key);
			
		}
		catch(Exception e) {e.printStackTrace();}
		return null;
	}

}
