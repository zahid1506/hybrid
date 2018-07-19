package com.dassualts.biovia.parctice;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class CreateLogs {

	public static Logger log = Logger.getLogger("CreateLogs");
	
	public static void main(String[] args) 
	{
		
		BasicConfigurator.configure();
		DOMConfigurator.configure("Log4j.xml");
		
		log.info("Welcome to log generation");
		log.info("Log is initialized");

	}

}
