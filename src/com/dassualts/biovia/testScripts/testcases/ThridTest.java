package com.dassualts.biovia.testScripts.testcases;

import org.testng.annotations.Test;

import com.dassualts.biovia.Executor.ExecuteTestsBasedOnXLData;
import com.dassualts.biovia.testScripts.testBed.TestBed;

public class ThridTest extends TestBed
{
	@Test
	public void ThirdTest()
	{
		String sheetName = "ThridTest";
		
		ExecuteTestsBasedOnXLData execute = new ExecuteTestsBasedOnXLData(driver);
		
		//execute.ReadDataFromXLAndTriggerActionsInActionDriver(sheetName);
	}
	
	@Test
	public void ForthTest()
	{
		String sheetName = "ForthTest";
		
		ExecuteTestsBasedOnXLData execute = new ExecuteTestsBasedOnXLData(driver);
		
		//execute.ReadDataFromXLAndTriggerActionsInActionDriver(sheetName);
	}

}
