package com.ecom.generic;

import java.time.LocalDateTime;

public class Utilities {
	
//Method to Sleep	
	public static void sleep(long timeInSeconds)
	{
		try {
			Thread.sleep(timeInSeconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//Method to Convert String to int
	public static int stringToInt(String numberFromExcel)
	{
		try {
		int num=Integer.parseInt(numberFromExcel.split("\\.")[0]);
		return num;
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
			return (Integer) null;
		}
	}
	
//Method to Convert String Double to String Integer
	public static String doubleToIntString(String numberFromExcel)
	{
		String num=Integer.toString(stringToInt(numberFromExcel));
		return num;
	}
	
//Method to get Date in the String format
	public static String getDate()
	{
			LocalDateTime day = LocalDateTime.now();
			String date=day.toString().replace(':', '-');
			return date;
	}
}
