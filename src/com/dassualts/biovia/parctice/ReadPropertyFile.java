package com.dassualts.biovia.parctice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile 
{

	// D:\workspace\HyBridFramework_Dec12\src\com\dassualts\biovia\config\config.properties
	
	public static void main(String[] args) throws IOException 
	{
		Properties config = new Properties();
		
		File file = new File("./src/com/dassualts/biovia/config/config.properties");
		
		FileInputStream fis = new FileInputStream(file);
		
		config.load(fis);
		
		String browser1 = config.getProperty("browser");
		String url1 = config.getProperty("url");
		
		System.out.println("Browser value -->" + browser1);
		System.out.println("url value -->" + url1);
		

	}

}
