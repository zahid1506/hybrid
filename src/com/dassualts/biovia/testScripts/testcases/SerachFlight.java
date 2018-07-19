package com.dassualts.biovia.testScripts.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dassualts.biovia.Executor.ExecuteTestsBasedOnXLData;
import com.dassualts.biovia.projectSpecific.CompareTime;
import com.dassualts.biovia.selenium_core.ActionDriver;
import com.dassualts.biovia.testScripts.testBed.TestBed;

public class SerachFlight extends TestBed
{
	
	public static Logger log = Logger.getLogger("LoginTest");
	
	
	
	public SerachFlight() throws IOException
	{
	}

	@Test
	public void searchFlight() throws InterruptedException
	{
		ExecuteTestsBasedOnXLData execute = new ExecuteTestsBasedOnXLData(driver);
		
		execute.ReadDataFromXLAndTriggerActionsInActionDriver("SearchFlight");
		
		// 1. open the browser
		// 2. load url
		// 3. Enter the from city
		// 4. Enter the To city
		// 5. Enter the adult field
		// 6. Enter the child field
		// 7. Click on Search
		// 8. verify the result
		
		/*log.info("started the SerachFlight test");
		log.info("Initialize the action driver class");
		ActionDriver actDriver = new ActionDriver(driver);
		
		actDriver.input("xpath", or.getProperty("depatureFieldTxtHome_xpath"), "BLR");
		Thread.sleep(1000);
		
		
		actDriver.input("xpath", or.getProperty("ArrivalFieldTxtHome_xpath"), "DEL");
		Thread.sleep(1000);
		//actDriver.click("xpath", or.getProperty("Date_xpath"));
		//Thread.sleep(1000);
		actDriver.selectBasedVisibleText("id", or.getProperty("AdultFieldSelectHome_id"), "2");
		actDriver.selectBasedVisibleText("xpath", or.getProperty("ChildFieldSelectHome_xpath"), "2");
		actDriver.click("id", or.getProperty("SearchFieldSubmitHome_id"));
		
		List<String> timeOfFlights = actDriver.getElementsText("xpath", or.getProperty("displayedTimedOfElements_xpath"));
		comparetime.IsDisplayedFlightTimeIsCorrect(timeOfFlights);*/
		
		
		/*
		Thread.sleep(1000);
		
		WebElement select = actDriver.finElementByNormalWay("xpath",  or.getProperty("AdultFieldSelectHome_xpath"));
		
		
		
		select.click();
		//executor.executeScript("arguments[0].focus();", elm2);
		//executor.executeScript("document.getElementById('ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT').focus();");
		//Thread.sleep(1000);
		actDriver.click("xpath", or.getProperty("Date_xpath"));
		
		//
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById('ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT').click();");
		((JavascriptExecutor)driver).executeScript("var select = document.getElementById('ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT'); for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[0]){ select.options[i].selected = true; } }",  "2");
		
		((JavascriptExecutor)driver).executeScript("var select = document.getElementById('ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD'); for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[0]){ select.options[i].selected = true; } }",  "2");
		
		//actDriver.selectBasedVisibleText("xpath", "ChildFieldSelectHome_xpath", "2");
		//actDriver.click("id", "SearchFieldSubmitHome_id");
		executor.executeScript("document.getElementById('ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit').click();");
		*/
		
		
		System.out.println("SerachFlight test is done");
		log.info("SerachFlight test is done");
	}

}
