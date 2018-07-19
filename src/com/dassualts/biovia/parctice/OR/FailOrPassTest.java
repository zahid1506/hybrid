package com.dassualts.biovia.parctice.OR;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FailOrPassTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	
	@Test
	public void TestCase1() throws InterruptedException, IOException 
	{
		// Firefox FirefoxDriver --> 
		
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\jar2\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		System.setProperty("webdriver.firefox.marionette", "D:\\Selenium\\jar2\\geckodriver-v0.19.1-win32\\geckodriver.exe");
		//System.setProperty("webdriver.firefox.marionette", "D:\\Selenium\\jar2\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Jars\\geckodriver-v0.19.1-win32\\geckodriver.exe");
		//System.setProperty("webdriver.firefox.marionette", "D:\\Selenium\\Jars\\geckodriver-v0.19.1-win32\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.get("http://gmail.com");
		
		Properties or = new Properties();
		
		File file = new File("./src/com/dassualts/biovia/uimap_ObjectRepository/OR.properties");
		
		FileInputStream fis = new FileInputStream(file);
		
		or.load(fis);
		
		
		
		
		WebElement emailIdField = driver.findElement(By.id(or.getProperty("userNameTxtLogin_id")));
		
		emailIdField.sendKeys("Ashoktalur");
		
		
		/*WebElement nextBtn = driver.findElement(By.id("identifierNext"));
		
		nextBtn.click();*/
		
		driver.findElement(By.id(or.getProperty("nextBtnLogin_id"))).click();
		
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath(or.getProperty("passwordTxtLogin_xpath"))).sendKeys("jgghjfhjf");
		
		driver.findElement(By.id(or.getProperty("passwordNextBtnLogin_id"))).click();
		
		//Thread.sleep(2000);
		
		WebElement elm = null;
		
		try 
		{
			elm = driver.findElement(By.xpath(or.getProperty("errorMessageLogin_xpath")));
			
		} catch (NoSuchElementException e) 
		{
			System.out.println("No error message is displayed");
			Assert.assertTrue(elm != null, "No error message is displayed");
		}
		
		
			
		
		
		
	}

}
