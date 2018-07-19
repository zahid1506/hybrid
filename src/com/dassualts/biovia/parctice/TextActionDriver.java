package com.dassualts.biovia.parctice;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.dassualts.biovia.selenium_core.ActionDriver;

public class TextActionDriver {

	public static Logger log = Logger.getLogger("TextActionDriver");
	
	@Test
	public void testCase1() 
	{

		BasicConfigurator.configure();
		DOMConfigurator.configure("Log4j.xml");
		
		log.info("Welcome to log generation");
		log.info("Log is initialized");
		
		System.setProperty("webdriver.firefox.marionette", "D:\\Selenium\\jar2\\geckodriver-v0.19.1-win32\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		log.info("opening a browser and maximizing is done");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		log.info("setting an implicit wait is done");
		driver.get("http://gmail.com");
		log.info("url is loaded is done");
		
		ActionDriver actDriver = new ActionDriver(driver);
		log.info("Action driver object is created");
		
		
		actDriver.input("id", "identifierId", "ashoktalur");
		actDriver.click("id", "identifierNext");
		actDriver.input("xpath", "//input[@name='password']", "hjghjghjg");
		actDriver.assertElementPresence("id", "passwordNext123");
		

	}

}
