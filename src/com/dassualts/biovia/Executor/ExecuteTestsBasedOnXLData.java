package com.dassualts.biovia.Executor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.dassualts.biovia.generic_lib.Xls_Reader;
import com.dassualts.biovia.projectSpecific.CompareTime;
import com.dassualts.biovia.selenium_core.ActionDriver;

public class ExecuteTestsBasedOnXLData extends ActionDriver
{
	public Properties or;
	public CompareTime comparetime;
	
	public ExecuteTestsBasedOnXLData(WebDriver driver)
	{
		super(driver);

		or = new Properties();
		
		File file = new File("./src/com/dassualts/biovia/uimap_ObjectRepository/OR.properties");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			
			or.load(fis);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("loading the config file is successful");
		
		comparetime = new CompareTime();
	}
	
	public enum actionsOfActionDriver
	{
		input,
		click,
		selectBasedVisibleText,
		mouseHower,
		assertElementPresence,
		IsDisplayedFlightTimeIsCorrect
	}
	
	public void ReadDataFromXLAndTriggerActionsInActionDriver(String sheetName)
	{
				
		String path = "D:\\workspace\\HyBridFramework_Dec12\\src\\com\\dassualts\\biovia\\dataset\\AutomatedTests.xlsx";
		Xls_Reader xls = new Xls_Reader(path);
		
		int rows = xls.getRowCount(sheetName);
		int cols = xls.getColumnCount(sheetName);
		
		// reading data from 2nd row 
		
		for (int i = 2; i <= rows; i++) 
		{
			
			String flag = xls.getCellData(sheetName, 0, i);
			String action = xls.getCellData(sheetName, 1, i); // input
			String element = xls.getCellData(sheetName, 2, i); // depatureFieldTxtHome_xpath
			String elementDescription = xls.getCellData(sheetName, 3, i);
			String value = xls.getCellData(sheetName, 4, i);
			String verifyText = xls.getCellData(sheetName, 5, i);
			
			
			
			try {
				float f = Float.parseFloat(value);
				value = String.valueOf((int)f);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("flag -->" + flag);
			System.out.println("action -->" + action);
			System.out.println("element -->" + element);
			System.out.println("elementDescription -->" + elementDescription);
			System.out.println("value -->" + value);
			System.out.println("verifyText -->" + verifyText);
			System.out.println("==================================================================");
			
			String locatorValue = or.getProperty(element);
			
			// depatureFieldTxtHome_xpath
			String[] s1 = element.split("_");
			//s1[0] = depatureFieldTxtHome
			// s1[1] = xpath
			String locator = "";
			if(s1.length > 1)
			{
				locator = s1[1];
			}
			
			
			if(flag.equalsIgnoreCase("yes"))
			{
				switch (actionsOfActionDriver.valueOf(action)) 
				{
					case input:
						input(locator, locatorValue, value);
						break;
						
					case click:
						click(locator, locatorValue);
						break;
	
	
					case selectBasedVisibleText:
						//value = value.substring(0, value.length() - 2);
						selectBasedVisibleText(locator, locatorValue, value);
						
						break;
						
					case assertElementPresence:
						assertElementPresence(locator, locatorValue);
						break;
						
					case IsDisplayedFlightTimeIsCorrect:
						List<String> timeOfFlights = getElementsText(locator, locatorValue);
						comparetime.IsDisplayedFlightTimeIsCorrect(timeOfFlights);
						
						break;
					default:
						break;
				}
			}
			
		}
		
		
	}
	
	public static void main(String[] args)
	{
		/*;
		ExecuteTestsBasedOnXLData ex = new ExecuteTestsBasedOnXLData(driver);
		ex.ReadDataFromXLAndTriggerActionsInActionDriver("SearchFlight");
		*/
	}
	
}
