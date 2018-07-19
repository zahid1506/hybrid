package com.dassualts.biovia.testScripts.testBed;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBed {
	
	// logs
	// config
	// browser
	// load url
	
	public static Logger log = Logger.getLogger("TestBed");
	public Properties config;
	public WebDriver driver;
	
	public enum Browsers
	{
		firefox,
		ie,
		chrome
	}
	
	@BeforeSuite
	public void InitilizeLogs() throws IOException
	{
		// logs
		BasicConfigurator.configure();
		DOMConfigurator.configure("Log4j.xml");
		
		log.info("Welcome to log generation");
		log.info("Log is initialized");
		
		// config
		log.info("loading the config file");
		config = new Properties();
		
		File file = new File("./src/com/dassualts/biovia/config/config.properties");
		
		FileInputStream fis = new FileInputStream(file);
		
		config.load(fis);
		log.info("loading the config file is successful");
	}
	
	@BeforeTest
	public void openBrowser()
	{
		String browser = config.getProperty("browser");
		String url = config.getProperty("url");
		
		log.info("Reading the browser value -->" + browser + " and reading the url-->" + url);
		
		switch(Browsers.valueOf(browser))
		{
		case firefox:
			log.info("loading the firefox");
			System.setProperty("webdriver.firefox.marionette", "D:\\Selenium\\jar2\\geckodriver-v0.19.1-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("firefox browser is opened");
			break;
			
		case ie:
			log.info("loading the IE");
			System.setProperty("webdriver.ie.driver","D:\\Selenium\\Jars\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.info("IE browser is opened");
			break;
			
		case chrome:
			log.info("loading the Chrome");
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chrome browser is opened");
			break;
		}
		
		log.info("Maximizing and setting the implicit wait");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("url is loading");
		driver.get(url);
		log.info("url loading is done");
	}

	@AfterTest
	public void tearDown()
	{
		if (driver != null)
		{
			log.info("browser is closing");
			driver.quit();
			log.info("browser is closed");
		}
	}
	
}
