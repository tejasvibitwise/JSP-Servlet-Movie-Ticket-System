package com.bitwise.ServletMovieTicket.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class InputValidation {
	public static final String inputFormat = "HH:mm";
	SimpleDateFormat inputParser = new SimpleDateFormat(inputFormat, Locale.US);

	
	
	public boolean validate_str(String str)
	{
		if(str=="" || str.length()<=1) return false;
		else return true;
	
	}
	
	
	
	public boolean validate_time(String stime,String etime)
	{
		Calendar now = Calendar.getInstance();

	    int hour = now.get(Calendar.HOUR);
	    int minute = now.get(Calendar.MINUTE);

	   Date date = parseDate(hour + ":" + minute);
	    
	    Date dateCompareOne = parseDate(stime);
	    Date dateCompareTwo = parseDate(etime);
	    
	   
	    
	    if ( dateCompareOne.compareTo(dateCompareTwo)>0 || dateCompareOne.compareTo(dateCompareTwo)==0 ) {
	    	return false;
	    		        
	    }
	    else
	    {
	    	return true;
	    }
	}
	
	private Date parseDate(String date) {

	    try {
	        return inputParser.parse(date);
	    } catch (java.text.ParseException e) {
	        return new Date(0);
	    }
	}



	public boolean validate_date(String date) throws ParseException  {
		
		String dateString1 = "24-08-2016";
	    String dateString2="01-01-3000";

	    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	   
	    Date date1 = format.parse(dateString1);
	    Date date2 = format.parse(date);
	    Date date3=format.parse(dateString2);
	    
	    if(date2.before(date1) || date2.after(date3))
	    	return true;
//	    
//	    if ((date2.compareTo(date1) <0) || (date2.compareTo(date3)>0)) {
//	    	return false;
//	    }
	    else return false;
		
	}
	
	

}
