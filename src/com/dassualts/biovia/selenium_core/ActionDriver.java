package com.dassualts.biovia.selenium_core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ActionDriver 
{
	WebDriver driver;
	public static Logger log = Logger.getLogger("ActionDriver");
	FluentWait<WebDriver> wait;
	
	public ActionDriver(WebDriver d)
	{
		driver = d;
		
		wait = new FluentWait<WebDriver>(driver)
				.pollingEvery(5, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(WebDriverException.class)
				.ignoring(InvalidSelectorException.class);
	}
	
	// locator --> xpath, id , css, linkText
	// locatorValue --> //a[@id='009'] , 009, #009, abc
	
	public enum locatorName
	{
		xpath,
		id,
		css,
		linkText,
		partialLinkText,
		name,
		className,
		tagName
	}
	
	public WebElement findElement(String locator, String locatorValue)
	{
		WebElement elm;
		log.info("Finding an element with locator -->" + locator + " and locator value -->" + locatorValue);
		
		try {
			switch (locatorName.valueOf(locator)) 
			{
				case xpath:
					log.info("Finding an element based on xpath");
					elm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
					log.info("Element found based on xpath");
					break;
				
				case id:
					log.info("Finding an element based on id");
					elm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
					log.info("Element found based on id");
					break;
				case name:
					log.info("Finding an element based on name");
					elm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
					log.info("Element found based on name");
					break;
				case className:
					elm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
					break;
				case tagName:
					elm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
					break;
				case linkText:
					elm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
					break;
				case partialLinkText:
					elm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
					break;

				default:
					System.out.println("you passed invalid locator");
					return null;
			}
		} 
		catch (IllegalArgumentException e) 
		{
			elm = null;
			System.out.println("You passed invalid locator instead of any one among 8 locators");
			System.out.println(e.getMessage());
			log.info("You passed invalid locator instead of any one among 8 locators");
		}
		catch(WebDriverException ex)
		{
			elm = null;
			System.out.println(ex.getMessage());
			System.out.println("Unable to find an element with the locatorvalue -->" + locatorValue);
			log.info("Unable to find an element with the locatorvalue -->" + locatorValue);
		}
		return elm;
		
	}
		

	public List<WebElement> findElements(String locator, String locatorValue)
	{
		List<WebElement> elm;
		log.info("Finding an element with locator -->" + locator + " and locator value -->" + locatorValue);
		
		try {
			switch (locatorName.valueOf(locator)) 
			{
				case xpath:
					log.info("Finding an element based on xpath");
					elm = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorValue)));
					log.info("Element found based on xpath");
					break;
				
				case id:
					log.info("Finding an element based on id");
					elm = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locatorValue)));
					log.info("Element found based on id");
					break;
				case name:
					log.info("Finding an element based on name");
					elm = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locatorValue)));
					log.info("Element found based on name");
					break;
				case className:
					elm = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(locatorValue)));
					break;
				case tagName:
					elm = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName(locatorValue)));
					break;
				case linkText:
					elm = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(locatorValue)));
					break;
				case partialLinkText:
					elm = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText(locatorValue)));
					break;

				default:
					System.out.println("you passed invalid locator");
					return null;
			}
		} 
		catch (IllegalArgumentException e) 
		{
			elm = null;
			System.out.println("You passed invalid locator instead of any one among 8 locators");
			System.out.println(e.getMessage());
			log.info("You passed invalid locator instead of any one among 8 locators");
		}
		catch(WebDriverException ex)
		{
			elm = null;
			System.out.println(ex.getMessage());
			System.out.println("Unable to find an element with the locatorvalue -->" + locatorValue);
			log.info("Unable to find an element with the locatorvalue -->" + locatorValue);
		}
		return elm;
		
	}
	
	public List<String> getElementsText(String locator, String locatorValue)
	{
		List<String> textOfElements = new ArrayList<String>();
		
		for (WebElement elm : findElements(locator, locatorValue)) 
		{
			textOfElements.add(elm.getText());
		}
		
		return textOfElements;
	}
	
	public void click(String locator, String locatorValue)
	{
		log.info("In click method");
		log.info("Calling find element");
		WebElement elm1 = findElement(locator, locatorValue);
		if(elm1 != null)
		{
			elm1.click();
			log.info("click is successful");
		}
		else
		{
			System.out.println("Not able to click on element as it is not found");
			log.info("Not able to click on element as it is not found");
		}
	}
	
	public void input(String locator, String locatorValue, String textToEnter)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("In input method");
		WebElement elm1 = findElement(locator, locatorValue);
		if(elm1 != null)
		{
			elm1.sendKeys(textToEnter);
			log.info("entering an text is successful");
		}
		else
		{
			System.out.println("not able to enter a text into an element as it is not found");
			log.info("not able to enter a text into an element as it is not found");
		}
	}

	public void selectBasedVisibleText(String locator, String locatorValue, String dropDownVisibleText)
	{
		log.info("In selectBasedVisibleText method");
		log.info("Calling find element");
		WebElement elm1 = findElement(locator, locatorValue);
		if(elm1 != null)
		{
			Select select = new Select(elm1);
			select.selectByVisibleText(dropDownVisibleText);
		}
		else
		{
			System.out.println("Not able to select visbile text in the select box as it is not found");
			log.info("Not able to select visbile text in the select box as it is not found");
		}
	}
	
	public void mouseHower(String locator, String locatorValue)
	{
		log.info("In mouseHower method");
		log.info("Calling find element");
		WebElement elm1 = findElement(locator, locatorValue);
		if(elm1 != null)
		{
			Actions action = new Actions(driver);
			action.moveToElement(elm1).build().perform();
		}
		else
		{
			System.out.println("Not able to move mouse on as element as it is not found");
			log.info("Not able to move mouse on as element as it is not found");
		}
	}
	
	public void assertElementPresence(String locator, String locatorValue)
	{
		log.info("In assert method");
		log.info("Calling find element");
		WebElement elm1 = findElement(locator, locatorValue);
		if(elm1 == null)
		{
			System.out.println("Assert failed as there is no element present");
			log.info("Assert failed as there is no element present");
			Assert.assertTrue(elm1 != null, "No element found");
		}
		
	}
}
