package com.dassualts.biovia.projectSpecific;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareTime {

	public static Logger log = Logger.getLogger("Compare Flight Time");
	
	public void IsDisplayedFlightTimeIsCorrect(List<String> timeFromUI )
	{
		
		Date date = new Date() ;
		log.info("Current Date and Time -->" + date);
		System.out.println(date);
		SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a") ;
		dateFormat.format(date);
		System.out.println(dateFormat.format(date));

		for (int i = 0; i < timeFromUI.size(); i++) {
			try 
			{
				log.info("Flight time is -->" + timeFromUI.get(i));
				if (dateFormat.parse(dateFormat.format(date)).before(dateFormat.parse(timeFromUI.get(i)))) 
				{
					System.out.println( dateFormat.format(date) + " Current time is less than " + timeFromUI.get(i));
					log.info(dateFormat.format(date) + " Current time is less than " + timeFromUI.get(i));
				} 
				else 
				{
					log.info(dateFormat.format(date) + " Current time greater than flight time " + timeFromUI.get(i));
					Assert.assertTrue(false, dateFormat.format(date) + " Current time greater than flight time " + timeFromUI.get(i));
					
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	@Test
	public void main()
	{
		List<String> lst = new ArrayList<String>();
		lst.add("6:30 am");
		lst.add("7:30 pm");
		
		CompareTime obj = new CompareTime();
		obj.IsDisplayedFlightTimeIsCorrect(lst);
		
	}

}
