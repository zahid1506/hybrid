package com.dassualts.biovia.testScripts.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.dassualts.biovia.testScripts.testBed.TestBed;

public class CreateUser extends TestBed
{
	public static Logger log = Logger.getLogger("CreateUser");
	

	@Test
	public void createUser()
	{
		log.info("started the createUser test");
		
		System.out.println("createUser test is done");
		log.info("createUser test is done");
	}
}
